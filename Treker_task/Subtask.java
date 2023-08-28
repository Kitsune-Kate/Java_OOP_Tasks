package Treker_task;

public class Subtask extends Task{
    private Epic epic;

    public Subtask (String name, String description, int id, Status status, Epic epic){
        super(name, description, id, status);
        this.epic=epic;
    }
    public Subtask(){

    }

    @Override
    public String toString() {
        return "Subtask Name" + " " + super.getName() ;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }
}
