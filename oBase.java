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
	int buffy;
	int width, length;
	Boolean in_air = false;
	Boolean gravity = false;
	int jumpstr = 80;
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
		if(gravity == true && posy < buffy-jumpstr && vspeed < 0)
			vspeed *=-1;
		if(posy>500)
		{
			vspeed=0;
			in_air=false;
		}
	}
	int getType()
	{
		return 0;
	}
}

