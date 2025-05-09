import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Menus extends JFrame
{
    private FlowLayout layout;
    private JPanel restartPanel;
    private JPanel menuPanel;
    private JButton yesButton;
    private JButton noButton;
    private JButton AIButton;
    private JButton twoPlayerButton;
    public int restart = 0;
    private boolean start = false;

    public Menus()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                        
        setLocationRelativeTo(null);
        //setVisible(false);
        setSize(525,600);
        
    }

    public void StartMenu()
    {
        layout = new FlowLayout();
        menuPanel = new JPanel();
        twoPlayerButton = new JButton("START 2 PLAYER GAME");
        AIButton = new JButton("START GAME WITH AI  (coming soon...)");
        
        menuPanel.add(twoPlayerButton);
        menuPanel.add(AIButton);
        
        twoPlayerButton.addMouseListener(new MouseListener()
                {
                    
                    


                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub
                        removeStartMenu();
                        setStart(true);

                    }


                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub
                        removeStartMenu();
                        setStart(true);
                    }


                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub
                        removeStartMenu();
                        setStart(true);
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
            
        
            
        AIButton.addMouseListener(new MouseListener()
        {


            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                
               
            }



            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                
            }



            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                
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
        
        
        menuPanel.setLayout(layout);
        menuPanel.setVisible(true);
        menuPanel.setBackground(new Color(221,0,201));
        menuPanel.setSize(525,600);
        menuPanel.setLocation(200, 200);
        //setLocationRelativeTo(null);

    }
    
    public void RestartBooleanMenu()
    { 
        layout = new FlowLayout();
        restartPanel = new JPanel();
        yesButton = new JButton("YES");
        noButton = new JButton("NO");
        
        restartPanel.add(yesButton);
        restartPanel.add(noButton);
        
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
        
        restartPanel.setLayout(layout);
        restartPanel.setVisible(true);
//---------------------CHANGE COLOR------------------------------------------------------------
        restartPanel.setBackground(new Color(221,0,201));
        restartPanel.setSize(125,200);
        restartPanel.setLocation(200, 200);
        //setLocationRelativeTo(null);                
        
        
        System.out.println("RestartBooleanMenu() called");
    }
    public boolean getStart()
    {
        System.out.println("getStart() called");
        System.out.println("getStart() value " + start);
        return start;
        
    }
    public void setStart(boolean start)
    {
        
        this.start=start;
        System.out.println("setStart() called and set");
        System.out.println("setStart() value " + start);
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
        add(restartPanel);
        setVisible(bool);
    }
    public void resetClass()
    {
        restart = 0;
        //removeAll();
    }
    public void showStartMenu()
    {
        
        StartMenu();
        setVisible(true);
        
        add(menuPanel);
        System.out.println("startMenuPanel() called");
    }
    public void removeStartMenu()
    {
        setVisible(false);
        menuPanel.setVisible(false);
        //menuPanel.removeAll();
        //remove(menuPanel);
        System.out.println("removePanel() called");
    }

}
