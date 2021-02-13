package leetcode.p0434_number_of_segments_in_string;

import java.util.ArrayList;
import java.util.List;

public class NumberOfSegmentsInString {
    public static void main(String[] args) {
        System.out.println(countSegments2("love live! mu'sic forever"));
    }

    public static int countSegments(String s) {
        int counter = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String str = "";
            while (i <= s.length() - 1 && s.charAt(i) != ' ') {
                str += s.charAt(i);
                i++;
            }
            if (!(str.isEmpty())) {
                list.add(str);
                str = "";
            }

        }
        return list.size();
    }

    public static int countSegments2(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
