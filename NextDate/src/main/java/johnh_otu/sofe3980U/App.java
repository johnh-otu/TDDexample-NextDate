package johnh_otu.sofe3980U;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] new_date;
        new_date = NextDate.nextDate(25,2,2024);
        System.out.println("Day: " + new_date[0]);
        System.out.println("Month: " + new_date[1]);
        System.out.println("Year: " + new_date[2]);
    }
}
