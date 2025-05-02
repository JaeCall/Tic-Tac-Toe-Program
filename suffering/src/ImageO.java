import javax.swing.JPanel;
import java.awt.*;

public class ImageO extends JPanel 
{
    private Image o;
    private Image oSet;
    private boolean isSet = true;
    ImageO()
    {
        this.setPreferredSize(new Dimension(150,150)); 
        //for the highlighted image
        this.o = Toolkit.getDefaultToolkit().getImage("C:\\Coding Files\\2D_tic_tac_toe\\tic_tac_toe_o_off.jpg");
        //image for the set move
        this.oSet = Toolkit.getDefaultToolkit().getImage("C:\\Coding Files\\2D_tic_tac_toe\\tic_tac_toe_o_on.jpg");
        
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Color bColor = new Color(135, 0, 135);
        setBackground(bColor);
        
        if(isSet)
        {
           g.drawImage(oSet, 0, 0, this); 
        }
        else
        {
            g.drawImage(o, 0, 0, this);
        }
            
    }
    public void toggleImage()
    {
        isSet = !isSet;
        repaint();
    }

    public void reset()
    {
        isSet = true;

    }

}
