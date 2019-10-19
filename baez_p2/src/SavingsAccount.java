public class SavingsAccount {
    private static float annualInterestRate;
    private float savingsBalance;

    public SavingsAccount(float inBalance) {

        this.savingsBalance = inBalance;
    }

    public static void modifyInterestRate(float change) {
        //float newInterestRate = (float) change * (float)0.01;
        annualInterestRate = change;
    }

    public void calculateMonthlyInterest() {
        float nextMonthBalance = this.savingsBalance * (annualInterestRate / (float) 12.0);
        this.savingsBalance += nextMonthBalance;
    }

    public float getBalance() {

        return this.savingsBalance;
    }
}
