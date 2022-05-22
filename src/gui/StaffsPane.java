package gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import helper.MouseClickListener;
import staff.Staff;

public class StaffsPane extends JPanel {
    static int MAX_COLUMN = 2;
    static int GAP = 5;

    public StaffsPane(ArrayList<Staff> staffs, MouseClickListener listener) {
        setBorder(new TitledBorder("Staffs"));
        setLayout(new GridLayout(0,MAX_COLUMN,GAP,GAP));

        for(Staff staff: staffs){
            StaffCardPane staffCard = new StaffCardPane(staff);
            staffCard.addMouseListener(listener);
            add(staffCard);
        }
    }
    
}
