public record Result(int strikeCount, int ballCount) {

    public Boolean isAllStrike() {
        return strikeCount == 3;
    }
}
