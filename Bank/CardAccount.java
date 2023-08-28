package Bank;
//каждая 3 операция пополнения должна добавлять 5 рублей на счет
public class CardAccount extends BankAccount {


    public CardAccount(int balance) {
        super(balance);


    }
    public  void withdrawMoney(int residue){
        super.withdrawMoney(residue+residue/100);
    }
}
