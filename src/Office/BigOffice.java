package Office;

import Staff.HighRankingStaff;
import Staff.LowRankingStaff;
import Staff.Staff;

public class BigOffice extends Office {
  static int MAX_SIZE = 4;

  @Override
  boolean checkValidOccupant(Staff staff) {
    if (this.occupants.isEmpty()) {
      return true;
    }

    if (this.occupants.get(0) instanceof HighRankingStaff) {
      return false;
    }

    if (staff instanceof LowRankingStaff && this.occupants.size() < BigOffice.MAX_SIZE) {
      return true;
    }

    return false;
  }
}