import java.util.Arrays;
import java.util.List;

public class MainSumString {

    static int sumString(List<String> list, StringFunc func) {
        int sum = 0;
        for (String str: list) {
            sum += func.calc(str);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("hejvd", "du", "der");
        StringFunc strlen = s -> s.length();
        int lstsum = sumString(strList, strlen);
        System.out.println(lstsum);

    }


}
