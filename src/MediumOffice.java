public class MediumOffice extends Office {
  static int MAX_SIZE = 2;

  @Override
  boolean checkValidOccupant(Staff staff) {
    if (this.occupants.isEmpty()) {
      return true;
    }

    if (this.occupants.get(0) instanceof HighRankingStaff) {
      return false;
    }

    if (staff instanceof LowRankingStaff && this.occupants.size() < MediumOffice.MAX_SIZE) {
      return true;
    }

    return false;
  }
}
