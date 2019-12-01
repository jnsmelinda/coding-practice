package adventofcode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(countFuel());
    }

    public static int countFuel() throws IOException, URISyntaxException {
        int result = 0;
        URI uri = Day1.class.getClassLoader().getResource("advent-of-code-2019/day-01/mass.txt").toURI();

        List<String> lines = Files.readAllLines(Path.of(uri));
        for (String line : lines) {
            result += moduleFuel(Integer.parseInt(line));
        }

        return result;
    }

    private static int moduleFuel(int module) {
        int result = 0;
        while ((module / 3) - 2 >= 0) {
            int temp = (module / 3) - 2;
            result += temp;
            module = temp;
        }
        return result;
    }
}
