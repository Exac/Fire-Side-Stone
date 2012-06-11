
import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class blockwriter //Pretty useless, but I thought it'd be an interesting program to write
{
	public static void main (String args[]) throws IOException
	{
		int a = 0;
		int b = 0;
		int x;
		int y;
		BufferedWriter outStream = new BufferedWriter(new FileWriter("coords.dat"));
		Scanner input = new Scanner(System.in);

		System.out.println("To end the program, type 1 at End");
		System.out.println("Coordinates? (X,Y):");

		while (a == b)
		{

			System.out.print(" - X: ");
			x = input.nextInt();
			outStream.write(String.valueOf(x));
			outStream.newLine();

			System.out.print(" - Y: ");
			y = input.nextInt();
			outStream.write(String.valueOf(y));
			outStream.newLine();

			System.out.print(" End? ");
			b = input.nextInt();

		}

		outStream.close();

		System.out.println("");
		System.out.println("End of program");
	}
}

