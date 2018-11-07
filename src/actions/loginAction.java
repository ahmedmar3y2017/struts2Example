package actions;

import Model.Task;
import Model.User;
import Services.TaskTransaction;
import Services.loginTransactions;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class loginAction extends ActionSupport implements SessionAware {

    User user;

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

    private Map<String, Object> sessionAttributes = null;

    @Override
    public void setSession(Map<String, Object> sessionAttributes) {

        this.sessionAttributes = sessionAttributes;
    }

    public void validate() {

        if (!validate(user.getEmail())) {
            addActionError("email incorrect");
        }
        if (!validatePass(user.getPassword())) {

            addActionError("password incorrect");

        }


    }

    @Override
    public String execute() throws Exception {


        boolean s = loginTransactions.login(user.getEmail(), user.getPassword());

        if (s) {



            sessionAttributes.put("USER", user);

            return SUCCESS;

        } else {
            addActionError("Error Email Or Password ! Please try again!");

            return ERROR;

        }


    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
