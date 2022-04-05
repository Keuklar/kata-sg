package sg.kata.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class AccountTest {


    @Test
    void je_ne_peux_pas_creer_de_compte_sans_somme_de_depart() {
        Assertions.assertThrows(Exception.class, () -> {
            new Account(null);
        });
    }

    @Test
    void je_ne_peux_pas_creer_de_compte_avec_une_somme_de_depart_negative() {
        Assertions.assertThrows(Exception.class, () -> {
            new Account(new BigDecimal("-123"));
        });
    }

    @Test
    void si_mon_solde_courant_est_de_1000_et_que_je_depose_20_mon_noveau_solde_est_1020() {
        // given
        Account account = new Account(new BigDecimal("1000"));
        // when
        account.deposit(new BigDecimal("20"));
        // then
        Assertions.assertEquals(new BigDecimal("1020"), account.getBalance());
    }

    @Test
    void si_mon_solde_courant_est_de_1000_et_que_je_retire_20_mon_noveau_solde_est_980() {
        // given
        Account account = new Account(new BigDecimal("1000"));
        // when
        account.withDraw(new BigDecimal("20"));
        // then
        Assertions.assertEquals(new BigDecimal("980"), account.getBalance());
    }
}
