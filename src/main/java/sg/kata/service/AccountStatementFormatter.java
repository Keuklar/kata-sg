package sg.kata.service;

import sg.kata.model.Account;
import sg.kata.model.AccountStatement;
import sg.kata.model.Operation;

import java.util.List;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class AccountStatementFormatter {

    public static final String SEPARATOR = " - ";

    public String format(AccountStatement accountStatement) {
        String formatAccount = format(accountStatement.getAccount());
        String formatOperations = format(accountStatement.getOperations());
        return  formatOperations + System.lineSeparator() + formatAccount;
    }

    private String format(List<Operation> operations) {
        return operations
                .stream()
                .map(this::formatOperation)
                .collect(joining(lineSeparator()));
    }

    private String formatOperation(Operation o) {
        return o.getDate().toString()
        + SEPARATOR
        + o.getOperationType()
        + SEPARATOR
        + o.getAmount();
    }

    private String format(Account account) {
        return "Balance " + account.getBalance().toString();
    }
}
