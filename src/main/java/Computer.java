import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Computer {
    private final List<Integer> numbers;

    public Computer() {
        numbers = generateRandomNumbers();
    }

    public Result checkNumbers(List<Integer> inputNumbers) {
        int strikeCount = countStrike(inputNumbers);
        int ballCount = countBall(inputNumbers);

        return new Result(strikeCount, ballCount);
    }

    private int countStrike(List<Integer> inputNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (Objects.equals(numbers.get(i), inputNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(List<Integer> inputNumbers) {
        int count = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            int num = inputNumbers.get(i);
            if (numbers.contains(num) && numbers.get(i) != num) {
                count++;
            }
        }
        return count;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 3);
    }
}
