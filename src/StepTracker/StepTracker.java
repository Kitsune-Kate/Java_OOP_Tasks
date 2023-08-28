package StepTracker;

import java.sql.SQLOutput;
import java.time.Month;
import java.util.*;

public class StepTracker {

    private int steps;



    private LinkedHashMap<Month, ArrayList<Day> > monthToData = new LinkedHashMap();

    public StepTracker(int steps) { //если вызываю функцию в конструкторе то она будет  приватная
        this.steps=steps;
        initialization();
    }

    private  void initialization (){
        for (Month m :Month.values()) {//
            ArrayList<Day> days = new ArrayList<>();
            for (int i = 1; i < 31; i++) {
                Day day = new Day(i,0);
                days.add(day);

            }
            monthToData.put(m,days);
        }

    }
    public void print (){
        for (Map.Entry<Month, ArrayList<Day>> monthArrayListEntry : monthToData.entrySet()) {
            System.out.println(monthArrayListEntry.getKey());
            for (Day d: monthArrayListEntry.getValue()) {
                System.out.print(" " +d + ";");

            }
            System.out.println();
        }

    }
    public int getStatistic (Month m){
        ArrayList<Day>  daySteps= monthToData.get(m);
        System.out.println(m);
        int sum = 0;
        for (Day d: daySteps ) {
            System.out.print(d);
            System.out.print("; ");
            sum = sum+d.getSteps();
        }

        System.out.println("Сумма шагов"+" " +sum);

        return sum;

    }
    public int  getStatisticMax(Month m){
        ArrayList<Day>  daySteps= monthToData.get(m);

        int max = 0;
        for (Day d: daySteps ) {
            if (d.getSteps()>max){
                max=d.getSteps();
            }
        }
        System.out.println(max);
        return max;
    }
    public int  getStatisticAverage(Month m){
        ArrayList<Day>  daySteps= monthToData.get(m);
        int sum = 0;
        int count=0;
        for (Day d: daySteps ) {
            sum = sum+d.getSteps();
            if (d.getSteps()>0){
                count = count +1;
            }
        }
        int average=sum/count;
        System.out.println(average);
        return average;
    }
    public int getDays(int steps,Month m){
        ArrayList<Day>  daySteps= monthToData.get(m);
        int result=0;
        int countDays = 0;
        for (Day d: daySteps ) {
            if (d.getSteps()>=steps ) {
                countDays = countDays + 1;
            }
            else {
                countDays=0;
            }
            if    (countDays>result){
                result=countDays;
            }
        }
        System.out.println(result);

        return result;
}


    public void putSteps (Month m, int number , int steps){
        ArrayList<Day> months= monthToData.get(m);
        for (int i = 0; i < months.size(); i++) {
            if(number==months.get(i).getDay()){
                months.get(i).setSteps(steps);
            }
        }
        monthToData.replace(m,months);
    }



    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }


}