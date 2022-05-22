package gui;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import helper.MouseClickListener;
import staff.HighRankingStaff;
import staff.LowRankingStaff;
import staff.Staff;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    JLabel timerLabel;
    JButton submitBtn;
    Date startingDate;
    Timer timer;
    String timecode;
    ArrayList<Staff> staffs;
    private JLabel notificationLabel;
    static String STARTING_MESSAGE = String.join("\n",
        "Hi, welcome to Office Mini Game.",
        "Your task is to bring the staffs to offices that suit them.",
        "Remember. High Ranking Staff like manager stays alone in spacious office \nwhile Low Ranking Staff can share office together.",
        "Click the staff once and then click the office to put them in.",
        "Enjoy!"
    );

    public View() {
        setTitle("Office Mini Game");
        // setIconImage();  

        staffs = new ArrayList<>();
        staffs.add(new HighRankingStaff("Sheldon", "Manager"));
        staffs.add(new HighRankingStaff("Penny", "Project Lead"));
        staffs.add(new HighRankingStaff("Amy", "Senior Data Scientist"));
        staffs.add(new LowRankingStaff("Leonard", "DevOps Engineer"));
        staffs.add(new LowRankingStaff("Howard", "Frontend Developer"));
        staffs.add(new LowRankingStaff("Bernadette", "Backend Devloper"));
        staffs.add(new LowRankingStaff("Raj", "Data Analyst"));        

        MouseClickListener listener = new MouseClickListener();

        StaffsPane staffsPane = new StaffsPane(staffs, listener);
        OfficeMapPane mapPane = new OfficeMapPane(listener);

        listener.setOfficeMapPane(mapPane);
        listener.setStaffsPane(staffsPane);

        Container mainPane = getContentPane();
        mainPane.setLayout(new BorderLayout());

        mainPane.add(staffsPane, BorderLayout.EAST);
        mainPane.add(mapPane, BorderLayout.CENTER);

        JPanel resultPane = new JPanel();
        resultPane.setLayout(new BoxLayout(resultPane, BoxLayout.X_AXIS));
        
        
        timerLabel = new JLabel("00:00:00");
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        
        notificationLabel = new JLabel("");
        notificationLabel.setAlignmentX(RIGHT_ALIGNMENT);
        notificationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        notificationLabel.setPreferredSize(new DimensionUIResource(250, 10));

        listener.setNotificationJLabel(notificationLabel);

        resultPane.add(Box.createHorizontalStrut(5));
        resultPane.add(timerLabel);
        resultPane.add(Box.createHorizontalGlue());
        resultPane.add(Box.createHorizontalGlue());
        resultPane.add(submitBtn);
        resultPane.add(Box.createHorizontalGlue());
        resultPane.add(notificationLabel);
        resultPane.add(Box.createHorizontalStrut(5));

        mainPane.add(resultPane, BorderLayout.SOUTH);

        JOptionPane.showMessageDialog(this,STARTING_MESSAGE);
        startTimer();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == submitBtn){
            timer.stop();

            boolean hasWon = true;
            for(Staff staff: staffs){
                if(staff.getOffice()==null){
                    hasWon = false;
                    break;
                }
            }

            if(hasWon){
                JOptionPane.showMessageDialog(this, "Congratulation! You have won the game in " + timecode);
            }else{
                JOptionPane.showMessageDialog(this, "Oh too bad, you failed the challenge just now. Why not try again?" );
            }

            System.exit(0);
        }
        
   
    }

    private void startTimer(){
        startingDate = new Date();
        ActionListener timeListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int duration = (int)(new Date().getTime() - startingDate.getTime());
                int minutes = duration / 60000;
                int seconds = duration / 1000;
                int milliseconds = (int) (duration % 1000 / 1000.0 * 60);
                timecode = String.format("%02d:%02d:%02d", minutes,seconds,milliseconds);
                timerLabel.setText(timecode);
            }
        };

        timer = new Timer(10, timeListener);
        timer.start();
    }

    
    
}
