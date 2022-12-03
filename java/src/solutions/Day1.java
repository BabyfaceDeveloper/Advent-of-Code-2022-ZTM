package solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 extends Day implements ISolution {

    private List<Integer> sum_calories;
    private List<String> lines;

    public Day1(String filename) throws IOException {
        super(filename);
        readFiles();
        sum_calories = new ArrayList<>();
        solveCore();
    }

    @Override
    public void readFiles() throws IOException {
        lines = Files.lines(INPUT_FILE).map(line -> line.strip()).toList();
    }

    private void solveCore() throws IOException {
        var total_calories = 0;
        for (String line : lines) {
            if (line.length() > 0 && line.chars().allMatch(Character::isDigit)) {
                total_calories += Integer.parseInt(line);
            } else {
                sum_calories.add(total_calories);
                total_calories = 0;
            }
        }
        Collections.sort(sum_calories);
    }

    @Override
    public void solvePart1() {
        System.out.println(sum_calories.get(sum_calories.size() - 1));
    }

    @Override
    public void solvePart2() {
        System.out.println(sum_calories.stream().skip(sum_calories.size() - 3).reduce(0, Integer::sum));
    }

}
