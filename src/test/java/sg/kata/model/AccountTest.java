package sg.kata.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class AccountTest {


    @Test
    void je_ne_peux_pas_creer_de_compte_sans_somme_de_depart() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(null));
    }

    @Test
    void je_ne_peux_pas_creer_de_compte_avec_une_somme_de_depart_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(new BigDecimal("-123")));
    }

    @Test
    void je_ne_peux_pas_deposer_une_somme_d_argent_negative() {
        // given
        Account account = new Account(new BigDecimal("1000"));
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.deposit(new BigDecimal("-20")));
    }

    @Test
    void je_ne_peux_pas_retirer_une_somme_d_argent_negative() {
        // given
        Account account = new Account(new BigDecimal("1000"));
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.withDraw(new BigDecimal("-20")));
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
