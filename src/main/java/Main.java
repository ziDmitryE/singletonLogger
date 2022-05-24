import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int size = 0;
        int maxValue = 0;
        int f = 0;

        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
        } else {
            logger.log("Вы ввели не число. Перезапустите программу и попробуйте снова!");
            throw new IllegalArgumentException();
        }
        System.out.print("Введите верхнюю границу для значений: ");
        if (scanner.hasNextInt()) {
            maxValue = scanner.nextInt();
        } else {
            logger.log("Вы ввели не число. Перезапустите программу и попробуйте снова!");
            throw new IllegalArgumentException();
        }
        logger.log("Создаём и наполняем список");
        System.out.print("Вот случайный список: ");
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxValue) + 1);
            System.out.print(list.get(i) + " ");
        }
        System.out.println("");
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        if (scanner.hasNextInt()) {
            f = scanner.nextInt();
        } else {
            logger.log("Вы ввели не число. Перезапустите программу и попробуйте снова!");
            throw new IllegalArgumentException();
        }
        Filter filter = new Filter(f);
        filter.filterOut(list);

        scanner.close();
    }
}
