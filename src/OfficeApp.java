import java.util.Scanner;

import javax.swing.JFrame;

import gui.View;
import office.BigOffice;
import office.MediumOffice;
import office.SmallOffice;
import staff.HighRankingStaff;
import staff.LowRankingStaff;

public class OfficeApp {
  public static void main(String[] args) {
    int choiceOfMode = OfficeApp.modeSelectionPrompt();

    switch (choiceOfMode) {
      case 0:
        System.out.println("Closing");
        return;

      default:
      case 1:
        System.out.println("Minimise your ide or terminal and you should see the message pane :D");
        OfficeApp.guiMode();
        break;

      case 2:
        OfficeApp.consoleMode();
        break;
    }

  }

  private static void guiMode() {
    View view = new View();
    view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    view.pack();
    view.setVisible(true);
  }

  private static void consoleMode() {
    
    LowRankingStaff low1 = new LowRankingStaff("John", "Developer");
    LowRankingStaff low2 = new LowRankingStaff("Peter", "Designer");
    LowRankingStaff low3 = new LowRankingStaff("Dickson", "System Analyst");
    
    HighRankingStaff high1 = new HighRankingStaff("Davidson", "Project Manager");
    HighRankingStaff high2 = new HighRankingStaff("Davidson", "Tech Lead");
    
    
    System.out.println("Initialising three type of offices");
    SmallOffice smallOffice = new SmallOffice();
    MediumOffice mediumOffice = new MediumOffice();
    BigOffice bigOffice = new BigOffice();
    
    smallOffice.displayOccupants();
    mediumOffice.displayOccupants();
    bigOffice.displayOccupants();
    System.out.println();
    
    
    System.out.println("Adding two high ranking staff to Big Office, should have only one to show up");
    bigOffice.addOccupant(high1);
    bigOffice.addOccupant(high2);

    bigOffice.displayOccupants();
    System.out.println();
    
    System.out.println("Adding three low ranking staff to Medium Office, should have only two to show up");
    mediumOffice.addOccupant(low1);
    mediumOffice.addOccupant(low2);
    mediumOffice.addOccupant(low3);

    mediumOffice.displayOccupants();
    System.out.println();

    System.out.println("Adding High Ranking Staff to small office should be invalid");
    smallOffice.addOccupant(high2);

    smallOffice.displayOccupants();
    System.out.println();

    System.out.println("Adding Low Ranking Staff to small office repeatedly should still have only one staff shown");
    smallOffice.addOccupant(low3);
    smallOffice.addOccupant(low3);
    smallOffice.addOccupant(low3);

    smallOffice.displayOccupants();
    System.out.println();


  }

  private static int modeSelectionPrompt() {
    Scanner sc = new Scanner(System.in);
    int answer = Integer.MIN_VALUE;

    while (answer == Integer.MIN_VALUE) {
      System.out.println("Please enter number of intended mode.");
      System.out.println("1. GUI");
      System.out.println("2. Console");
      System.out.println("0. Exit");
      int choice = sc.nextInt();
      if (choice >= 0 && choice <= 2) {
        answer = choice;
      } else {
        System.out.println("Invalid Choice.");
      }
    }

    sc.close();
    return answer;
  }

}
