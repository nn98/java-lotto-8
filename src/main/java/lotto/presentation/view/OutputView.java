package lotto.presentation.view;

import lotto.common.constant.ErrorMessage;

public class OutputView {

    public static void printInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedLotteries(int count, String lotteriesToString) {
        System.out.printf("\n%d개를 구매했습니다.\n%s", count, lotteriesToString);
    }

    public static void printInputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusNumbers() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatistics(String statistics) {
        System.out.println("\n당첨 통계\n"
                + "---"
                + statistics);
    }

    public static void printFinalYield(int yield) {
        System.out.printf("총 수익률은 %d%%입니다.", yield);
    }

    public static void printError(Exception exception) {
        System.out.println("\n" + exception.getMessage());
    }

    public static void prinLine(String line) {
        System.out.println("\n" + line);
    }

}
