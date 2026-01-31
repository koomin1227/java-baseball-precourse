import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    @Test
    void allStrike_returns3Strike0Ball() {
        // given
        Computer computer = new Computer(
                new FixedNumberGenerator(Arrays.asList(1, 2, 3))
        );
        List<Integer> input = Arrays.asList(1, 2, 3);

        // when
        Result result = computer.checkNumbers(input);

        // then
        assertEquals(3, result.strikeCount());
        assertEquals(0, result.ballCount());
    }

    @Test
    void oneStrike_oneBall() {
        // secret: 4 2 5
        // guess : 4 5 6
        Computer computer = new Computer(
                new FixedNumberGenerator(Arrays.asList(4, 2, 5))
        );
        List<Integer> input = Arrays.asList(4, 5, 6);

        Result result = computer.checkNumbers(input);

        assertEquals(1, result.strikeCount());
        assertEquals(1, result.ballCount());
    }

    @Test
    void onlyBalls_returns0Strike2Ball() {
        // secret: 4 2 5
        // guess : 2 4 6
        Computer computer = new Computer(
                new FixedNumberGenerator(Arrays.asList(4, 2, 5))
        );
        List<Integer> input = Arrays.asList(2, 4, 6);

        Result result = computer.checkNumbers(input);

        assertEquals(0, result.strikeCount());
        assertEquals(2, result.ballCount());
    }

    @Test
    void nothing_returns0Strike0Ball() {
        // secret: 4 2 5
        // guess : 7 8 9
        Computer computer = new Computer(
                new FixedNumberGenerator(Arrays.asList(4, 2, 5))
        );
        List<Integer> input = Arrays.asList(7, 8, 9);

        Result result = computer.checkNumbers(input);

        assertEquals(0, result.strikeCount());
        assertEquals(0, result.ballCount());
    }

    @Test
    void mixedCase_returnsCorrectCounts() {
        // secret: 1 2 3
        // guess : 1 3 2
        Computer computer = new Computer(
                new FixedNumberGenerator(Arrays.asList(1, 2, 3))
        );
        List<Integer> input = Arrays.asList(1, 3, 2);

        Result result = computer.checkNumbers(input);

        assertEquals(1, result.strikeCount());
        assertEquals(2, result.ballCount());
    }
}