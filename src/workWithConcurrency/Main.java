package workWithConcurrency;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(3000);
        Thread thread2 = new Thread(() -> bankAccount.withdraw(2200));
        Thread thread1 = new Thread(() -> {
            bankAccount.withdraw(2000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread2.start();
        thread1.start();


        System.out.println(bankAccount.getBalance());
    }
}
