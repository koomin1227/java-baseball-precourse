import java.util.ArrayList;

public class Baseball {

    public void run() {
        boolean isContinue = true;
        while(isContinue){
            isContinue = playGame();
        }
    }

    private static boolean playGame() {
        boolean isContinue;
        Computer computer = new Computer();

        while (true) {
            ArrayList<Integer> numbers = Input.inputNumbers();
            Result result = computer.checkNumbers(numbers);

            if (result.isAllStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
                break;
            }
            Output.printResult(result);
        }

        isContinue = Input.inputContinue();
        return isContinue;
    }
}
