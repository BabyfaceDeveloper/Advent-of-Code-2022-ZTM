import solutions.Day1;
import solutions.Day2;

@SuppressWarnings("unused")
public class App {
    
    public static void main(String[] args) throws Exception {
        var day1 = new Day1("day1.txt");
        // day1.solvePart1();
        // day1.solvePart2();

        var day2 = new Day2("day2.txt");
        day2.solvePart1();
        day2.solvePart2();
    }

}
