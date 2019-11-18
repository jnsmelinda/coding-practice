package ctci.recursionanddynamic;

public class TripleSteps {
    public static int steps(int n) {
        if (n < 0) {
            System.out.println(n);
            return 0;
        }
        else if (n == 0) {
            return 1;
        }
        else {
            return steps(n-1) + steps(n-2) + steps(n-3);
        }
    }

    public static void main(String[] args) {
        System.out.println(steps(3));
    }
}
