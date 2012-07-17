import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class game extends Applet implements KeyListener
{
	int screenSizeX = 700, screenSizeY=350;
	int cx = 300, cy=180;
	int i = 0;
	int camera=1;
	int objects_index=0;
 	AudioClip soundFile1;
	Image snoopy;
	Image background;
	ArrayList<oBase> objects = new ArrayList<oBase>();
	public void init()
	{
		soundFile1 = getAudioClip(getDocumentBase(),"music/01.wav");
		background = getImage(getDocumentBase(),"backgrounds/01.jpg");
		addKeyListener(this);
		soundFile1.play();
		objects.add(new oBack("backgrounds/01.jpg",0,0,this));
		objects_index++;
		objects.add(new oChar("img/snoopy.gif",380,100,this));
		objects.get(1).hspeed = 5;
		objects_index++;
		objects.add(new oChar("img/snoopy.gif",300,100,this));
		objects.get(2).hspeed = 5;
		objects_index++;
	}

	public void paint(Graphics g)
	{
		//g.drawImage(background,(0-objects.get(0).posx)%700,j,this);
		//g.drawImage(background,(700-objects.get(0).posx)%700,j,this);
		//g.drawImage(background,0-i,j,this);
		//g.drawImage(background,700-i,j,this);
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
		i+=2;

		//Restarts the background
		if(i>700)
			i-=700;
		if(i<0)
			i+=700;
	}

	public void keyPressed(KeyEvent ke) {
		switch(ke.getKeyCode())
		{
			case KeyEvent.VK_DOWN:
				//j-=5;
				break;
			case KeyEvent.VK_RIGHT:
				objects.get(camera).hspeed=10;
				break;
			case KeyEvent.VK_LEFT:
				objects.get(camera).hspeed=-6;
				break;
			case KeyEvent.VK_UP:
				//j+=5;
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
				//	j-=5;
				break;
			case KeyEvent.VK_RIGHT:
				objects.get(camera).hspeed=0;
				break;
			case KeyEvent.VK_LEFT:
				objects.get(camera).hspeed=0;
				break;
			case KeyEvent.VK_UP:
				//	j+=5;
				break;
		}
	}
}

