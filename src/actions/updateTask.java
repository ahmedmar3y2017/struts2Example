package actions;

import Services.TaskTransaction;
import com.opensymphony.xwork2.ActionSupport;

public class updateTask extends ActionSupport {
    private int id;
    private String taskName;
    private String desc;
    private String begin;
    private String end;
    private String manager_name;
    private String message;


    @Override
    public String execute() throws Exception {


        System.out.println(id + "    " + taskName + "    " + manager_name);

        this.message = TaskTransaction.updateTask(id, taskName, begin, end, desc, manager_name);


        return "SUCCESS";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
