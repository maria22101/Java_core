package edx.module1_2_3_javabasics_practice;

public class MathExample {
    public static void main(String[] args) {
        double a = -5.1267;
        double b = Math.abs(a);
        System.out.println(b);

        double c = Math.pow(5 / 2, 6);// will be 64 because 5 / 2 => 2 (int)
        System.out.println(c);

        double d = Math.pow(Math.E, 5);
        System.out.println(d);// 148.41315910257657
        double e = Math.log(d);
        System.out.println(e);
    }
}
