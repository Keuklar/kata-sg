package sg.kata.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.math.BigDecimal.TEN;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static sg.kata.model.OperationType.WITHHDRAW;

class OperationTest {

    @Test
    void on_ne_peut_pas_creer_d_operation_incomplete() {
        assertThrows(Exception.class, () -> new Operation(null, null, null));
    }


    @Test
    void equivalence_hascode_et_equals() {
        Operation o1 = new Operation(WITHHDRAW, LocalDate.of(2022, 2, 3), TEN);
        Operation o2 = new Operation(WITHHDRAW, LocalDate.of(2022, 2, 3), TEN);
        assertThat(o1).isNotSameAs(o2);
        assertThat(o1.equals(o2) && o2.equals(o1)).isTrue();
        assertThat(o1.hashCode() == o2.hashCode()).isTrue();
    }

}