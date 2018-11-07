package actions;

import Services.TaskTransaction;
import com.opensymphony.xwork2.ActionSupport;

public class deleteTaskAction extends ActionSupport {


    private int id;


    @Override
    public String execute() throws Exception {


        System.out.println(TaskTransaction.deleteTask(id));


        return "SUCCESS";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
