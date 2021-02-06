package leetcode.p1507_reformat_date;

public class ReformatDate {
    public static void main(String[] args) {
        System.out.println(reformatDate("6th Jun 1933"));
    }

    public static String reformatDate(String date) {
        String[] dates = date.split(" ");

        String result = dates[2];
        result += "-";

        String month = "";
        switch(dates[1]) {
            case "Jan":
                month = "01";
                break;
            case "Feb":
                month = "02";
                break;
            case "Mar":
                month = "03";
                break;
            case "Apr":
                month = "04";
                break;
            case "May":
                month = "05";
                break;
            case "Jun":
                month = "06";
                break;
            case "Jul":
                month = "07";
                break;
            case "Aug":
                month = "08";
                break;
            case "Sep":
                month = "09";
                break;
            case "Oct":
                month = "10";
                break;
            case "Nov":
                month = "11";
                break;
            case "Dec":
                month = "12";
                break;
        }
        result += month + "-";

        String day = dates[0].substring(0, dates[0].length() - 2);
        if (day.length() == 1) {
            result += "0" + day;
        }
        else {
            result += day;
        }

        return result;
    }
}
