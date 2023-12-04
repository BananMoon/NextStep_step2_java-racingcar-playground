package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 일급 컬렉션 사용하기
 * - car를 추가하고 나면 삭제할 일이 없다면, 일급 컬렉션을 사용하여 remove 메서드를 제공하지 않을 수 있다.
 * - 클래스 전체에서 공유하는 변수라면 클래스 변수로 하되, 자동차 게임 별 혹은 자동차 별로 상태값 관리가 필요한 경우이므로 인스턴스 변수로 선언하는 것이 바람직하다.
 */
public class Cars {
    private final List<Car> cars;


    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        if (cars.size() == 0) {
            return Collections.emptyList();
        }

        // 현재 cars들 중 가장 많이 이동한 차를 리스트에 담아서 전달한다.
        List<Car> winners = new ArrayList<>();
        Position maxCarPositon = new Position(0);

        for (Car car : cars) {
            if (car.isWinner(maxCarPositon)) {
                winners = new ArrayList<>();   // reset
                winners.add(car);

                maxCarPositon = car.getNewPosition();
            } else if (car.isJointWinner(maxCarPositon)) {
                winners.add(car);
            }
        }
        return winners;
    }

}
