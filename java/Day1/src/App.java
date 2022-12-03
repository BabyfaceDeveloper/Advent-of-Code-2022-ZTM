import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    private final static String ROOT_PATH = Paths.get(System.getProperty("user.dir")).getParent().getParent()
            .toString();

    public static void main(String[] args) throws Exception {
        var calories = Day1();
        // Part 1
        System.out.println(calories.get(calories.size() - 1));
        // Part 2
        System.out.println(calories.stream().skip(calories.size() - 3).reduce(0, Integer::sum));
    }

    private static List<Integer> Day1() throws IOException {
        var day1_file = Paths.get(ROOT_PATH, "inputs", "day1.txt");
        var lines = Files.lines(day1_file).map(line -> line.strip()).toList();
        var total_calories = 0;
        var calories = new ArrayList<Integer>();
        for (String line : lines) {
            if (line.length() > 0 && line.chars().allMatch(Character::isDigit)) {
                total_calories += Integer.parseInt(line);
            } else {
                calories.add(total_calories);
                total_calories = 0;
            }
        }
        Collections.sort(calories);
        return calories;
    }
}
