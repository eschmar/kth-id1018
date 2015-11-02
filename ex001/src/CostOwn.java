import java.util.Scanner;

/**
 * Created by eschmar on 02/11/15.
 */
class CostOwn
{
    public static void main (String[] args)
    {
        System.out.println ("Average Cost");
        System.out.println ();

        Double sum = 0.0;
        int counter = 0;
        Scanner in = new Scanner(System.in);
        in.useLocale(java.util.Locale.US);

        while (in.hasNextDouble()) {
            sum += in.nextDouble();
            counter++;
        }

        // show the result
        System.out.println (counter + " item(s) with an average cost of " + sum/counter);
    }
}