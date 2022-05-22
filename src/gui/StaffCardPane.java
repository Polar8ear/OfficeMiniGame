package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import staff.LowRankingStaff;
import staff.Staff;

public class StaffCardPane extends JPanel{
    Staff staff;
    boolean isSelected;

    StaffCardPane(Staff staff){
        this.staff = staff;

        setBorder(new LineBorder(Color.BLACK));
        setBackground(new Color(120, 195, 245));
        setOpaque(false);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(150,100));

        add(Box.createVerticalGlue());
        
        try {
            String imagePath = "src/images/" + (this.staff instanceof LowRankingStaff ? "LowRankingStaff.png" : "HighRankingStaff.png");
            BufferedImage originalImage;
            originalImage = ImageIO.read(new File(imagePath));
            Image resizedImage = originalImage.getScaledInstance(64, 64, Image.SCALE_DEFAULT);
            JLabel icon = new JLabel(new ImageIcon(resizedImage));
            icon.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        JPanel infoPane = new JPanel();
        infoPane.setLayout(new BoxLayout(infoPane, BoxLayout.Y_AXIS));
        infoPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        infoPane.add(new JLabel(this.staff.getPosition()));
        infoPane.add(new JLabel(this.staff.getName()));
        
        add(infoPane);

        add(Box.createVerticalGlue());
    }

    public Staff getStaff(){
        return staff;
    }

    public void setSelected(Boolean bool){
        setOpaque(bool);
        repaint();
        this.isSelected = bool;
    }
}