package sg.kata.model;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public Account(BigDecimal initialAmount) {
        validInitialAmount(initialAmount);
        this.balance = initialAmount;
    }

    private void validInitialAmount(BigDecimal initialAmount) {
        if (initialAmount == null || initialAmount.compareTo(BigDecimal.ZERO) < 0) {
           throw new IllegalArgumentException("Initial amount is required and must be positive");
        }
    }

    public BigDecimal deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public BigDecimal withDraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
        return this.balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }
}