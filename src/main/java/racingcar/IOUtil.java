package racingcar;

import java.util.Scanner;

public class IOUtil {
    private static Scanner scanner;

    public IOUtil(Scanner scanner) {
        IOUtil.scanner = scanner;
    }

    public static String inputLine() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static int inputInt() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static void printCarMoveStatus(Car car) {
        System.out.print(car.getName() +" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
