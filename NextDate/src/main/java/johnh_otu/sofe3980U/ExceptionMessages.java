package johnh_otu.sofe3980U;

public class ExceptionMessages {
    private static String day_message = "Invalid: day must be in [1,lastDayOfMonth]";
    private static String month_message = "Invalid: month must be in [1,12]";
    private static String year_message = "Invalid: year must be in [1812,2212]";


    public static String getDay_message() {
        return day_message;
    }

    public static String getMonth_message() {
        return month_message;
    }

    public static String getYear_message() {
        return year_message;
    }
}
