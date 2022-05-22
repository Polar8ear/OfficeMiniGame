package office;

import staff.HighRankingStaff;
import staff.LowRankingStaff;
import staff.Staff;

public class MediumOffice extends Office {
  int MAX_SIZE = 2;

  @Override
  boolean checkValidOccupant(Staff staff) {
    if (this.occupants.isEmpty()) {
      return true;
    }

    if (this.occupants.get(0) instanceof HighRankingStaff) {
      return false;
    }

    if (staff instanceof LowRankingStaff && this.occupants.size() < this.MAX_SIZE) {
      return true;
    }

    return false;
  }
}
