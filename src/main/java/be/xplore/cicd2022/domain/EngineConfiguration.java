package be.xplore.cicd2022.domain;

public class EngineConfiguration {

  private final String engineType;
  private final int number;

  public EngineConfiguration(String engineType, int number) {
    this.engineType = engineType;
    this.number = number;
  }

  public String getEngineType() {
    return engineType;
  }

  public int getNumber() {
    return number;
  }
}
