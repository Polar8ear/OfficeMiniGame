package staff;

public class LowRankingStaff extends Staff {

  /**
   * @param name
   * @param position
   */
  public LowRankingStaff(String name, String position) {
    super(name, position);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return String.format("Junior: %s", super.toString());
  }

}
