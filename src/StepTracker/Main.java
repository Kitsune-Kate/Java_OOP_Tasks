package StepTracker;


import java.time.Month;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker(10000);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("1")) {
                System.out.println("Введите номер месяца (1-12)");
                String month = scanner.nextLine();
                System.out.println("Введите номер дня (1-30)");
                String day = scanner.nextLine();
                System.out.println("Введите количество шагов ");
                String steps = scanner.nextLine();

                Month m = Month.of(Integer.parseInt(month)); //ссылочные переводятся через парс инт (функции)
                int number = Integer.parseInt(day);
                int step = Integer.parseInt(steps);
                stepTracker.putSteps(m, number, step); //stepTracker - обращение к объекту класса (по этому с маленькой)
                stepTracker.print();

            }
            if (userInput.equalsIgnoreCase("2")) {
                System.out.println("Введите номер месяца (1-12)");
                String month = scanner.nextLine();
                Month m = Month.of(Integer.parseInt(month));
                int sum = stepTracker.getStatistic(m);
                Converter.converterCalories(sum);
                Converter.converterKm(sum);
                stepTracker.getStatisticMax(m);
                stepTracker.getStatisticAverage(m);
                System.out.println(Converter.calories);
                System.out.println(Converter.kmSteps);
                System.out.println(Converter.kiloCalories);
                stepTracker.getDays(10000,m);








            }
            if (userInput.equalsIgnoreCase("3")) {
                stepTracker.setSteps(5000);

            }
            if (userInput.equalsIgnoreCase("4")) {
                System.out.println("Приложение закрыто");
                System.exit(0);
            }



        }

    }

    private static void printMenu() {
        System.out.println("1.Ввести количество шагов за определённый день");
        System.out.println("2.Напечатать статистику за определённый месяц");
        System.out.println("3.Изменить цель по количеству шагов в день");
        System.out.println("4.Выйти из приложения.");

    }
}