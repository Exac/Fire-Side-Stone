import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class game extends Applet implements KeyListener
{
	int screenSizeX = 700, screenSizeY=350;
	int cx = 300, cy=180;
	int camera=2;
	int objects_index=0;

 	AudioClip soundFile1;
	ArrayList<oBase> objects = new ArrayList<oBase>();
	public void init()
	{
		soundFile1 = getAudioClip(getDocumentBase(),"music/01.wav");
		addKeyListener(this);
		soundFile1.play();
		try {
			int bufferType;
			Scanner sc = new Scanner(new File("objects.dat"));
			camera=sc.nextInt();
			objects_index=sc.nextInt();
			for(int i = 0; i < objects_index; i++)
			{
				bufferType=sc.nextInt();
				if(bufferType==0)
				{
					objects.add(new oBase(sc.next(), sc.nextInt(), sc.nextInt(),this));
					objects.get(i).hspeed = sc.nextInt();
					objects.get(i).vspeed = sc.nextInt();
				}
				else if(bufferType==1)
				{
					objects.add(new oChar(sc.next(), sc.nextInt(), sc.nextInt(),this));
					objects.get(i).hspeed = sc.nextInt();
					objects.get(i).vspeed = sc.nextInt();
				}
				else if(bufferType==2)
				{
					objects.add(new oBack(sc.next(), sc.nextInt(), sc.nextInt(),this));
				}

			}
			sc.close();
			} catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}

	public void paint(Graphics g)
	{
		for(int x = 0; x<objects_index;x++)
		{
			objects.get(x).move();
			if(objects.get(x).getType()==2)
			{
				g.drawImage(objects.get(x).img, 700-objects.get(camera).posx%700,  350-objects.get(camera).posy%350, this);
				g.drawImage(objects.get(x).img, 0-objects.get(camera).posx%700,  350-objects.get(camera).posy%350, this);
				g.drawImage(objects.get(x).img, 700-objects.get(camera).posx%700,  0-objects.get(camera).posy%350, this);	
				g.drawImage(objects.get(x).img, 0-objects.get(camera).posx%700,  0-objects.get(camera).posy%350, this);				
			}
			else
			{
				g.drawImage(objects.get(x).img,	cx-(objects.get(camera).posx-objects.get(x).posx),	cy-(objects.get(camera).posy-objects.get(x).posy),this);
			}
		}
	}

	public void keyPressed(KeyEvent ke) {
		switch(ke.getKeyCode())
		{
			case KeyEvent.VK_DOWN:
				break;
			case KeyEvent.VK_RIGHT:
				objects.get(camera).hspeed=10;
				break;
			case KeyEvent.VK_LEFT:
				objects.get(camera).hspeed=-6;
				break;
			case KeyEvent.VK_UP:
				break;
		}
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public void keyTyped(KeyEvent ke) {}
	public void keyReleased(KeyEvent ke) {
		switch(ke.getKeyCode())
		{
			case KeyEvent.VK_DOWN:
				break;
			case KeyEvent.VK_RIGHT:
				objects.get(camera).hspeed=0;
				break;
			case KeyEvent.VK_LEFT:
				objects.get(camera).hspeed=0;
				break;
			case KeyEvent.VK_UP:
				break;
		}
	}
}

