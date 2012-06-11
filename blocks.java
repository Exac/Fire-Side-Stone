
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class blocks
{
	public static void main (String args[]) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("coords.dat"));
		String inString;
		int x;
		int y;
		while((inString = in.readLine()) != null)
		{
			x = Integer.parseInt(inString);
			while((inString = in.readLine()) != null)
			{
				y = Integer.parseInt(inString);
			}


		}
		in.close();
	}
}
