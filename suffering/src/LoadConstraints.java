import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JPanel;

public class LoadConstraints {

    
    private GridBagConstraints gbc = new GridBagConstraints();

    public void LoadPanels(JPanel[] pan, Container getCont)
    {
        
        
        
            getCont.setLayout(new GridBagLayout());
            int obj = 0;
            for(int row = 0; row < 3; row++)
            {
                for(int col = 1; col < 4; col++)
                {   
                    
                    gbc.gridx=col;
                    gbc.gridy=row;
                    gbc.fill= GridBagConstraints.BOTH;
                    gbc.weightx = 1.0;
                    gbc.weighty = 1.0;
                    gbc.insets = new Insets(5,5,5,5);
                    pan[obj].setPreferredSize(new Dimension(175,175));
                    getCont.add(pan[obj], gbc);
                    obj++;
                }
            }
        
    }


//-------------------------------------------------------------------------
//
    public void LoadTitle(TitleAnim title, Container getCont)
    {
        gbc.weightx = 3.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth = 3;
        title.setPreferredSize(new Dimension(200,400));
        getCont.add(title,gbc);
        title.setVisible(true);
        
    }
}
