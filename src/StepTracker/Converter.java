package StepTracker;

public class Converter {//если класс с логикой , создаем статические функции, объекты создают от тех классов которые явяются моделями данных
    static int kmSteps = 0; //глобальные поля
    static int calories = 0;
    static double kiloCalories = 0;



    public static void converterKm(int steps) {
        int cmSteps = steps * 75;
        kmSteps = cmSteps / 100000;

    }

    public static void converterCalories(int steps) {
        calories = steps * 50;
        kiloCalories = (double) calories / 1000;
    }



}
