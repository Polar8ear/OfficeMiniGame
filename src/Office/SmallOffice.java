package Office;

import Staff.LowRankingStaff;
import Staff.Staff;

public class SmallOffice extends Office {
  static int MAX_SIZE = 1;

  @Override
  boolean checkValidOccupant(Staff staff) {
    return this.occupants.isEmpty() && staff instanceof LowRankingStaff;
  }

}
