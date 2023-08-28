package Treker_task;

import StepTracker.StepTracker;

import java.time.Month;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Scanner scanner = new Scanner(System.in);
        manager.createTask();
        manager.createTask();
        manager.getSubtask(1); //id по сканеру


        while (true) {
            printMenu();
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("1")) {
                manager.getList();

            }
            if (userInput.equalsIgnoreCase("2")) {
               manager.clearList();

            }
            if (userInput.equalsIgnoreCase("3")) {
                System.out.println("Введите id");
                int id =  Integer.parseInt(scanner.nextLine());
               manager.readId(id);

            }
            if (userInput.equalsIgnoreCase("4")) {
                manager.createTask();
            }
            if (userInput.equalsIgnoreCase("5")) {
                System.out.println("Введите id и новую версию");
                int id =  Integer.parseInt(scanner.nextLine());
                Task task = new Task();
                manager.update(id,task);
            }
            if (userInput.equalsIgnoreCase("6")) {
                System.out.println("Введите id");
                int id =  Integer.parseInt(scanner.nextLine());
                manager.deleteId(id);
            }



        }

    }

    private static void printMenu() {
        System.out.println("1.Получить список задач");
        System.out.println("2.Удаление всех задач");
        System.out.println("3.Получение по идентификатору");
        System.out.println("4.Создание");
        System.out.println("5.Обновление ");
        System.out.println("6.Удаление по идентификатору ");

    }
}