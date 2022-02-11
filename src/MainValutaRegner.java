import java.util.Arrays;
import java.util.List;

public class MainValutaRegner {
    static int valutaRegner(List<Integer> list, TwoArgument two, int exchangeRate) {
        int sum = 0;
        for (int t: list) {
            sum += two.myFunc(t, exchangeRate);
        }
        return sum;
    }


    public static void main(String[] args) {
        TwoArgument twoMult = (x,y) -> x*y;
        List<Integer> dollarSedler = Arrays.asList(1,2,2,5,10);
        int sum = valutaRegner(dollarSedler, twoMult, 6);
        System.out.println(sum);

    }

}
