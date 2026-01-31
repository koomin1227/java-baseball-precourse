import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void inputNumbers_validInput_returnsDigits() {
        // given
        Input input = new Input(new Scanner("123\n"));

        // when
        ArrayList<Integer> result = input.inputNumbers();

        // then
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void inputNumbers_duplicate_thenValid_returnsValidDigits() {
        // given
        Input input = new Input(new Scanner("112\n789\n"));

        // when
        ArrayList<Integer> result = input.inputNumbers();

        // then
        assertEquals(Arrays.asList(7, 8, 9), result);
    }

    @Test
    void inputNumbers_nonDigit_thenValid_returnsValidDigits() {
        // given
        Input input = new Input(new Scanner("12a\n456\n"));

        // when
        ArrayList<Integer> result = input.inputNumbers();

        // then
        assertEquals(Arrays.asList(4, 5, 6), result);
    }

    @Test
    void inputNumbers_wrongLength_thenValid_returnsValidDigits() {
        // given
        Input input = new Input(new Scanner("12\n987\n"));

        // when
        ArrayList<Integer> result = input.inputNumbers();

        // then
        assertEquals(Arrays.asList(9, 8, 7), result);
    }

    @Test
    void inputContinue_input1_returnsTrue() {
        // given
        Input input = new Input(new Scanner("1\n"));

        // when
        boolean result = input.inputContinue();

        // then
        assertTrue(result);
    }

    @Test
    void inputContinue_input2_returnsFalse() {
        // given
        Input input = new Input(new Scanner("2\n"));

        // when
        boolean result = input.inputContinue();

        // then
        assertFalse(result);
    }

    @Test
    void inputContinue_invalid_then1_returnsTrue() {
        // given
        Input input = new Input(new Scanner("3\n1\n"));

        // when
        boolean result = input.inputContinue();

        // then
        assertTrue(result);
    }

    @Test
    void inputContinue_nonDigit_then2_returnsFalse() {
        // given
        Input input = new Input(new Scanner("a\n2\n"));

        // when
        boolean result = input.inputContinue();

        // then
        assertFalse(result);
    }
}