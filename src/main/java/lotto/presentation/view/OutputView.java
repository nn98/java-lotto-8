package lotto.presentation.view;

public class OutputView {

    public void printInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLotteries(int count, String lotteriesToString) {
        System.out.printf("%n%d개를 구매했습니다.%n%s%n", count, lotteriesToString);
    }

    public void printInputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(String statistics) {
        System.out.println("\n당첨 통계\n"
                + "---\n"
                + statistics);
    }

    public void printFinalYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }

    public void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void prinLine(String line) {
        System.out.println("\n" + line);
    }

}
