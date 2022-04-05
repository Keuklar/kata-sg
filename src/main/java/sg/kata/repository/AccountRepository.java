package sg.kata.repository;

import sg.kata.model.Account;

public interface AccountRepository {

    Account getAccount();
    void saveAccount(Account account);
}
