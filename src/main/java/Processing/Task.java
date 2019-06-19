/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processing;

/**
 *
 * @author paul
 */
public class Task {
    int taskId;
    String taskContent;
    boolean taskCompleted;
    int jobId;

    public Task(int taskId, String taskContent, boolean taskCompleted, int jobId) {
        this.taskId = taskId;
        this.taskContent = taskContent;
        this.taskCompleted = taskCompleted;
        this.jobId = jobId;
    }

    public Task() {
    }
    
    

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    
    
    
}
