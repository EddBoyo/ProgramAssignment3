public class Application {
    public static void main(String args[]) {
        SavingsAccount saver1 = new SavingsAccount((float) 2000.00);
        SavingsAccount saver2 = new SavingsAccount((float) 3000.00);
        saver1.modifyInterestRate((float) 0.04);
        for (int i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("saver1 balance with 4%% interest: %.2f\n", saver1.getBalance());
            System.out.printf("saver2 balance with 4%% interest: %.2f\n", saver2.getBalance());
        }
        saver1.modifyInterestRate((float) 0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("saver1 balance with 5%% interest: %.2f\n", saver1.getBalance());
        System.out.printf("saver2 balance with 5%% interest: %.2f\n", saver2.getBalance());
    }
}
