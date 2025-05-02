
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;





public class Animator extends JPanel implements Runnable
{
    private Image[] images;
    private Thread animationThread;
    public int frame;
    public int SIZE;
    public int fps;

    public void AnimateGif(Image[] images, int fps)
    {

        this.fps=fps;
        this.images = images;
        this.SIZE  = images.length;
        animationThread = new Thread(this);
        animationThread.setDaemon(true);
        animationThread.start();
    
        System.out.println("Animation Thread alive "  + animationThread.isAlive());
        

    }


    @SuppressWarnings("static-access")
    public void run()
    {
        try
        {
        while(animationThread.isAlive())
        {
            //System.out.println("Title run() running");
            nextFrame();
            animationThread.sleep(1000/fps);
            
            
        }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }



    public void nextFrame()
    {
        
        System.out.println("Title image " + frame + " painted");
        frame++;
        if(frame == SIZE)
        {
            frame = 0;
        }
        repaint();
        //System.out.println("Next Frame Executed");
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(images[frame],0,0,null);
    }

}
