public class LowRankingStaff extends Staff {

  /**
   * @param name
   * @param position
   */
  public LowRankingStaff(String name, String position) {
    super(name, position);
  }

  /**
   * @param name
   * @param position
   * @param officeId
   */
  public LowRankingStaff(String name, String position, String officeId) {
    super(name, position, officeId);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return String.format("Junior: %s %s %s", this.getName(), this.getPosition(), this.getOffice());
  }

}
