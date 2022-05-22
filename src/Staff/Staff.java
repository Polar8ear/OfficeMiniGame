package staff;

import office.Office;

public abstract class Staff{

  private String name;
  private String position;
  private Office office;

  /**
   * @param name
   * @param position
   */
  public Staff(String name, String position) {
    this.name = name;
    this.position = position;
  }

  /**
   * @param name
   * @param position
   * @param officeId
   */
  public Staff(String name, String position, Office office) {
    this.name = name;
    this.position = position;
    this.setOffice(office);
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
  public Office getOffice() {
    return office;
  }

  /**
   * @param office the office to set
   */
  public void setOffice(Office office) {
    if(this.office != null){
      this.office.removeOccupant(this);
      return;
    }

    this.office = office;
    
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
