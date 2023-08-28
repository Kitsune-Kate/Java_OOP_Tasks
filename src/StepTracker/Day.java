package StepTracker;

public class Day { //модель данных, нет логики
    private int day;
    private int steps;


    public Day(int day, int steps) {
        this.day = day;
        this.steps = steps;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return   day+" " +"день:"+
                " " + steps ;
    }
}