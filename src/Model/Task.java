package Model;


public class Task {

    private int id;
    private String taskName;
    private String begin;
    private String end;
    private String desc;
    private String manager_name;
    private String message;


    public Task() {
    }


    public Task(int id, String taskName, String begin, String end, String desc, String manager_name, String message) {
        this.id = id;
        this.taskName = taskName;
        this.begin = begin;
        this.end = end;
        this.desc = desc;
        this.manager_name = manager_name;
        this.message = message;
    }

    public Task(int id, String taskName, String begin, String end, String desc, String manager_name) {
        this.id = id;
        this.taskName = taskName;
        this.begin = begin;
        this.end = end;
        this.desc = desc;
        this.manager_name = manager_name;

    }


    public Task(String taskName, String begin, String end, String desc, String manager_name) {
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


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
