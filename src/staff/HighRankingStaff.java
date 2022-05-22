package staff;

public class HighRankingStaff extends Staff {

  /**
   * @param name
   * @param position
   */
  public HighRankingStaff(String name, String position) {
    super(name, position);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return String.format("Senior: %s", super.toString());
  }

}