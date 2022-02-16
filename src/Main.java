import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<LocalDate> getDaysInAMonth(int year, int month) {
        LocalDate dtMonth = LocalDate.of(year, month, 1);
        List<LocalDate> listDays = new ArrayList<>();
        for (int i = 0; i<31; i++) {
            LocalDate ld = dtMonth.plusDays(i);
            if (ld.getMonth().getValue() != month) break;
            listDays.add(ld);
        }
        return listDays;
    }

    public static List<LocalDate> getWeekDays(int year, int month, int weekDay) {
        List<LocalDate> listDays = getDaysInAMonth(year, month);
        Predicate<LocalDate> isWeekday = d -> d.getDayOfWeek().getValue() == weekDay;
        List<LocalDate> weekDays = listDays.stream().filter(isWeekday).collect(Collectors.toList());
        return weekDays;
    }

    public static void main(String[] args) {
        System.out.println("klar");

        List<LocalDate> lst = getWeekDays(2022, 3, 2);
        lst.forEach(a -> System.out.println(a));


    }
}


