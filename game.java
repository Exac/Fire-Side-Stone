import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class game extends Applet implements KeyListener
{
	int i = 0;
	int j = 0;
 	AudioClip soundFile1;
	AudioClip soundFile2;
	Image snoopy;
	Image background;
	public void init()
	{
		soundFile1 = getAudioClip(getDocumentBase(),"music/02.wav");
		snoopy = getImage(getDocumentBase(),"img/snoopy.gif");
		background = getImage(getDocumentBase(),"backgrounds/01.jpg");
		addKeyListener(this);
		soundFile1.play();
	}

	public void paint(Graphics g)
	{
		g.drawImage(background,0-i,j,this);
		g.drawImage(background,700-i,j,this);

		g.drawImage(snoopy,300,180,this);

		i+=2; // Gives continuous scrolling while keys aren't doing shit

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
			//	if (j != -70) {
					j-=5;// }
				break;
			case KeyEvent.VK_RIGHT:
				i+=3;
				break;
			case KeyEvent.VK_LEFT:
				i-=3;
				break;
			case KeyEvent.VK_UP:
				if (j < 0) { //Limitations so the view does not fuck over
					j+=5;	}
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

