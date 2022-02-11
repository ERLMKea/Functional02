import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class MainForEach {

    public static <T> void out2(T content) {
        System.out.println(content);
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t: list) {
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {
        Consumer<String> consumer1 = x -> System.out.println(x.toLowerCase(Locale.ROOT));
        consumer1.accept("JOSDEM");
        Consumer<Integer> consumI = x -> System.out.println("x=" + x);
        consumI.accept(10);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        forEach(list, consumI);
        List<String> lstStr = Arrays.asList("ehj" , "do");

        lstStr.forEach(s -> System.out.println(s));

    }

}
