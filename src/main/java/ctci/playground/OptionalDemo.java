package ctci.playground;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String value = Optional.ofNullable(getValue())
                .filter(v -> v.startsWith("b"))
                .map(v -> "---" + v)
                .orElse("nincs");

        System.out.println(value);
    }

    private static String getValue() {
        return "abc";
//        return null;
    }
}
