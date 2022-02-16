package be.xplore.cicd2022.domain;

import java.util.UUID;

public class ShipItem {

  private UUID id;
  private String name;
  private ShipType type;

  public UUID getId() {
    return id;
  }

  public ShipItem setId(UUID id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public ShipItem setName(String name) {
    this.name = name;
    return this;
  }

  public ShipType getType() {
    return type;
  }

  public ShipItem setType(ShipType type) {
    this.type = type;
    return this;
  }

  public static ShipItem from(Ship ship) {
    ShipItem item = new ShipItem();
    item.setId(ship.getId());
    item.setName(ship.getName());
    item.setType(ship.getType());
    return item;
  }

}
