package hackerrank.time_conversion;

public class TimeConversion {
    public static void main(String[] args) {
        System.out.println(timeConversion("06:40:03AM"));
    }

    public static String timeConversion(String s) {
        StringBuilder result = new StringBuilder();

        String amPm = s.substring(s.length() - 2);

        String rawHour = s.substring(0,2);

        String minutesSeconds = s.substring(2,8);
        System.out.println(minutesSeconds);

        int hourInt = Integer.parseInt(rawHour);

        if ("PM".equalsIgnoreCase(amPm)) {
            if (hourInt != 12) {
                hourInt += 12;
            }
        }
        else {
            if (hourInt == 12) {
                hourInt = 0;
            }
        }

        if (hourInt == 0) {
            result.append("00");
        }
        else {
            if (hourInt < 10) {
                result.append("0");
            }
            result.append(hourInt);
        }
        result.append(minutesSeconds);

        return result.toString();
    }
}
