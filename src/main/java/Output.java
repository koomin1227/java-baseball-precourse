public class Output {
    public static void printResult(Result result){
        int strikeCount = result.strikeCount();
        int ballCount = result.ballCount();
        if(strikeCount > 0){
            System.out.printf("%d스트라이크 ", strikeCount);
        }
        if(ballCount > 0){
            System.out.printf("%d볼 ", ballCount);
        }
        if(strikeCount == 0 && ballCount == 0){
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
