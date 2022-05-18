import java.util.ArrayList;

public abstract class Office {
  static int MAX_SIZE = 1;
  ArrayList<Staff> occupants;

  /**
   * 
   */
  public Office() {
    this.occupants = new ArrayList<>();
  }

  void displayOccupants() {
    System.out.println(String.format("This %s has the following occupant(s)", super.toString()));
    for (Staff occupant : occupants) {
      System.out.println(String.format("- %s", occupant));
    }
  }

  abstract boolean checkValidOccupant(Staff staff);

  boolean addOccupant(Staff staff) {
    if (checkValidOccupant(staff)) {
      this.occupants.add(staff);
      return true;
    }

    return false;
  }
}
