package sg.kata.model;


import java.math.BigDecimal;

public class Account  {
    private BigDecimal balance;

    public Account(BigDecimal initialAmount) {
        validInitialAmount(initialAmount);
        this.balance = initialAmount;
    }

    public BigDecimal deposit(BigDecimal amount) {
        validateParameter(amount, "Deposit amount is required and must be positive");
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public BigDecimal withDraw(BigDecimal amount) {
        validateParameter(amount, "WithDraw amount is required and must be positive");
        this.balance = this.balance.subtract(amount);
        return this.balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    private void validInitialAmount(BigDecimal initialAmount) {
        validateParameter(initialAmount, "Initial amount is required and must be positive");
    }

    private void validateParameter(BigDecimal amount, String s) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(s);
        }
    }

}
