package Model;

import java.util.Date;

public class Task {

    private int id;
    private String taskName ;
    private Date begin;
    private Date end ;
    private String desc;
    private String manager_name;

    public Task() {
    }

    public Task(String taskName, Date begin, Date end, String desc, String manager_name) {
        this.taskName = taskName;
        this.begin = begin;
        this.end = end;
        this.desc = desc;
        this.manager_name = manager_name;
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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
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
}
