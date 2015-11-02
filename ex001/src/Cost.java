// Cost.java

// a simple calculation


/**********************************************************************

This program determines the cost of a number of equal books.
The program reads from standard input both the number of books
and a price for the book. The cost is shown at the standard output.

**********************************************************************/


class Cost
{
    public static void main (String[] args)
	{
		System.out.println ("COST");
		System.out.println ();

		// input tool
		java.util.Scanner    in = new java.util.Scanner (System.in);
		in.useLocale (java.util.Locale.US);

		// input the number of books and a price of the book
		System.out.print ("number of books: ");
		int    numberOfBooks = in.nextInt ();
 		System.out.print ("price of the book: ");
		double    price = in.nextDouble ();

		// determine the total cost
		double    cost = numberOfBooks * price;

		// show the result
		System.out.println ("total cost: " + cost);
	}
}


/*----------------------------------------------------------------------

Example of input and output

KOSTNAD

number of books: 25
price of the book: 50
total cost: 1250.0


Another example of input and output

KOSTNAD

number of books: 47
price of the book: 230
total cost: 10810.0

----------------------------------------------------------------------*/
