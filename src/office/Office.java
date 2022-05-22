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

    if(occupants.isEmpty()){
      System.out.println(String.format("This %s currently does not have any occupant.", getClass().getSimpleName()));
      return;
    }

    System.out.println(String.format("This %s has the following occupant(s):", getClass().getSimpleName()));
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
