import java.awt.Color;


import javax.swing.JFrame;







public class MainFrame extends JFrame 
{
    
    TitleAnim title;
    LoadPanels loadPanels;
    LoadConstraints constraints;
    RestartEXE restart;
    

    public void Window()
    {
        
        constraints = new LoadConstraints();
        title = new TitleAnim();
        loadPanels = new LoadPanels();
        
//------CHANGE COLOR-----------------------------------------------------
        Color fColor = new Color(221,0,201);
        setBackground(fColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                        
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(525,600);

        loadPanels.PanelsLoop();
        constraints.LoadTitle(title, this);
        constraints.LoadPanels(loadPanels.givePanels(), this);
        


    }
    @SuppressWarnings("static-access")
    public void Run()
    {   
        restart = new RestartEXE();
        Thread gameThread = new Thread(new Runnable() {
            @Override
            public void run()
            {}
        });
        gameThread.setName("Game Run");
        gameThread.start();
        System.out.println("Game Thread alive "  + gameThread.isAlive());
        
        restart.RestartBooleanMenu();
        for(int run = 0; run < 1; run++ )
        {
            System.out.println("for loop started");
            System.out.println("run iteration " + run);
            
            Window();
            while((restart.getButton()==0)||(run < 1))
            {

                System.out.println("run() while loop started");

//-------------breathe------------------------------------------------------------------
                try
            {
                gameThread.sleep(2000);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
//--------------breath--------------------------------------------------------------------
            
            
            if(((this.loadPanels.getWinner()==true)||(this.loadPanels.checkWinner()==true))||this.loadPanels.checkDraw())
            {         
                
                
                restart.showMenu(true);
                
                
               if(restart.getButton()==1)
               {
                restart.showMenu(false);
                System.exit(0);
               }
               System.out.println("exit checked");
               if(restart.getButton()==2)
               {
                restart.showMenu(false);
                System.out.println("Game is restarting");
                loadPanels.resetPanels();
                System.out.println("win set to " + loadPanels.checkWinner());
                //run--;
                //System.out.println("for loop decreased");
                System.out.println("run iteration " + run);
                restart.resetClass();
                restart.showMenu(false);
                
               }
               
            }

            

            
//--------------breath--------------------------------------------------------------------

            try
            {
                gameThread.sleep(1000);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }

//--------------breath--------------------------------------------------------------------
            
            System.out.println("GameRun() while loop check finished");

            }
            System.out.println("GameRun() while loop exited");
            System.out.println("for loop increased");
        }


    }



}
