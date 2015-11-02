import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by eschmar on 02/11/15.
 */
class PersonalDataOwn
{
    public static void main (String[] args) throws Exception
    {
        System.out.println ("Movie database\n\r");

        Scanner in = new Scanner(System.in);
        in.useLocale(java.util.Locale.US);
        String[] dataPoints = {"Title", "Year", "Genre"};
        ArrayList<String[]> result = new ArrayList<String[]>();

        String title;
        String year;
        String genre;

        boolean another = true;

        while (another){
            System.out.println("Movie title: ");
            title = in.next();

            System.out.println("Movie year: ");
            year = in.next();

            System.out.println("Movie genre: ");
            genre = in.next();

            String[] node = {title, year, genre};
            result.add(node);

            System.out.println("\n\rAdd another movie (y/n)?");
            if (!in.next().equals("y")) {
                another = false;
            }
        }

        PrintWriter fout = new PrintWriter("persDataOwn.txt");
        fout.println("title,year,genre");
        for (String[] node : result) {
            fout.println(node[0] + "," + node[1] + "," + node[2]);
        }

        fout.flush();
        System.out.println ("Open the file persDatOwn.txt!");
    }
}
