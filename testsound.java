import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class testsound extends Applet implements MouseListener
{
 // To refer to the sounds.
      AudioClip soundFile1;
      AudioClip soundFile2;

     public void init()
     {
      // This loads the sounds from the server in the same way
      // as an Image.
          soundFile1 = getAudioClip(getDocumentBase(),"BEAST_FICTION.wav");
          soundFile2 = getAudioClip(getDocumentBase(),"shootS.au");

      // When the applet gets here the sounds are loaded.
      // Add the mouselistener
          addMouseListener(this);
      // Just for fun
          setBackground(Color.yellow);
      // Play the first sound to let the user know the applet
      // is loaded.
          soundFile1.play();
     }

     public void paint(Graphics g)
     {
          g.drawString("Click to hear a sound",20,20);
     }

     // Play the second sound on a click.
     public void mouseClicked(MouseEvent evt)
     {
          // This will play your sound file.
          soundFile2.play();
     }

     // The necessary methods.
     public void mousePressed(MouseEvent evt) {}
     public void mouseReleased(MouseEvent evt) {}
     public void mouseEntered(MouseEvent evt) {}
     public void mouseExited(MouseEvent evt) {}

}

