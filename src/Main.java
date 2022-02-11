import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Supplier<Double> ran = () -> Math.random();
        Stream<Double> dblrandom = Stream.generate(ran);

        double dd = Math.random();
        Long ii = Math.round(dd*100);
        System.out.println(ii);

        Function<Double, Long> dblround = d -> Math.round(d*100);

        Predicate<Long> longEqual = l -> l % 2 == 0;

        Consumer<Long> print = i -> System.out.println("Rand=" + i);

        System.out.println("test ran called");
        Stream<Long> lstLong =  Stream.generate(ran).map(dblround);
        lstLong= lstLong.filter(longEqual).limit(12);


        Double sum = lstLong.mapToDouble(d -> d).sum();

        //lstLong.forEach(print);
        //lstLong.forEach(print);

        System.out.println(sum);


    }
}


