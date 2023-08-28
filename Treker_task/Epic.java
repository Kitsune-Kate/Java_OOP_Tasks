package Treker_task;

import java.util.ArrayList;

public class Epic  extends  Task{
    private ArrayList <Subtask > subtasks;

    public Epic (String name, String description, int id, Status status){
        super(name, description, id, status);
        subtasks = new ArrayList<>();
    }
public Epic(){
    subtasks = new ArrayList<>();
}
    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public String toString() {
        return "Epic" + "subtasks=" + subtasks +"Name" + " " + super.getName() +  " "
                + "description" +" " + super.getDescription()+ " " +"id"+ " " + super.getId() + "" + "status " + " "+ super.getStatus();
    }
}
