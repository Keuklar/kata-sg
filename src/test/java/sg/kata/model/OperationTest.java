package sg.kata.model;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void on_ne_peut_pas_creer_d_operation_incomplete() {
        assertThrows(Exception.class, () -> new Operation(null, null, null));
    }

}