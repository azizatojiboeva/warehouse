package uz.pdp.warehouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.warehouse.exception.NotFoundException;

@RestController
@RequestMapping("/test/")
public class TestController {

    @GetMapping("testN")
    public String test() {
        throw new NotFoundException("QWE");
    }

    @GetMapping("testIll")
    public String testIll() {
        throw new IllegalArgumentException("QWwE");
    }

    @GetMapping("testRun")
    public String testRun() {
        throw new RuntimeException("QWeE");
    }

}
