import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    public static void infiniteLoop() {
        Supplier<Double> ran = () -> Math.random();
        Stream<Double> dblrandom = Stream.generate(ran);
        dblrandom.forEach(s -> System.out.println(s)); //forEach lukker stream når færdig. Her bliver den bare aldrig færdig.
    }

    public static void generate12EqualNumbers() {
        Supplier<Double> ran = () -> Math.random();
        Function<Double, Long> dblround = d -> Math.round(d*100);
        Stream<Long> lstLong =  Stream.generate(ran).map(dblround);
        Predicate<Long> longEqual = l -> l % 2 == 0;
        lstLong.filter(longEqual).limit(12).forEach(System.out::println);
    }

    public static void useAggregateFunctions() {
        Supplier<Double> ran = () -> Math.random();
        Function<Double, Long> dblround = d -> Math.round(d*100);
        Stream<Long> lstLong =  Stream.generate(ran).map(dblround);
        Predicate<Long> longEqual = l -> l % 2 == 0;
        Stream<Long> lst = lstLong.filter(longEqual).limit(10);

        IntSummaryStatistics stats = lst.mapToInt(v -> v.intValue()).summaryStatistics();
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
    }

    public static Double getSumOf12RandomEqualNumbers() {
        Supplier<Double> ran = () -> Math.random(); //Supplier er et Interface I Java, et såkaldt functional interface. Udfører blot en function.
        Stream<Double> strran = Stream.generate(ran); //Stream er en ny klasse der blev introduceret I Java samtidig med håndtering af functions/lambda (I Java 8 i 2014, 20år efter første version af Java).
        Function<Double, Long> dblround = d -> Math.round(d*100); //Function er igen et functional interface. Hvis function I modsætning til Supplier, returnerer en type
        Predicate<Long> longEqual = l -> l % 2 == 0; //Predicate er et functional interface. Som returnerer en Boolean. Bruges tit I filter til at fjerne alle elementer der returnere false.

        return Stream.generate(ran)
                .map(dblround)
                .filter(longEqual)
                .limit(12)
                .mapToDouble(d -> d) //mapToDouble tager long som input og returner som double. Fordi sum() kun håndterer double. Og vores Math.round returnerede Long.
                .sum(); //beregner sum og lukker stream.
    }

    public static void main(String[] args) {
        generate12EqualNumbers();
        //infiniteLoop();
        System.out.println(getSumOf12RandomEqualNumbers());
        useAggregateFunctions();
    }
}


