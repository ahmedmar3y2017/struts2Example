package actions;

import Model.User;
import Services.signUpTransactions;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signUpAction extends ActionSupport implements ModelDriven<User> {
    User user;
    String MessageLogin;


    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*).{8,40})";
    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile(PASSWORD_PATTERN, Pattern.CASE_INSENSITIVE);

    public static boolean validatePass(String pass) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(pass);
        return matcher.matches();
    }

    @Override
    public String execute() throws Exception {

        // insert into user table
        int result = signUpTransactions.insertIntoUser(user);
        System.out.println(result);
        MessageLogin="Sign Up Successfully";
        return SUCCESS;
    }

    public void validate() {


// validate Ouputs
        if (!validate(user.getEmail())) {
            addActionError("email incorrect");
        }
        if (!validatePass(user.getPassword())) {

            addActionError("password incorrect");

        }
        if (!validatePass(user.getConfirm())) {

            addActionError("Confirm incorrect");

        }
        if (!user.getConfirm().equalsIgnoreCase(user.getPassword())) {

            addActionError("Password and Confirm not match");

        }
        // not correct Phone if contains character
        if (user.getPhone().length() < 11) {
            addActionError("Phone incorrect");


        }
        if (user.getName().length() == 0) {
            addActionError("Name incorrect");


        }
        if (user.getAddress().length() == 0) {
            addActionError("Address incorrect");


        }


    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        this.user = new User();
        return user;
    }

    public String getMessageLogin() {
        return MessageLogin;
    }

    public void setMessageLogin(String messageLogin) {
        MessageLogin = messageLogin;
    }
}
