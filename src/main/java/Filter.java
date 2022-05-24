import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");

        source.stream()
                .forEach(s -> {
                    if (s < treshold) {
                        logger.log("Элемент " + s + " не проходит");
                    } else {
                        logger.log("Элемент " + s + " проходит");
                    }
                });

        Long count = source.stream()
                .filter(s -> s > treshold)
                .count();
        logger.log("Прошло фильтр " + count + " элемента из " + source.size());

        List<Integer> result = source.stream()
                .filter(s -> s > treshold)
                .collect(Collectors.toList());

        System.out.print("Отфильтрованный список: ");
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println("");

        logger.log("Завершаем программу");

        return result;
    }
}
