package be.xplore.cicd2022.domain;

public class WeaponConfiguration {

  private final String description;
  private final int number;

  public WeaponConfiguration(String description, int number) {
    this.description = description;
    this.number = number;
  }

  public String getDescription() {
    return description;
  }

  public int getNumber() {
    return number;
  }
}
