package br.com.game.of.thrones.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Calc {

    public BigDecimal sum(BigDecimal valueOne, BigDecimal valueTwo) {
        return valueOne.add(valueTwo);
    }

    public BigDecimal subtract(BigDecimal valueOne, BigDecimal valueTwo) {
        return valueOne.subtract(valueTwo);
    }
}
