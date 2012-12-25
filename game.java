import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
class oBase
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

	Boolean tiled = false;
	int depth = 0;

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
}
class oList
{
	ArrayList<oBase> objects = new ArrayList<oBase>();
	int camera;
	int maxX, maxY, cX, cY;
	public oList(int cam, int screenSizeX, int screenSizeY, int cameraX, int cameraY)
	{
		camera = cam;
		maxX = screenSizeX;
		maxY = screenSizeY;
		cX = cameraX;
		cY = cameraY;
	}
	void add(oBase x)
	{
		objects.add(x);
	}
	void add(String a, int x, int y, game z)
	{
		objects.add(new oBase(a,x,y,z));
	}
	void sortDepth()
	{

	}
	void setTiled(int i)
	{
		objects.get(i).tiled=true;
	}
	void unsetTiled(int i)
	{
		objects.get(i).tiled=false;
	}
	void setGravity(int i)
	{
		objects.get(i).gravity=true;
	}
	void unsetGravity(int i)
	{
		objects.get(i).gravity=false;
	}
	void sethSpeed(int i, int x)
	{
		objects.get(i).hspeed=x;
	}
	void setvSpeed(int i, int x)
	{
		objects.get(i).vspeed=x;
	}
	void draw(Graphics g, game z)
	{
		for(int x = 0; x<objects.size();x++)
		{
			objects.get(x).move();
			if(objects.get(x).tiled == true) //if background
			{
				g.drawImage(objects.get(x).img, 700-objects.get(camera).posx%700,  350-objects.get(camera).posy%350, z);
				g.drawImage(objects.get(x).img, 0-objects.get(camera).posx%700,  350-objects.get(camera).posy%350, z);
				g.drawImage(objects.get(x).img, 700-objects.get(camera).posx%700,  0-objects.get(camera).posy%350, z);
				g.drawImage(objects.get(x).img, 0-objects.get(camera).posx%700,  0-objects.get(camera).posy%350, z);
			}
			else
			{
				g.drawImage(objects.get(x).img,	cX-(objects.get(camera).posx-objects.get(x).posx),	cY-(objects.get(camera).posy-objects.get(x).posy),z);
			}
		}
	}
}
public class game extends Applet implements KeyListener
{
	oList objectlist = new oList(2,700,350,300,180);
 	AudioClip soundFile1;
	public void init()
	{
		soundFile1 = getAudioClip(getDocumentBase(),"music/01.wav");
		addKeyListener(this);
		soundFile1.play();

		objectlist.add(new oBase("backgrounds/01.jpg",0,0,this));
		objectlist.add(new oBase("img/snoopy.gif",500,500,this));
		objectlist.add(new oBase("img/barrel.gif",500,500,this));
		objectlist.setTiled(0);
		//objectlist.get(2).gravity=true;
	}
	public void paint(Graphics g)
	{
		objectlist.sortDepth();
		objectlist.draw(g,this);
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public void keyPressed(KeyEvent ke) {
		switch(ke.getKeyCode())
		{
			case KeyEvent.VK_DOWN:
				objectlist.setvSpeed(objectlist.camera,10);
				break;
			case KeyEvent.VK_RIGHT:
				//objects.get(camera).hspeed=10;
				objectlist.sethSpeed(objectlist.camera,10);
				break;
			case KeyEvent.VK_LEFT:
				objectlist.sethSpeed(objectlist.camera,-10);
				//objects.get(camera).hspeed=-6;
				break;
			case KeyEvent.VK_UP:
				objectlist.setvSpeed(objectlist.camera,-10);
				/*if(objects.get(camera).in_air==false)
				{
					objects.get(camera).buffy=objects.get(camera).posy;
					objects.get(camera).vspeed=-20;
					objects.get(camera).in_air = true;
				}*/
				break;
		}
	}
	public void keyTyped(KeyEvent ke) {}
	public void keyReleased(KeyEvent ke) {
		switch(ke.getKeyCode())
		{
			case KeyEvent.VK_DOWN:
				objectlist.setvSpeed(objectlist.camera,0);
				break;
			case KeyEvent.VK_RIGHT:
				objectlist.sethSpeed(objectlist.camera,0);
				//objects.get(camera).hspeed=0;
				break;
			case KeyEvent.VK_LEFT:
				objectlist.sethSpeed(objectlist.camera,0);
				//objects.get(camera).hspeed=0;
				break;
			case KeyEvent.VK_UP:
				objectlist.setvSpeed(objectlist.camera,0);
				break;
		}
	}
}
