package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 규칙
 * - 자동차 이름은 5자를 초과할 수 없다. 초과하는 자동차는 패스한다.
 */
public class GamePlayer {
    private static final int FORWARD_LIMIT_NUM = 4;
    private static final List<Car> cars = new ArrayList<>();

    public static String[] separateCarName(String input) {
        return input.split(",");
    }

    // 랜덤값에 따라 자동차의 전진 가능/불가능 여부를 구분한다.
    public static boolean isMovingOrNot(int randomNum) {
        if (randomNum < 0 || randomNum >= 10) {
            throw new IllegalArgumentException("랜덤값은 0~10 사이이어야 합니다.");
        }
        return randomNum >= FORWARD_LIMIT_NUM;
    }

    public void joinCar(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
    public List<Car> getCars() {
        return cars;
    }

    // 현재 cars들 중 가장 많이 이동한 차를 리스트에 담아서 전달한다.
    public List<String> getMaxMovedCarNames() {
        if (cars.size() == 0) {
            return Collections.emptyList();
        }

        List<Car> winners = new ArrayList<>();
        List<String> carNames = new ArrayList<>();
        int maxCarPositon = 0;

        for (Car car : cars) {
//            if (maxCarPositon < car.getPosition()) {
            if (maxCarPositon < car.getNewPosition().getPosition()) {
                winners = new ArrayList<>();   // reset
                winners.add(car);
                carNames.add(car.getName());
//                maxCarPositon = car.getPosition();
                maxCarPositon = car.getNewPosition().getPosition();
            }
//            else if (maxCarPositon == car.getPosition() && maxCarPositon > 0) {
            else if (maxCarPositon == car.getNewPosition().getPosition() && maxCarPositon > 0) {
                winners.add(car);
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    /**
     * 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
     * pobi,crong,honux
     * 시도할 회수는 몇회인가요?
     * 5
     */
    public void playGame() {
        // 1. 안내말 출력
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = new ArrayList<>(Arrays.asList(IOUtil.inputLine().split(",")));

        joinCar(carNames);
        if (cars.size() == 0) {
            System.out.println("경주할 자동차가 없으므로 경주가 종료됩니다.");
            return;
        }

        // 2. 사용자 입력 tryCount
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = IOUtil.inputInt();

        System.out.println("실행 결과\n");
        // 최초 1회 이동 및 출력
        for (Car car : cars) {
            car.move();
            IOUtil.printCarMoveStatus(car);
        }
        System.out.println();
        // 3. tryCount 번 만큼 랜덤값 얻으면서 자동차들 전진
        for (int i = 0; i <= tryCount; i++) {
            moveAllCars();
            System.out.println();
        }

        // 최종 출력
        for (Car car : cars) {
            IOUtil.printCarMoveStatus(car);
        }

        List<String> maxMovedCarNames = getMaxMovedCarNames();
        RandomUtil.printWinCarNames(maxMovedCarNames);
    }

    private void moveAllCars() {
        for (Car car : cars) {
            if (isMovingOrNot(RandomUtil.getRandomNum()) && isNotFinished(car)) {
                car.move();
            }
            IOUtil.printCarMoveStatus(car);
        }
    }

    private boolean isNotFinished(Car car) {
        return car.getNewPosition().getPosition() < 5;
    }

    public static void main(String[] args) {
//        Car moon = new Car("moon", 0);
//        Car yoon = new Car("yoon", 0);
//        Car ji = new Car("ji", 0);
//        List<Car> joinedCars = new ArrayList<>();
//        joinedCars.add(moon);
//        joinedCars.add(yoon);
//        joinedCars.add(ji);

        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.playGame();
    }
}
