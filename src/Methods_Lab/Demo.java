package Methods_Lab;

public class Demo {
    public static void main(String[] args) {
        int[]  num = { 5 };

        num = increment(num, 16);
        System.out.println(num);
    }

    private static int[] increment(int[] num, int amount) {
        num[0] += amount;
        return num;
    }
}
