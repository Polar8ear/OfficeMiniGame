package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import helper.MouseClickListener;
import office.BigOffice;
import office.MediumOffice;
import office.SmallOffice;

public class OfficeMapPane extends JPanel {
    OfficeMapPane(MouseClickListener listener){
        setBorder(new TitledBorder("Map"));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill=GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.CENTER;

        OfficeSpace officeSpace;

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        officeSpace = new OfficeSpace(new BigOffice(), gbc.gridheight, gbc.gridwidth);
        officeSpace.addMouseListener(listener);
        add(officeSpace,gbc);
        
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        officeSpace = new OfficeSpace(new MediumOffice(), gbc.gridheight, gbc.gridwidth);
        officeSpace.addMouseListener(listener);
        add(officeSpace,gbc);

        
        gbc.gridx=3;
        gbc.gridy=0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        officeSpace = new OfficeSpace(new SmallOffice(), gbc.gridheight, gbc.gridwidth);
        officeSpace.addMouseListener(listener);
        add(officeSpace,gbc);

        
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        officeSpace = new OfficeSpace(new SmallOffice(), gbc.gridheight, gbc.gridwidth);
        officeSpace.addMouseListener(listener);
        add(officeSpace,gbc);

        
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        officeSpace = new OfficeSpace(new MediumOffice(), gbc.gridheight, gbc.gridwidth);
        officeSpace.addMouseListener(listener);
        add(officeSpace,gbc);

        
        
        gbc.gridx=3;
        gbc.gridy=1;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        officeSpace = new OfficeSpace(new MediumOffice(), gbc.gridheight, gbc.gridwidth);
        officeSpace.addMouseListener(listener);
        add(officeSpace,gbc);
        

    }
}
