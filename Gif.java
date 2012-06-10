import java.awt.*;

public class Gif extends java.applet.Applet
{
	Image picture;
	public void init()
	{
		picture = getImage(getDocumentBase(),"snoopy.gif");
	}

	public void paint(Graphics g)
	{
		g.drawImage(picture,0,0,this);
	}
}

