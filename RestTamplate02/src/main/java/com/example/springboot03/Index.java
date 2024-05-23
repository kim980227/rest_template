package com.example.springboot03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Index {
  @RequestMapping("/")
  public String func01() {
    return "index";
  }

  @RequestMapping("/tiger")
  public String func02() {
    return "tiger";
  }

}

@RestController
@RequestMapping("/bpp1")
class AppController() {
  @GetMapping("")
  String f1() {
    System.out.println("bpp1");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return "서비스 광고를 시작합니다.";
  }
}
