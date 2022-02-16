package be.xplore.cicd2022;

import be.xplore.cicd2022.domain.Ship;
import be.xplore.cicd2022.domain.ShipItem;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/ships", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShipController {

  private final ShipService shipService;

  public ShipController(ShipService shipService) {
    this.shipService = shipService;
  }

  @GetMapping()
  public List<ShipItem> getAllShips() {
    return shipService.getAllShips().stream().map(ShipItem::from).collect(Collectors.toList());
  }

  @GetMapping(path = "/{ship-id}")
  public Ship getDetails(@PathVariable("ship-id") UUID shipId) {
    return shipService.getDetails(shipId);
  }

  @PostMapping
  public void addShip(@RequestBody Ship ship){
    shipService.addShip(ship);
  }

  @PutMapping(path = "/{ship-id}")
  public void updateShip(@PathVariable("ship-id") UUID shipId, @RequestBody Ship ship) {
    shipService.updateShip(shipId, ship);
  }

  @DeleteMapping(path = "/{ship-id}")
  public void removeShip(@PathVariable("ship-id") UUID shipId) {
    shipService.removeShip(shipId);
  }

}
