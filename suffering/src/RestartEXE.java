import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class RestartEXE extends JFrame
{
    private FlowLayout layout;
    private JPanel panel;
    private JButton yesButton;
    private JButton noButton;
    public int restart = 0;
    
    public void RestartBooleanMenu()
    { 
        layout = new FlowLayout();
        panel = new JPanel();
        yesButton = new JButton("YES");
        noButton = new JButton("NO");
        
        panel.add(yesButton);
        panel.add(noButton);
        
        noButton.addMouseListener(new MouseListener()
                {
                    
                    


                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub
                        setButton(1);

                    }


                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub
                        setButton(1);
                    }


                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub
                        setButton(1);
                    }


                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent e) {
                       
                    }


                    @Override
                    public void mouseExited(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub
                       
                    }
                       
                    }

                
                );
            
        
            
        yesButton.addMouseListener(new MouseListener()
        {


            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                
                setButton(2);
            }



            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                setButton(2);
            }



            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                setButton(2);
            }



            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                

            }



            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
               
            }

        
        );
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        getContentPane().setLayout(layout);
//---------------------CHANGE COLOR------------------------------------------------------------
        setBackground(new Color(221,0,201));
        setSize(125,200);
        setVisible(false);                     
        setLocationRelativeTo(null);
        add(panel);
        System.out.println("RestartBooleanMenu() called");
    }
    public int getButton()
    {
        System.out.println("getButton() called");
        System.out.println("getButton() value " + restart);
        return restart;
        
    }

    private void setButton(int restart)
    {
        
        this.restart=restart;
        System.out.println("setButton() called and set");
        System.out.println("setButton() value " + restart);
    }

    public void showMenu(boolean bool)
    {
        setVisible(bool);
    }
    public void resetClass()
    {
        restart = 0;
    }

}
