package Treker_task;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Manager {
    private ArrayList<Task> tasks;
    Scanner scanner = new Scanner(System.in);

    public Manager() {
        tasks = new ArrayList<>();
    }

    public void getList() {
        for (Task t : tasks) {
            if (t.getClass() == Task.class) {
                System.out.println("Tasks" + " " + t);
            }
            if (t.getClass() == Epic.class) {
                System.out.println("Epic Name" + " " + t.getName());
                ArrayList<Subtask> sub=((Epic) t).getSubtasks();
                for (Subtask s: sub) {
                    System.out.println(s);
                }
                for (Subtask i : ((Epic) t).getSubtasks()) {
                    System.out.println("Subtasks Name" + " " + i.getName());
                }

            }
        }

    }
    public void getSubtask(int id){

        for (Task t : tasks) {
            if(t.getClass()== Epic.class && t.getId()==id){
                ArrayList<Subtask> subtasks=((Epic) t).getSubtasks();
                for (Subtask s: subtasks) {
                    System.out.println(s);

                }

            }
        }


    }

    public void clearList() {
        tasks.clear();
    }

    public void readId(int id) {
        for (Task t : tasks) {
            if (id == t.getId()) {
                System.out.println(t);
            }
        }
    }

    public void epics() {
        for (Task t : tasks) {
            if (t.getClass() == Epic.class) {
                System.out.println(t.getName());
            }

        }
    }

    public Epic returnEpic(String name) {
        epics();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                return (Epic) tasks.get(i);
            }
        }
        return null;
    }

    public void createTask() {
        System.out.println("Выберите тип задачи : 1- Task, 2-Subtask, 3- Epic");
        String scan1 = scanner.nextLine();
        Task task = new Task();
        if (scan1.equalsIgnoreCase("2")) {
            System.out.println("Выберите из списка Epics");
            epics();
            System.out.println("Введите имя Epic");
            Epic epic = returnEpic(scanner.nextLine());

            Subtask subtask = new Subtask();
            subtask.setEpic(epic);
            task = subtask;

        }
        if (scan1.equalsIgnoreCase("3")) {
            task = new Epic();
        }

        System.out.println("Введите имя");

        String name = scanner.nextLine();
        task.setName(name);
        System.out.println("Введите описание");
        String description = scanner.nextLine();
        task.setDescription(description);
        System.out.println("Введите id");
        int id = Integer.parseInt(scanner.nextLine());
        task.setId(id);
        System.out.println("Введите статус");
        System.out.println("1-new,2-done,3-in progress");
        String scan = scanner.nextLine();
        if (scan.equalsIgnoreCase("1")) {
            Status status = Status.New;
            task.setStatus(status);
        }
        if (scan.equalsIgnoreCase("2")) {
            Status status = Status.Done;
            task.setStatus(status);
        }
        if (scan.equalsIgnoreCase("3")) {
            Status status = Status.In_Progress;
            task.setStatus(status);
        }
        if (task.getClass() == Subtask.class) {
           Epic epic1= ((Subtask) task).getEpic();
           int index = tasks.indexOf(epic1);
            ArrayList<Subtask> sub = (epic1.getSubtasks());
            sub.add((Subtask) task);
            epic1.setSubtasks(sub);
            tasks.set(index,epic1);
        }
        tasks.add(task);

    }

    public void update(int id, Task task) {
        for (Task t : tasks) {
            if (id == t.getId()) {
                tasks.set(t.getId(), task);
            }
        }
    }

    public void deleteId(int id) {
        for (Task t : tasks) {
            if (id == t.getId()) {
                tasks.remove(t);
            }
        }
    }
}
