package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GamePlayerTest {
    @Test
    @DisplayName("자동차 이름은 ,로 구분한다.")
    void carNameSeparateTest() {
        String input = "moon,sun,water";
        assertThat(GamePlayer.separateCarName(input)).isEqualTo(new String[]{"moon", "sun", "water"});
    }

    @Test
    @DisplayName("구분된 자동차 이름으로 경주 참여 자동차 정보를 잘 생성하는가?")
    void createCarInfo() {
        List<String> separatedInputs = new ArrayList<>(Arrays.asList("moon", "sun", "water"));

        Car moon = new Car(separatedInputs.get(0));
        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.joinCar(separatedInputs);

        assertThat(gamePlayer.getCars().size()).isEqualTo(separatedInputs.size());
        assertThat(gamePlayer.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(gamePlayer.getCars().get(0).getName()).isEqualTo(moon.getName());
    }

    @Test
    @DisplayName("랜덤값이 4이상일 때만 전진하는가?")
    void moveCarByRandomNumTest() {
        int randomNum = 4;
        assertThat(GamePlayer.isMovingOrNot(randomNum)).isTrue();
    }
    @Test
    @DisplayName("랜덤값이 10이상 혹은 0 미만일 때 에러 발생하는가?")
    void randomNumIs10ErrorTest() {
        int over10 = 10;
        int under0 = -1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> GamePlayer.isMovingOrNot(over10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> GamePlayer.isMovingOrNot(under0));
    }

    // TODO 게임에 참여하는 자동차가 n회 움직여야 종료. 처음은 모두 '-' 상태
    // TODO 이걸 어떻게 테스트하지? GamePlayer에 게임 실행 횟수 필드를 추가해야하나?
    @Test
    @DisplayName("사용자 입력 횟수만큼 게임이 진행되면 게임을 종료한다.")
    void gameDoneTest() {
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차 이름 얻기 테스트")
    void getGameWinnerTest() {
        List<String> separatedInputs = new ArrayList<>(Arrays.asList("moon", "sun", "water"));
        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.joinCar(separatedInputs);
        List<Car> cars = gamePlayer.getCars();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        car1.move();
        car2.move();


        List<String> carNames = gamePlayer.getMaxMovedCarNames();
        assertThat(carNames.size()).isEqualTo(2);
        assertThat(carNames.containsAll(Arrays.asList(car1.getName(), car2.getName()))).isTrue();
    }
}
