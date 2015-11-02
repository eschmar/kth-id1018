// HandleNumbers.java

// a program with numbers


/**********************************************************************

This program reads ten numbers from standard input. The program
determines and shows: the sum of the numbers, there average, and
the minimum number.

Finally the program sorts the numbers and show them.

**********************************************************************/


class HandleNumbers
{
    public static void main (String[] args)
	{
        System.out.println ("HANDLE NUMBERS");
        System.out.println ();

		// input tool
		java.util.Scanner    in = new java.util.Scanner (System.in);
		in.useLocale (java.util.Locale.US);

        // read and store the numbers
        double[]    numbers = new double[10];
        System.out.println ("10 numbers:");
        for (int pos = 0; pos < numbers.length; pos++)
            numbers[pos] = in.nextDouble ();

        // the sum and the average value
        double    sum = 0;
        for (int pos = 0; pos < numbers.length; pos++)
             sum = sum + numbers[pos];  // sum += numbers[pos];
        double    meanValue = sum / numbers.length;

        // minimum
        double    min = numbers[0];
        for (int pos = 1; pos < numbers.length; pos++)
            if (numbers[pos] < min)
                min = numbers[pos];

        // show the sum, the average and the minimum
        System.out.println ("\nthe sum: " + sum);
        System.out.println ("mean value: " + meanValue);
        System.out.println ("minimum: " + min);

        // sort the numbers
        int    minPos = 0;
        double    t = 0;
        for (int pos = 0; pos < numbers.length - 1; pos++)
        {
			minPos = pos;
			for (int p = pos + 1; p < numbers.length; p++)
			    if (numbers[p] < numbers[minPos])
			        minPos = p;
			t = numbers[pos];
			numbers[pos] = numbers[minPos];
			numbers[minPos] = t;
		}

		// show the numbers after sorting
		System.out.println ("\nthe numbers in increasing order:");
		for (double q : numbers)
		    System.out.print (q + "  ");
		System.out.println ();
	}
}
