package sg.kata.repository;

import sg.kata.model.Account;
import sg.kata.model.Operation;

import java.util.List;

public interface OperationHistoryRepository {
    List<Operation> getHistory(Account account);
    void pushOperation(Account account, Operation operation);
}
