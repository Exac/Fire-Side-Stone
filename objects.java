import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
class oBase
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
	void setvspeed(int x)
	{
		vspeed = x;
	}
	void sethspeed(int x)
	{
		hspeed = x;
	}
	void setposx(int x)
	{
		posx = x;
	}
	void setposy(int x)
	{
		posy = x;
	}
	void drawInRelation(Graphics g, int relx, int rely, int drawx, int drawy)
	{
		g.drawImage(img,drawx-(relx-posx),drawy-(rely-posy),null);
	}
}

