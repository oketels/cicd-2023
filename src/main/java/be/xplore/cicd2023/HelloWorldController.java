package be.xplore.cicd2023;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class HelloWorldController {

  @GetMapping("/hello")
  public String sayHello(){

    Calendar calendar = Calendar.getInstance();
    String greeting = calendar.get(Calendar.AM_PM) == Calendar.AM ? "morning" : "afternoon";

    return "hello there, on this fine " + greeting + " !";

  }

}
