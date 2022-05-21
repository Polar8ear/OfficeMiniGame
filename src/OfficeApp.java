import java.util.Scanner;

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
        OfficeApp.guiMode();
        break;

      case 2:
        OfficeApp.consoleMode();
        break;
    }

  }

  private static void guiMode() {
    View frame = new View();
    frame.setSize(500, 500);
    frame.setVisible(true);
  }

  private static void consoleMode() {
    SmallOffice smallOffice = new SmallOffice();
    MediumOffice mediumOffice = new MediumOffice();
    BigOffice bigOffice = new BigOffice();

    LowRankingStaff low1 = new LowRankingStaff("John", "Developer", smallOffice);
    LowRankingStaff low2 = new LowRankingStaff("Peter", "Designer");
    LowRankingStaff low3 = new LowRankingStaff("Dickson", "System Analyst");

    HighRankingStaff high1 = new HighRankingStaff("Davidson", "Project Manager", mediumOffice);
    HighRankingStaff high2 = new HighRankingStaff("Davidson", "Tech Lead");

    smallOffice.displayOccupants();
    mediumOffice.displayOccupants();
    bigOffice.displayOccupants();
    System.out.println("");

    smallOffice.addOccupant(low2);
    mediumOffice.addOccupant(low3);

    smallOffice.displayOccupants();
    mediumOffice.displayOccupants();
    bigOffice.displayOccupants();
    System.out.println("");

    bigOffice.addOccupant(low2);
    bigOffice.addOccupant(low3);
    bigOffice.addOccupant(high2);

    smallOffice.displayOccupants();
    mediumOffice.displayOccupants();
    bigOffice.displayOccupants();
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
