package pl.przemek.app.api.controller;

import org.springframework.web.bind.annotation.*;
import pl.przemek.app.api.service.TestService;

@RestController
@RequestMapping("/api")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    public void addModel(@RequestBody String content) {
        testService.newModel(content);
    }

    @DeleteMapping("/{id}")
    public void removeModel(@PathVariable Long id) {
        testService.pullModel(id);
    }
}
