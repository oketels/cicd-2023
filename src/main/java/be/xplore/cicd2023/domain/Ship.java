package be.xplore.cicd2023.domain;

import java.util.List;
import java.util.UUID;

public class Ship {

  private final UUID id;
  private final String name;
  private final ShipType type;
  private final String owner;
  private final String registryNumber;
  private final String hullNumber;
  private final Float length;
  private final List<EngineConfiguration> propulsion;
  private final List<WeaponConfiguration> armament;

  public Ship(UUID id, String name, ShipType type, String owner, String registryNumber, String hullNumber, Float length, List<EngineConfiguration> propulsion, List<WeaponConfiguration> armament) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.owner = owner;
    this.registryNumber = registryNumber;
    this.hullNumber = hullNumber;
    this.length = length;
    this.propulsion = propulsion;
    this.armament = armament;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public ShipType getType() {
    return type;
  }

  public String getOwner() {
    return owner;
  }

  public String getRegistryNumber() {
    return registryNumber;
  }

  public String getHullNumber() {
    return hullNumber;
  }

  public Float getLength() {
    return length;
  }

  public List<EngineConfiguration> getPropulsion() {
    return propulsion;
  }

  public List<WeaponConfiguration> getArmament() {
    return armament;
  }

}
