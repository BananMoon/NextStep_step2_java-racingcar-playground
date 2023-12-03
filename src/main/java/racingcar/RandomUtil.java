package racingcar;

import java.util.List;
import java.util.Random;

public class RandomUtil {
    // 0 이상 ~ 10 미만 이어야 함.
    public static int getRandomNum() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public static void printWinCarNames(List<String> maxMovedCarNames) {
        String strCarNames = String.join(",", maxMovedCarNames);
        System.out.println(strCarNames + "가 최종 우승했습니다.");
    }
}
