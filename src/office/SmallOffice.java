package office;

import staff.LowRankingStaff;
import staff.Staff;

public class SmallOffice extends Office {
  int MAX_SIZE = 1;

  @Override
  boolean checkValidOccupant(Staff staff) {
    return this.occupants.isEmpty() && staff instanceof LowRankingStaff;
  }

}
