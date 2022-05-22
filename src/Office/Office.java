package office;

import java.util.ArrayList;

import staff.Staff;

public abstract class Office {
  static int MAX_SIZE = 1;
  ArrayList<Staff> occupants;

  /**
   * 
   */
  public Office() {
    this.occupants = new ArrayList<>();
  }

  public void displayOccupants() {
    System.out.println(String.format("This %s has the following occupant(s)", super.toString()));
    for (Staff occupant : occupants) {
      System.out.println(String.format("- %s", occupant));
    }
  }

  abstract boolean checkValidOccupant(Staff staff);

  public boolean addOccupant(Staff staff) {
    if (checkValidOccupant(staff) && !occupants.contains(staff)) {
      this.occupants.add(staff);
      staff.setOffice(this);
      return true;
    }

    return false;
  }
  
  public boolean removeOccupant(Staff staff) {
    return occupants.remove(staff);
  }

  @Override
  public String toString() {
      return String.format("%s", this.getClass().getSimpleName());
  }
  
}
