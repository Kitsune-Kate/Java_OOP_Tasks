package Bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        String sDate1 = "31/12/2022";
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

        String sDate2 = "15/02/2023";
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);


        DepositAccount depositAccount = new DepositAccount(2500);
        CardAccount cardAccount = new CardAccount(3000);

        depositAccount.refill(date1, 1000);
        depositAccount.withdrawMoney(date2,500);

        System.out.println(depositAccount.getBalance());

    }
}
