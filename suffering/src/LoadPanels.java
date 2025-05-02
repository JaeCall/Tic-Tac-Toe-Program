
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;






public class LoadPanels extends JPanel {

public JPanel[] panels;
private boolean[] panelSet;
private boolean[] xSet;
private boolean[] oSet;
private boolean  xTurn = true;
private boolean win;
ImageX[] xArray;
ImageO[] oArray;
ImageX localX;
ImageO localO;
int index;



    public void PanelsLoop()
    {
        panelSet = new boolean[9];
        xSet = new boolean[9];
        oSet = new boolean[9];
        panels = new JPanel[9];
        xArray = new ImageX[9];
        oArray = new ImageO[9];
        
        //Vapor Wave Colors NEEDS CHANGING
      
        Color bColor = new Color(128, 0, 128);
        
        for(int i = 0; i < 9; i++)
        {   
            final int index = i;
            xArray[i] = new ImageX();
            oArray[i] = new ImageO();
            
            panels[i] = new JPanel();
            panels[i].setBackground(bColor);
            panels[i].add(xArray[i]);
            panels[i].add(oArray[i]);
        
            oArray[i].setVisible(false);
            xArray[i].setVisible(false);
            System.out.println("X set for panel " + index + xSet[index]);
            System.out.println("O set for panel " + index + oSet[index]);
            panels[i].addMouseListener(new MouseListener()
                {
                    
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if((panelSet[index]==false)&&(win==false)){
                        if((xTurn == true) && (panelSet[index]!=true))
                        {
                            
                            
                            
                            xSet[index] = true;
                            panelSet[index]=true; 
                            resetImage(index);
                        }
                        else
                        {
                            
                            
                            
                            oSet[index] = true;
                            panelSet[index]=true; 
                            resetImage(index);
                            
                        }
                        checkWinner();     
                                 
                        System.out.println("Panel " + index + "clicked." );
                        System.out.println("X set for panel " + index + xSet[index]);
                        System.out.println("O set for panel " + index + oSet[index]);
                        System.out.println("x turn " + xTurn);
                        System.out.println("Mouse clicked");
                        
                        //checkWinner(this);      
                        //if(win == true){ restart(); }
                        }
                        
                    }

                    
                    
                    public void mousePressed(MouseEvent e) 
                    {
                        if((panelSet[index]==false)&&(win==false)){
                        if(xTurn == true)
                        {
                            
                            
                            xArray[index].toggleImage();
                            xSet[index] = true;
                            panelSet[index]=true; 
                            resetImage(index);
                        }
                        else
                        {
                            
                            
                            oArray[index].toggleImage();
                            oSet[index] = true;
                            panelSet[index]=true; 
                            resetImage(index);
                        }
                        checkWinner();       
                        changeTurns();                   
                        System.out.println("Panel " + index + "clicked." );
                        System.out.println("X set for panel " + index + xSet[index]);
                        System.out.println("O set for panel " + index + oSet[index]);
                        System.out.println("x turn " + xTurn);
                        System.out.println("Mouse pressed");
                        //checkWinner(this);      
                        //if(win == true){ restart(); }
                    
                    }}
    
                    @Override
                    public void mouseReleased(MouseEvent e) 
                    {
                        if((panelSet[index]==false)&&(win==false)){
                        if((xTurn == true) && (panelSet[index]!=true))
                        {
                            
                            
                            //changeTurns();
                            xSet[index] = true;
                            resetImage(index);
                        }
                        else
                        {
                            
                            
                            //changeTurns();
                            oSet[index] = true;
                            resetImage(index);
                        }
                        panelSet[index]=true; 
                        checkWinner();                            
                        System.out.println("Panel " + index + "clicked." );
                        System.out.println("X set for panel " + index + xSet[index]);
                        System.out.println("O set for panel " + index + oSet[index]);
                        System.out.println("x turn " + xTurn);
                        System.out.println("Mouse released");
                        //checkWinner();        
                        }
                    }
                   
                    @Override
                    public void mouseEntered(MouseEvent e) 
                    {
                        if((panelSet[index]==false)&&(win==false))
                        {
                            if(xTurn == true)
                            {
                                xArray[index].toggleImage();
                                xArray[index].setVisible(true);
                                //resetImage(index);
                            }
                            else
                            {
                                oArray[index].toggleImage();
                                oArray[index].setVisible(true);
                                //resetImage(index);
                            }
                        }
                        
                        System.out.println("Mouse entered a panel " + index );
                        
                    }

               
                    public void mouseExited(MouseEvent e) 
                    {
                       
                       if((panelSet[index]==false)&&(win==false))
                        {
                            if(xTurn == true)
                            {
                                xArray[index].toggleImage();
                                xArray[index].setVisible(false);
                                
                                //setting the toggle back to the set image
                                //resetImage(index);
                            }
                            else
                            {   
                                //setting the toggle back to the set image
                                oArray[index].toggleImage();
                                oArray[index].setVisible(false);
                                //resetImage(index);
                            }
                        }
                    
                       System.out.println("Mouse exited a panel "  + index);
                    }

                
            });
            
        }
     }
//------------------------------------------------------------------------------
//  

     public JPanel[] givePanels()
     {
        return panels;

     }


//-----------------------------------------------------------------------------
//

     public void changeTurns()
     {
       xTurn=!xTurn;
        
     }


//------------------------------------------------------------------------------
//


    
//-------------------------------------------------------------------------------
//
public void resetImage(int i)
{
    if(this.win==false){
        System.out.println("resetImage() regular refresh");
    if(xSet[i]==true)
    {
        xArray[i].setVisible(true);
    }
    if(oSet[i]==true)
    {
        oArray[i].setVisible(true);
    }
    if(xSet[i]==false)
    {
        xArray[i].setVisible(false);
    }
    if(oSet[i]==false)
    {
        oArray[i].setVisible(false);
    }
    }
    if(this.win==true)
    {
        System.out.println("resetImage() post win freeze");
        oArray[i].reset();
        xArray[i].reset();
        oArray[i].setVisible(false);
        xArray[i].setVisible(false);
    }
    

}

//-------------------------------------------------------------------------------
//
public void resetPanels()
{
    
    xTurn = true;
    System.out.println("resetPanels() executed");
    for(int i = 0; i < 9; i++)
    {
        
        panelSet[i] = false;
        xSet[i] = false;
        oSet[i] = false;
        resetImage(i);

        panels[i].repaint();
        System.out.println("resetPanels() executed. panelSet["+i+"]= " + panelSet[i]);
        System.out.println("resetPanels() executed. xSet["+i+"]= " + xSet[i]);
        System.out.println("resetPanels() executed. oSet["+i+"]= " + oSet[i]);
    }

    win = false;
    System.out.println(" Win value set to " + win);
}

//------------------------------------------------------------------------------
//
public boolean checkDraw()
{
    boolean draw = false;
    for(int i = 0; i < 9;i++)
    {
        if(panelSet[i])
        {

        }
        else
        {

            break;
        }
        if(i==8)
        {
            draw = true;
        }
    }
    return draw;
}

//------------------------------------------------------------------------------
//
    public boolean checkWinner()
    {   
        
        String winnerFound = null;
        
        
        for(int a = 0; a <= 8; a++)
        {
            switch(a)
            {
                case 0:
                    System.out.println("win condition case " + a + " checked" );
                    if((this.xSet[0]==true)&&(this.xSet[1]==true)&&(this.xSet[2]==true))
                    {
                        
                        winnerFound = "X is the Winner!!!";
                        win = true;
                    }
                    if((this.oSet[0]==true)&&(this.oSet[1]==true)&&(this.oSet[2]==true))
                    {
                        
                        winnerFound = "O is the Winner!!!";
                        win = true;
                    }
                    
                    break;
                case 1:
                    System.out.println("win condition case " + a + " checked" );
                    if((this.xSet[3]==true)&&(this.xSet[4]==true)&&(this.xSet[5]==true))
                    {
                        
                        winnerFound = "X is the Winner!!!";
                        win = true;
                    }
                    if((this.oSet[3]==true)&&(this.oSet[4]==true)&&(this.oSet[5]==true))
                    {
                        
                        winnerFound = "O is the Winner!!!";
                        win = true;
                    }
                    break;
                case 2:
                    System.out.println("win condition case " + a + " checked" );
                    if((this.xSet[6]==true)&&(this.xSet[7]==true)&&(this.xSet[8]==true))
                    {
                        
                        winnerFound = "X is the Winner!!!";
                        win = true;
                    }
                    if((this.oSet[6]==true)&&(this.oSet[7]==true)&&(this.oSet[8]==true))
                    {
                        
                        winnerFound = "O is the Winner!!!";
                        win = true;
                    }
                    break;
                case 3:
                    System.out.println("win condition case " + a + " checked" );
                    if((this.xSet[0]==true)&&(this.xSet[3]==true)&&(this.xSet[6]==true))
                    {
                        
                        winnerFound = "X is the Winner!!!";
                        win = true;
                    }
                    if((this.oSet[0]==true)&&(this.oSet[3]==true)&&(this.oSet[6]==true))
                    {
                        winnerFound = "O is the Winner!!!";
                        win = true;
                    }
                    break;
                case 4:
                    System.out.println("win condition case " + a + " checked" );
                    if((this.xSet[1]==true)&&(this.xSet[4]==true)&&(this.xSet[7]==true))
                    {
                        winnerFound = "X is the Winner!!!";
                        win = true;
                    }
                    if((this.oSet[1]==true)&&(this.oSet[4]==true)&&(this.oSet[7]==true))
                    {
                        winnerFound = "O is the Winner!!!";
                        win = true;
                    }
                    break;
                case 5:
                System.out.println("win condition case " + a + " checked" );
                    if((this.xSet[2]==true)&&(this.xSet[5]==true)&&(this.xSet[8]==true))
                    {
                        winnerFound = "X is the Winner!!!";
                        win = true;
                    }
                    if((this.oSet[2]==true)&&(this.oSet[5]==true)&&(this.oSet[8]==true))
                    {
                        winnerFound = "O is the Winner!!!";
                        win = true;
                    }
                    break;
                case 6:
                System.out.println("win condition case " + a + " checked" );
                    if((this.xSet[0]==true)&&(this.xSet[4]==true)&&(this.xSet[8]==true))
                    {
                        winnerFound = "X is the Winner!!!";
                        win = true;
                    }
                    if((this.oSet[0]==true)&&(this.oSet[4]==true)&&(this.oSet[8]==true))
                    {
                        winnerFound = "O is the Winner!!!";
                        win = true;
                    }
                    break;
                case 7:
                System.out.println("win condition case " + a + " checked" );
                    if((this.xSet[2]==true)&&(this.xSet[4]==true)&&(this.xSet[6]==true))
                    {
                        winnerFound = "X is the Winner!!!";
                        win = true;
                    }
                    if((this.oSet[2]==true)&&(this.oSet[4]==true)&&(this.oSet[6]==true))
                    {
                        winnerFound = "O is the Winner!!!";
                        win = true;
                    }
                    break;

                case 8:
                    if(checkDraw())
                    {
                        win=false;
                    }
                    
                    break;
                    
                    
            }
            if(win==true)
            {
                System.out.println("Winner found "+ winnerFound);
                  
            }
            
            
        }
        System.out.println("checkWinner() executed. Value " + win);
        return win;
        
    }

    public boolean getWinner()
    {
        System.out.println("getWinner() executed. Value " + win);
        return win;
    }

}

