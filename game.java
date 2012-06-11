import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class game extends Applet implements KeyListener
{
	int i = 0;
 	AudioClip soundFile1;
	AudioClip soundFile2;
	Image snoopy;
	Image background;
	public void init()
	{
		soundFile1 = getAudioClip(getDocumentBase(),"BEAST_FICTION.wav");
		soundFile2 = getAudioClip(getDocumentBase(),"shootS.au");
		snoopy = getImage(getDocumentBase(),"snoopy.gif");
		background = getImage(getDocumentBase(),"back.jpg");
		addKeyListener(this);
		soundFile1.play();
	}
	public void paint(Graphics g)
	{
		g.drawImage(background,0-i,0,this);
		g.drawImage(background,697-i,0,this);
		g.drawImage(snoopy,300,180,this);
		i+=2;
		if(i>697)
			i-=697;
		if(i<0)
			i+=697;
	}
	public void keyPressed(KeyEvent ke) {
		switch(ke.getKeyCode())
		{
			case KeyEvent.VK_DOWN:
				break;
			case KeyEvent.VK_RIGHT:
				i+=5;
				break;
			case KeyEvent.VK_LEFT:
				i-=5;
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
	public void keyReleased(KeyEvent ke) {}


}

