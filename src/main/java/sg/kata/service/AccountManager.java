package sg.kata.service;

import sg.kata.model.Account;
import sg.kata.model.Operation;
import sg.kata.repository.AccountRepository;
import sg.kata.repository.OperationHistoryRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static sg.kata.model.OperationType.*;

public class AccountManager {
    private AccountRepository accountRepository;
    private OperationHistoryRepository operationHistoryRepository;

    public AccountManager(AccountRepository accountRepository, OperationHistoryRepository operationHistoryRepository) {
        this.accountRepository = accountRepository;
        this.operationHistoryRepository = operationHistoryRepository;
    }

    public void whithDraw(Account account, BigDecimal amount) {
        account.withDraw(amount);
        accountRepository.saveAccount(account);
        operationHistoryRepository.pushOperation(account, new Operation(WITHHDRAW, LocalDate.now(), amount));
    }

    public void deposit(Account account, BigDecimal amount) {
        account.deposit(amount);
        accountRepository.saveAccount(account);
        operationHistoryRepository.pushOperation(account, new Operation(DEPOSIT, LocalDate.now(), amount));
    }

    public List<Operation> consultOperationsHistory(Account account) {
        return operationHistoryRepository.getHistory(account);
    }

}
