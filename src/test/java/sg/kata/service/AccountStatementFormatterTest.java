package sg.kata.service;

import org.fest.assertions.Assertions;
import org.junit.jupiter.api.Test;
import sg.kata.model.Account;
import sg.kata.model.AccountStatement;
import sg.kata.model.Operation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.util.Arrays.asList;
import static sg.kata.model.OperationType.DEPOSIT;
import static sg.kata.model.OperationType.WITHHDRAW;

class AccountStatementFormatterTest {

    @Test
    void format() {
        AccountStatementFormatter accountStatementFormatter = new AccountStatementFormatter();
        ArrayList<Operation> operations = new ArrayList<>(
            asList(
                new Operation(WITHHDRAW, LocalDate.of(2022, 1, 3), new BigDecimal("233.10")),
                new Operation(DEPOSIT, LocalDate.of(2022, 1, 4), new BigDecimal("1000.33")),
                new Operation(WITHHDRAW, LocalDate.of(2022, 1, 5), new BigDecimal("35.62")),
                new Operation(WITHHDRAW, LocalDate.of(2022, 1, 6), new BigDecimal("44.12"))
            ));
        String format = accountStatementFormatter.format(new AccountStatement(new Account(new BigDecimal("315.06")), operations));
        Assertions.assertThat(format).isEqualTo(
                "2022-01-03 - WITHHDRAW - 233.10" + System.lineSeparator() +
                        "2022-01-04 - DEPOSIT - 1000.33" + System.lineSeparator() +
                        "2022-01-05 - WITHHDRAW - 35.62" + System.lineSeparator() +
                        "2022-01-06 - WITHHDRAW - 44.12" + System.lineSeparator() +
                        "Balance 315.06");
    }
}