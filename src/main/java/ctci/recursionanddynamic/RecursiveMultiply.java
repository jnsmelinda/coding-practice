package ctci.recursionanddynamic;

public class RecursiveMultiply {

    public static void main(String[] args) {
        System.out.println(multiply(7, 8));
    }

    public static int multiply(int num, int limit) {
        return multiply(num, limit, 0, 0);
    }

    private static int multiply(int num, int limit, int counter, int result) {
        if (counter == limit) {
            return result;
        }
        else {
            counter++;
            result += num;
            return multiply(num, limit, counter, result);
        }
    }
}
