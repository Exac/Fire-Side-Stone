import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class oBase
{
	Image img;
	String imageName;
	int posx,posy;
	int vspeed=0, hspeed=0;
	public oBase(String a, int x, int y, game z)
	{
		posx=x;
		posy=y;
		imageName = a;
		img = z.getImage(z.getDocumentBase(),a);
	}
	void move()
	{
		posx+=hspeed;
		posy+=vspeed;
	}
}

