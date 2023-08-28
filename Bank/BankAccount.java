package Bank;

//Создайте класс BankAccount, который представляет собой расчётный счёт в банке. У класса необходимо написать методы:
//
//a. Снять со счёта сумму денег (без комиссии).
//
//b. Вносить на счёт сумму денег (без комиссии).
//
//c. Получить остаток на счёте.
//
//Создайте два класса наследника, расширяющие работу с остатком на счёте:
//
//Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца после последнего внесения.
//Карточный счёт, при снятии денег с которого будет взиматься комиссия 1%.


public class BankAccount {
    private int balance;
    private int count;

    public void withdrawMoney(int residue) {
        if ((balance > residue || balance == residue) && residue > 0) {
            balance = balance - residue;

        }
    }

    public void depositMoney(int sum) {
        balance = balance + sum;
        count = count + 1;
        depositPlus(sum);

    }

    public void depositPlus(int sum) {
        if (count % 3 == 0) {
            sum = sum + 5;
        }
    }



    public void print() {
        System.out.println(balance);
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}