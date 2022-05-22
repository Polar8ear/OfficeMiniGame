package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.plaf.DimensionUIResource;

import office.Office;
import staff.Staff;

public class OfficeSpace extends JPanel {

    static int SMALLEST_SCALE = 150;
    Office office;
    JPanel staffsInfoPanel;

    OfficeSpace(Office office, int rows, int cols){
        this.office = office;
        setLayout(new BorderLayout());
        setPreferredSize(new DimensionUIResource(cols * SMALLEST_SCALE, rows*SMALLEST_SCALE));
        
        setBorder(new LineBorder(Color.BLACK));
        add(new JLabel(this.office.toString(), JLabel.CENTER), BorderLayout.NORTH);

        staffsInfoPanel = new JPanel(new GridLayout(rows, cols));
        add(staffsInfoPanel, BorderLayout.CENTER);
    }

    public Office getOffice() {
        return office;
    }

    public boolean addOccupant(Staff staff){
        
        if(office.addOccupant(staff)){
            JPanel staffInfoPane = new JPanel(new GridLayout(0,1));
            staffInfoPane.add(new JLabel(staff.getPosition(), JLabel.CENTER));
            staffInfoPane.add(new JLabel(staff.getName(), JLabel.CENTER));
            
            staffInfoPane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
            staffInfoPane.setAlignmentY(JPanel.CENTER_ALIGNMENT);

            staffsInfoPanel.add(staffInfoPane);
            staffsInfoPanel.revalidate();
            staffsInfoPanel.repaint();
            return true;
        }
        return false;
    }
    
}
