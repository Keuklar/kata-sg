package sg.kata.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Operation {
    private OperationType operationType;
    private LocalDate date;
    private BigDecimal amount;

    public Operation(OperationType operationType, LocalDate date, BigDecimal amount) {
        validateOperationParameters(operationType, date, amount);
        this.operationType = operationType;
        this.date = date;
        this.amount = amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private void validateOperationParameters(OperationType operationType, LocalDate date, BigDecimal amount) {
        if (operationType == null || date == null || amount == null) {
            throw new IllegalArgumentException("All parameters must be provided");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationType == operation.operationType &&
                date.equals(operation.date) &&
                amount.equals(operation.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, date, amount);
    }
}
