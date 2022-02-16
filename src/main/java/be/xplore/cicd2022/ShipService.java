package be.xplore.cicd2022;

import be.xplore.cicd2022.domain.EngineConfiguration;
import be.xplore.cicd2022.domain.Ship;
import be.xplore.cicd2022.domain.ShipBuilder;
import be.xplore.cicd2022.domain.ShipType;
import be.xplore.cicd2022.domain.WeaponConfiguration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ShipService {

  List<Ship> ships = new ArrayList<>();

  @PostConstruct
  private void init(){

    ships.add(new ShipBuilder()
        .with(s -> {
          s.id = UUID.randomUUID();
          s.name = "Rocinante";
          s.type = ShipType.FRIGATE;
          s.registryNumber = "ECF-240";
          s.length = Float.valueOf(46.0f);
          s.hullNumber = "158";
          s.owner = "Independent";
          s.propulsion = List.of(new EngineConfiguration("Epstein Drive", 1));
          s.armament = List.of(new WeaponConfiguration("Nariman Dynamics 40mm PDC", 6),
              new WeaponConfiguration("torpedo launchers", 2),
              new WeaponConfiguration("rail gun", 1));
        }).build());

    ships.add(new ShipBuilder()
        .with(s -> {
          s.id = UUID.randomUUID();
          s.name = "Donnager";
          s.type = ShipType.BATTLESHIP;
          s.registryNumber = "unknown";
          s.length = Float.valueOf(475.5f);
          s.hullNumber = "84";
          s.owner = "Martian Congressional Republic Navy";
          s.propulsion = List.of(new EngineConfiguration("RT-10 'Kaminari' Epstein Drives", 4));
          s.armament = List.of(new WeaponConfiguration("VX-12 Foehammer Turreted Ultra-Heavy Railgun", 2),
              new WeaponConfiguration("forward Torpedo Launcher", 6),
              new WeaponConfiguration("aft Torpedo Launcher", 8),
              new WeaponConfiguration("Nariman Dynamics 40mm PDC", 59));
        }).build());

    ships.add(new ShipBuilder()
        .with(s -> {
          s.id = UUID.randomUUID();
          s.name = "Amun-Ra";
          s.type = ShipType.FRIGATE;
          s.registryNumber = "unknown";
          s.length = Float.valueOf(24.2f);
          s.hullNumber = "unknown";
          s.owner = "Protogen";
          s.propulsion = List.of(new EngineConfiguration("Bush shipyards 'Silversmith' supercooled Epstein drive", 1));
          s.armament = List.of(new WeaponConfiguration("prototype internally-mounted S-24 Khopesh light Railgun", 1),
              new WeaponConfiguration("Bush shipyards hypercooled PDC", 4),
              new WeaponConfiguration("rapid-reload torpedo bay", 2));
        }).build());

    ships.add(new ShipBuilder()
        .with(s -> {
          s.id = UUID.randomUUID();
          s.name = "Agatha King";
          s.type = ShipType.DREADNOUGHT;
          s.registryNumber = "T-DRN-32";
          s.length = Float.valueOf(376f);
          s.hullNumber = "unknown";
          s.owner = "United Nations Navy";
          s.propulsion = List.of(new EngineConfiguration("S-400 Series Epstein Drive", 6), new EngineConfiguration("thruster", 10));
          s.armament = List.of(new WeaponConfiguration("Autoloading Torpedo Tube (conventional, plasma and nuclear warheads)", 9),
              new WeaponConfiguration("Redfield Ballistics 40 mm Point Defense Cannon", 42));
        }).build());
  }

  public List<Ship> getAllShips() {
    return ships;
  }

  public Ship getDetails(UUID uuid) {
    return ships.stream().filter(s -> s.getId().equals(uuid)).findFirst().get();
  }

  public void addShip(Ship ship) {
    ships.add(ship);
  }


  public void updateShip(UUID uuid, Ship ship) {
    ships.removeIf(s -> s.getId().equals(uuid));
    ships.add(ship);
  }

  public void removeShip(UUID uuid) {
    ships.removeIf(s -> s.getId().equals(uuid));
  }

}
