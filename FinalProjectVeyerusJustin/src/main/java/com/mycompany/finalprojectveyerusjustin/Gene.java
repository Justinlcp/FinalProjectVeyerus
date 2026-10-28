package com.mycompany.finalprojectveyerusjustin;

import java.util.Random;

public class Gene {
    private double speed;
    private double foodEfficiency;
    private double size;

    private static final Random RNG = new Random();

    public Gene(double speed, double foodEfficiency, double size) {
        this.speed = speed;
        this.foodEfficiency = foodEfficiency;
        this.size = size;
    }

    public double getSpeed() { return speed; }
    public double getFoodEfficiency() { return foodEfficiency; }
    public double getSize() { return size; }
}
