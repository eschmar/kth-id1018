// PersonalData.java

// a program that handles a personal data

/**********************************************************************

This program reads personal data from standard input, and saves
the data in a file.

**********************************************************************/


class PersonalData
{
    public static void main (String[] args)
                           throws Exception    // (1)
	{
		System.out.println ("PERSONAL DATA");
		System.out.println ();

		// input tool
		java.util.Scanner    in = new java.util.Scanner (System.in);

		// read personal data
		System.out.print ("Year of birth: ");
		int    year = in.nextInt ();
		in.nextLine ();    // (2)
 		System.out.print ("Your first and last name: ");
		String    name = in.nextLine ();
		System.out.println ();

		// save the data in a file
		java.io.PrintWriter    fout =
		          new java.io.PrintWriter ("persDat.txt");
		fout.println (name + ": " + year);
		fout.flush ();

		// a message
		System.out.println ("Open the file persDat.txt!");
	}
}
