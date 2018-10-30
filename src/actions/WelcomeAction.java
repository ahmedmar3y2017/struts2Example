package actions;

import Interceptor.UserAware;
import Model.Task;
import Model.User;
import Services.TaskTransaction;
import Services.signUpTransactions;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.sql.SQLException;
import java.util.List;


public class WelcomeAction extends ActionSupport implements UserAware, ModelDriven<User> {
    private static final long serialVersionUID = 8111120314704779336L;


    @Override
    public String execute() throws SQLException {




        return SUCCESS;
    }

    private User user;

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser(User user) {
        return this.user;
    }

    @Override
    public User getModel() {
        return this.user;
    }


    public User getUser() {
        return user;
    }
}
