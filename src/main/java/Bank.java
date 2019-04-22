public class Bank {

    public double calculateYearlyInterest(Account account) {

        if (account.getBalance() <= 0) {
            return account.getBalance() * 0;
        }
        else if (account.getBalance() <= 100) {
            return account.getBalance() * 0.03;
        }
        else if (account.getBalance() <= 1000) {
            return account.getBalance() * 0.05;
        }
        else {
            return account.getBalance() * 0.07;
        }
    }
}
