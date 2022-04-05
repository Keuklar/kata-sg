package sg.kata.service;

import org.fest.assertions.Assertions;
import org.junit.jupiter.api.Test;
import sg.kata.model.Account;
import sg.kata.model.Operation;
import sg.kata.repository.AccountRepository;
import sg.kata.repository.OperationHistoryRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ONE;
import static java.time.LocalDate.now;
import static sg.kata.model.OperationType.DEPOSIT;
import static sg.kata.model.OperationType.WITHHDRAW;

class AccountManagerTest {

    @Test
    void whithDraw() {
        // given
        AccountRepository accountRepository = getAccountRepository(BigDecimal.TEN);
        Account account = accountRepository.getAccount();
        AccountManager accountManager = new AccountManager(accountRepository, getOperationHistoryRepository());
        //when
        accountManager.whithDraw(account, ONE);
        //then
        Account accountFinal = accountRepository.getAccount();
        Assertions.assertThat(accountFinal).isNotNull();
        Assertions.assertThat(accountFinal.getBalance()).isEqualByComparingTo(new BigDecimal("9"));
    }


    @Test
    void deposit() {
        // given
        AccountRepository accountRepository = getAccountRepository(BigDecimal.TEN);
        Account account = accountRepository.getAccount();
        AccountManager accountManager = new AccountManager(accountRepository, getOperationHistoryRepository());
        //when
        accountManager.deposit(account, ONE);
        //then
        Account accountFinal = accountRepository.getAccount();
        Assertions.assertThat(accountFinal).isNotNull();
        Assertions.assertThat(accountFinal.getBalance()).isEqualByComparingTo(new BigDecimal("11"));
    }

    @Test
    void consultOperationsHistory() {
        // given
        AccountRepository accountRepository = getAccountRepository(BigDecimal.TEN);
        Account account = accountRepository.getAccount();
        OperationHistoryRepository operationHistoryRepository = getOperationHistoryRepository();
        AccountManager accountManager = new AccountManager(accountRepository, operationHistoryRepository);

        // when
        accountManager.deposit(account, ONE);
        accountManager.whithDraw(account, new BigDecimal("2"));
        accountManager.deposit(account, new BigDecimal("3"));

        // then
        List<Operation> history = accountManager.consultOperationsHistory(account);
        Assertions.assertThat(history).isNotNull();
        Assertions.assertThat(history.size()).isEqualTo(3);
        Assertions.assertThat(history.get(0)).isEqualTo(new Operation(DEPOSIT, now(), ONE));
        Assertions.assertThat(history.get(1)).isEqualTo(new Operation(WITHHDRAW, now(), new BigDecimal("2")));
        Assertions.assertThat(history.get(2)).isEqualTo(new Operation(DEPOSIT, now(), new BigDecimal("3")));
    }


    private AccountRepository getAccountRepository(BigDecimal initialDefaultValue) {
        return new AccountRepository() {
            private Account account = new Account(initialDefaultValue);
            @Override
            public Account getAccount() {
                return this.account;
            }

            @Override
            public void saveAccount(Account account) {
                this.account = account;
            }
        };
    }

    private OperationHistoryRepository getOperationHistoryRepository() {
        return new OperationHistoryRepository() {
            private List<Operation> operationHistory = new ArrayList<>();
            @Override
            public List<Operation> getHistory(Account account) {
                return this.operationHistory;
            }

            @Override
            public void pushOperation(Account account, Operation operation) {
                this.operationHistory.add(operation);
            }
        };
    }

}