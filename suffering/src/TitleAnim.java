import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class TitleAnim extends JPanel 
{
    
    Image ticHighlight;
    Image tacHighlight;
    Image toeHighlight;
    Animator animate;
    Image[] frames;
    
    
    TitleAnim() 
    {          
        animate = new Animator();
        this.setMinimumSize(new Dimension(400,150)); 
        frames = new BufferedImage[3];
        //for the highlighted image
        try {
            ticHighlight = ImageIO.read(new File("C:\\Coding Files\\2D_tic_tac_toe\\Tic_Tac_Toe_ticHighlight.jpg"));
        
        
        frames[0] = ticHighlight;
        tacHighlight = ImageIO.read(new File("C:\\Coding Files\\2D_tic_tac_toe\\Tic_Tac_Toe_tacHighlight.jpg"));
        frames[1] = tacHighlight;
        toeHighlight = ImageIO.read(new File("C:\\Coding Files\\2D_tic_tac_toe\\Tic_Tac_Toe_toeHighlight.jpg"));
        frames[2] = toeHighlight;
        
        } catch (IOException e) {
         // TODO Auto-generated catch block
            e.printStackTrace();
        }

        animate.AnimateGif(frames, 3);
        animate.run();
 
    }
    
    
    
}
