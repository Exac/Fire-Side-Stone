/**
 * The Viewer from the MVC pattern, this should be instantiated 
 * inside Model, and should only do graphics, not computation.
 * <p>All the graphical output should be routed through this 
 * class. It is UPDATED by the Model.
 * 
 * @author      Exac
 * @version		%I%, %G%
 * @since		0.01
 */
public class Viewer
{
	Viewer()
	{
		
	}
	/**
     * Console log.
     *
     * @param string_	The string to be output to the console.
     * @author			Exac
     * @since			1.0
     */
	public static void out(String string_)
	{
		System.out.println(string_);
	}
}
