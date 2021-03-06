package actions;

import Model.Task;
import Model.User;
import Services.TaskTransaction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Map;

public class insertTaskAction extends ActionSupport {

    private String message;


    // variables
    private String taskName;
    private String begin;
    private String end;
    private String desc;
    private String manager_name;
    private Task task;

    @Override
    public String execute() throws Exception {


        this.task = TaskTransaction.saveTask(taskName, begin, end, desc, manager_name);

        return "SUCCESS";

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
