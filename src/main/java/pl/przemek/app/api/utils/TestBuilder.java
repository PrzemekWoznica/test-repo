package pl.przemek.app.api.utils;

import org.springframework.stereotype.Component;

@Component
public class TestBuilder {
    public static Long numberBuilder(Integer min, Integer max) {
        return Math.round(Math.random() * (max - min) + min);
    }
}
