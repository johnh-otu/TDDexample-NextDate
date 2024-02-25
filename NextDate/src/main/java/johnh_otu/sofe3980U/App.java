package johnh_otu.sofe3980U;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] new_date = new int[3];
        new_date = NextDate.NextDate(25,2,2024);
        System.out.println("Day: " + new_date[0]);
        System.out.println("Month: " + new_date[1]);
        System.out.println("Year: " + new_date[2]);
    }
}
