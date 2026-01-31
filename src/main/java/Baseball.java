import java.util.ArrayList;
import java.util.Scanner;

public class Baseball {
    private final Input input;

    public Baseball() {
        Scanner scanner = new Scanner(System.in);
        this.input = new Input(scanner);;
    }

    public void run() {
        boolean isContinue = true;
        while(isContinue){
            isContinue = playGame();
        }
    }

    private boolean playGame() {
        NumberGenerator generator = new RandomNumberGenerator();
        Computer computer = new Computer(generator);

        boolean isContinue;
        while (true) {
            ArrayList<Integer> numbers = input.inputNumbers();
            Result result = computer.checkNumbers(numbers);

            if (result.isAllStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
                break;
            }
            Output.printResult(result);
        }

        isContinue = input.inputContinue();
        return isContinue;
    }
}
