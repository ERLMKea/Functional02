public class Main {

    public static void out(ZeroArgument zO) {
        zO.myFunc();
    }

    public static void out(OneArgument z1, String str) {
        z1.myFunc(str);
    }

    public static void main(String[] args) {
	    // write your code here
        ZeroArgument z = () -> System.out.println("Hello I am interface");
        out(z);
        OneArgument one = str -> System.out.println(str);
        out(one, "hej 1 param");
        TwoArgument twoMult = (x,y) -> x*y;
        int mult = twoMult.myFunc(5,6);
        System.out.println(mult);
    }
}


