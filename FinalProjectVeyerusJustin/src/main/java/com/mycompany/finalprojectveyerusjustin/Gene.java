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
    
        public static Gene crossover(Gene parentA, Gene parentB) {
        double speed = RNG.nextBoolean() ? parentA.speed : parentB.speed;
        double efficiency = RNG.nextBoolean() ? parentA.foodEfficiency : parentB.foodEfficiency;
        double size = RNG.nextBoolean() ? parentA.size : parentB.size;
        return new Gene(speed, efficiency, size);
    }

    public Gene mutate(double rate) {
        double newSpeed = speed + (RNG.nextDouble() - 0.5) * rate;
        double newEfficiency = foodEfficiency + (RNG.nextDouble() - 0.5) * rate;
        double newSize = size + (RNG.nextDouble() - 0.5) * rate;
        return new Gene(newSpeed, newEfficiency, newSize);
    }
}
