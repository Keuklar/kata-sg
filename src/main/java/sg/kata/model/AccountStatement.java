package sg.kata.model;

import java.util.List;

public class AccountStatement {
    private Account account;
    private List<Operation> operations;

    public AccountStatement(Account account, List<Operation> operations) {
        this.account = account;
        this.operations = operations;
    }

    public Account getAccount() {
        return account;
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
