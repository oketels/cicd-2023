package be.xplore.cicd2022.domain;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class ShipBuilder {

  public UUID id;
  public String name;
  public ShipType type;
  public String owner;
  public String registryNumber;
  public String hullNumber;
  public Float length;
  public List<EngineConfiguration> propulsion;
  public List<WeaponConfiguration> armament;

  public ShipBuilder with(Consumer<ShipBuilder> builderFunction) {
    builderFunction.accept(this);
    return this;
  }

  public Ship build(){
    return new Ship(id, name, type, owner, registryNumber, hullNumber, length, propulsion, armament);
  }

}
