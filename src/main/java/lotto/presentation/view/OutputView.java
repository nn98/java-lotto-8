package lotto.presentation.view;

public class OutputView {

    public static void printInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCountByAmount(int count) {
        System.out.printf("%d개를 구매했습니다.", count);
    }

    public static void printInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatistics(String statistics) {
        System.out.println("당첨 통계\n"
                + "---"
                + statistics);
    }

    public static void printFinalYield(int yield) {
        System.out.printf("총 수익률은 %d%%입니다.", yield);
    }

}
