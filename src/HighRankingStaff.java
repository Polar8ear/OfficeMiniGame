public class HighRankingStaff extends Staff {

  /**
   * @param name
   * @param position
   */
  public HighRankingStaff(String name, String position) {
    super(name, position);
  }

  /**
   * @param name
   * @param position
   * @param office
   */
  public HighRankingStaff(String name, String position, Office office) {
    super(name, position, office);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return String.format("Senior: %s %s %s", this.getName(), this.getPosition(), this.getOffice());
  }

}