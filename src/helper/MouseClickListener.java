package helper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.OfficeSpace;
import gui.StaffCardPane;
import staff.Staff;

public class MouseClickListener implements MouseListener{
    Staff selectedStaff;
    StaffCardPane selectedStaffCardPane;
    JPanel OfficeMapPane;
    JPanel staffsPane;
    JLabel notificationJLabel;
    Timer timer;    


    public MouseClickListener() {
        super();
        timer = new Timer();
    }

    public void setNotificationJLabel(JLabel notificationJLabel) {
        this.notificationJLabel = notificationJLabel;
    }

    public void setOfficeMapPane(JPanel officeMapPane) {
        OfficeMapPane = officeMapPane;
    }

    public void setStaffsPane(JPanel staffsPane) {
        this.staffsPane = staffsPane;
    }

    public Staff getSelectedStaff() {
        return selectedStaff;
    }

    public void setSelectedStaff(Staff selectedStaff) {
        this.selectedStaff = selectedStaff;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();

        if(obj instanceof StaffCardPane staffCard){

            if(selectedStaffCardPane != null){
                selectedStaffCardPane.setSelected(false);
            }

            if(staffCard.equals(selectedStaffCardPane)){
                this.selectedStaffCardPane = null;
                this.selectedStaff = null;
            }else{
                this.selectedStaffCardPane = staffCard;
                this.selectedStaffCardPane.setSelected(true);
                this.selectedStaff = selectedStaffCardPane.getStaff();
            }
            staffsPane.revalidate();
            staffsPane.repaint();
            return;
        }
        
        if(obj instanceof OfficeSpace officeSpace){
            if(selectedStaff == null){
                showNotifiaction("You should select a staff first.");
                return;
            }
            
            officeSpace.addOccupant(selectedStaff);
            selectedStaffCardPane.setSelected(false);
            this.selectedStaffCardPane = null;
            this.selectedStaff = null;
            OfficeMapPane.revalidate();
            OfficeMapPane.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void showNotifiaction(String message){
        notificationJLabel.setText(message);

        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                notificationJLabel.setText("");
            }

        }, 5000);
    }

    
}