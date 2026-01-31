import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static ArrayList<Integer> inputNumbers(){
        while (true){
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String input =  scanner.next();
                return validateInputNumber(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Boolean inputContinue(){
        while (true){
            try {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = scanner.next();
                return validateContinue(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static ArrayList<Integer> validateInputNumber(String input){
        if (input == null || input.length() != 3){
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        if (!isAllNumbers(input)){
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        if (hasDuplicateNumbers(input)){
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        return convertStringToNumbers(input);
    }

    private static Boolean isAllNumbers(String input){
        for (int i = 0; i< input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicateNumbers(String input) {
        boolean[] used = new boolean[10]; // 0~9 체크용

        for (int i = 0; i < input.length(); i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if (used[num]) {
                return true; // 이미 나온 숫자
            }
            used[num] = true;
        }
        return false;
    }

    private static ArrayList<Integer> convertStringToNumbers(String input){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i< input.length(); i++){
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return numbers;
    }

    private static boolean validateContinue(String input){
        if (input == null || input.length() != 1){
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        if (!Character.isDigit(input.charAt(0))){
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        int inputNumber = Character.getNumericValue(input.charAt(0));
        if (inputNumber != 1 && inputNumber != 2){
            throw new IllegalArgumentException("[ERROR] Invalid input");
        }
        return inputNumber == 1;
    }
}
