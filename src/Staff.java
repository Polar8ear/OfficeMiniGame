public abstract class Staff {

  private String name;
  private String position;
  private String officeId;

  /**
   * @param name
   * @param position
   */
  public Staff(String name, String position) {
    this.name = name;
    this.position = position;
    this.officeId = "";
  }

  /**
   * @param name
   * @param position
   * @param officeId
   */
  public Staff(String name, String position, String officeId) {
    this.name = name;
    this.position = position;
    this.officeId = officeId;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the position
   */
  public String getPosition() {
    return position;
  }

  /**
   * @return the officeId
   */
  public String getOffice() {
    if (officeId.equals("")) {
      return "No Office";
    }

    return officeId;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return String.format("%s %s %s", this.getName(), this.getPosition(), this.getOffice());
  }

}
