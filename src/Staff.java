import java.util.Map;

public class Staff {
  enum Ranking {
    LOW,
    MEDIUM,
    HIGH
  }

  // Map for known position and ranking combination
  private static Map<String, Ranking> positionRankMap = Map.of(
      "Manager", Ranking.HIGH,
      "Staff", Ranking.LOW);

  private String name;
  private String position;
  private Ranking ranking;
  private boolean hasOffice;

  /**
   * @param name
   * @param position
   * @param ranking
   */
  public Staff(String name, String position, Staff.Ranking ranking) {
    this.name = name;
    this.position = position;
    this.ranking = ranking;
  }

  /**
   * @param name
   * @param position
   * @throws Exception
   */
  public Staff(String name, String position) throws Exception {
    this.name = name;
    this.position = position;

    if (!positionRankMap.containsKey(position)) {
      throw new Exception("No relevant ranking found for the position. Please use Staff Constructor with ranking");
    }

    this.ranking = positionRankMap.get(position);
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
   * @return the ranking
   */
  public Ranking getRanking() {
    return ranking;
  }

  /**
   * @return the hasOffice
   */
  public boolean hasOffice() {
    return hasOffice;
  }

}
