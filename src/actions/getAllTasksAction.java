package actions;

import Model.Task;
import Services.TaskTransaction;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class getAllTasksAction extends ActionSupport {
    List<Task> dataList = null;
    private static final long serialVersionUID = 1L;
//    private List<String> dataList = null;

    @Override
    public String execute() throws Exception {
//        dataList = new ArrayList<>();
//        dataList.add("India");
//        dataList.add("USA");
//        dataList.add("Russia");
//        dataList.add("China");
//        dataList.add("Japan");

        // Get list Of Tasks
        dataList = TaskTransaction.getAllTasks();
        System.out.println("List New : " + dataList);


//        System.out.println("List is : " + dataList);
        return "SUCCESS";
    }
//
//    public List<String> getDataList() {
//        return dataList;
//    }
//
//    public void setDataList(List<String> dataList) {
//        this.dataList = dataList;
//    }


    public List<Task> getDataList() {
        return dataList;
    }

    public void setDataList(List<Task> dataList) {
        this.dataList = dataList;
    }
}
