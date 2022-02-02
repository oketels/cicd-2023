package be.xplore.cicd2022;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloWorldController {

  @GetMapping("/hello")
  public String sayHello(){
    return "hello there, it is now " + new Date() + " !";
  }

}
