import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class MainG7 {

    public static void main(String[] args) {
        List<String> G7 = Arrays.asList("Usa", "Japan", "France", "Germany", "Italy", "U.K", "Canada");

        Stream<String> sss = G7.parallelStream();

        sss = sss.map(s -> s.toUpperCase(Locale.ROOT));
        sss.forEach(s -> System.out.println(s));



    }
}
