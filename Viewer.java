/**
 * The Viewer from the MVC pattern, this should be instantiated 
 * inside Model, and should only do graphics, not computation.
 * <p>
 * Viewer UPDATES the screen.
 * <p>All the graphical output should be routed through this 
 * class.
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
     * @author		Exac
     * @since		1.0
     */
	public static void out(String string_)
	{
		System.out.println(string_);
	}
}
