package com.bruce;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bruce
 */
@RestController
@RequestMapping("/demo01")
public class DemoController {

    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }
}
