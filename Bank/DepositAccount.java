package Bank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


public class DepositAccount extends BankAccount {

    private Date dateRefill;

    public DepositAccount(int balance) {
        super(balance);

    }

    public void refill(Date dateRefill, int sum) {
        super.setBalance(super.getBalance() + sum);
        this.dateRefill = dateRefill;


    }

    public void withdrawMoney(Date takeOfDate, int sum) {
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(takeOfDate);
        calendar.add(Calendar.DAY_OF_MONTH,-30);
        Date date = calendar.getTime(); // из календаря получаем дату назад
        if(date.after(dateRefill) ){
            withdrawMoney(sum);
        }
        else {
            System.out.println("Время еще не прошло");
        }
    }

    @Override
    public String toString() {
        return
                "Дата списания"+" " + dateRefill + " "
                        +"Баланс"  + " "+ super.getBalance();

    }
}