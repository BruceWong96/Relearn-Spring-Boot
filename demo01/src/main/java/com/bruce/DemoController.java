package com.bruce;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bruce
 */
@Setter
@Getter
@RestController
@RequestMapping("/demo01")
public class DemoController {

    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }


    private String name;

}

class Test {
    public static void main(String[] args) {
        DemoController demoController = new DemoController();
        demoController.setName("nihao");
        System.out.println(demoController.getName());
    }
}