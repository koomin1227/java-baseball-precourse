import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<Integer> inputNumbers() {
        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String input = scanner.next();
                return validateInputNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean inputContinue() {
        while (true) {
            try {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = scanner.next();
                return validateContinue(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private ArrayList<Integer> validateInputNumber(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        if (!isAllNumbers(input)) {
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        if (hasDuplicateNumbers(input)) {
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        return convertStringToNumbers(input);
    }

    private boolean isAllNumbers(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDuplicateNumbers(String input) {
        boolean[] used = new boolean[10];

        for (int i = 0; i < input.length(); i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if (used[num]) {
                return true;
            }
            used[num] = true;
        }
        return false;
    }

    private ArrayList<Integer> convertStringToNumbers(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return numbers;
    }

    private boolean validateContinue(String input) {
        if (input == null || input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        int inputNumber = Character.getNumericValue(input.charAt(0));
        if (inputNumber != 1 && inputNumber != 2) {
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        return inputNumber == 1;
    }
}