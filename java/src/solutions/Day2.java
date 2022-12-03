package solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Day2 extends Day implements ISolution {

    private List<String> rounds;
    private final int WIN_BONUS = 6;
    private final int DRAW_BONUS = 3;

    public Day2(String filename) throws IOException {
        super(filename);
        readFiles();
    }

    @Override
    public void readFiles() throws IOException {
        rounds = Files.lines(INPUT_FILE).map(line -> line.strip()).toList();
    }

    private int calculateMyScore(int oponentChoice, int myChoice) {
        var diff = myChoice - oponentChoice;
        // Win case
        if (diff == 1 || diff == -2)
            return myChoice + WIN_BONUS;
        // Draw case
        if (diff == 0)
            return myChoice + DRAW_BONUS;
        return myChoice;
    }

    private int[] decodePart1(String choices) {
        // Rock = A or X <=> 1
        // Paper = B or Y <=> 2
        // Scissors = C or Z <=> 2
        return new int[] { (int) choices.charAt(0) - 64, (int) choices.charAt(2) - 87 };
    }

    private int[] decodePart2(String choices) {
        var temp = decodePart1(choices);
        var oponentChoice = temp[0];
        // X = 1, Y = 2, Z = 3
        // X means lose, Y means draw and Z means win
        var myChoice = switch (temp[1]) {
            case 1 -> oponentChoice > 1 ? oponentChoice - 1 : 3;
            case 2 -> oponentChoice;
            case 3 -> oponentChoice < 3 ? oponentChoice + 1 : 1;
            default -> Integer.MIN_VALUE; // Useless
        };
        return new int[] { oponentChoice, myChoice };
    }

    @Override
    public void solvePart1() throws Exception {
        var scores = rounds.stream().map(round -> decodePart1(round))
                .mapToInt(choices -> calculateMyScore(choices[0], choices[1])).sum();
        System.out.println(scores);
    }

    @Override
    public void solvePart2() throws Exception {
        var scores = rounds.stream().map(round -> decodePart2(round))
                .mapToInt(choices -> calculateMyScore(choices[0], choices[1])).sum();
        System.out.println(scores);
    }

}
