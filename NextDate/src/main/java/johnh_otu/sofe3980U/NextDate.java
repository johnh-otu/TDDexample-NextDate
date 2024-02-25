package johnh_otu.sofe3980U;

public class NextDate {

    static String daymsg = "Invalid: day must be in [1,lastDayOfMonth]";
    static String monmsg = "Invalid: month must be in [1,12]";
    static String yearmsg = "Invalid: year must be in [1812,2212]";

    public static int[] nextDate(int Day, int Month, int Year) throws IllegalArgumentException {

        //check for invalid month/year
        if (Year < 1812 || Year > 2212)
            throw new IllegalArgumentException(yearmsg);
        if (Month < 1 || Month > 12)
            throw new IllegalArgumentException(monmsg);

        //get end of month
        int end_of_month = endOfMonth(Month, Year);

        //check for invalid day
        if (Day < 1 || Day > end_of_month)
            throw new IllegalArgumentException(daymsg);

        //initialize output
        int[] out = new int[3];

        //set output to new values
        if (Day == end_of_month) { //if end of month

            out[0] = 1;

            if (Month == 12) { //if end of year
                out[1] = 1;
                out[2] = Year + 1;
                //happy new year!
            }
            else {
                out[1] = Month + 1;
                out[2] = Year;
                //happy new month!
            }

        }
        else {
            out[0] = Day + 1;
            out[1] = Month;
            out[2] = Year;
            //happy new day!
        }

        return out;
    }

    private static int endOfMonth(int Month, int Year) {
        //assume valid month (between [1,12])
        switch (Month) {
            case 2:
                return (isLeapYear(Year)) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static boolean isLeapYear(int Year) {
        return (Year % 400 == 0) || (Year % 100 != 0) && (Year % 4 == 0);
    }
}
