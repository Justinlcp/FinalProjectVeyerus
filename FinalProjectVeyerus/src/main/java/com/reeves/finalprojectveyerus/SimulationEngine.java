package com.reeves.finalprojectveyerus;

import java.util.List;

public class SimulationEngine {
    private final Environment environment;
    private final MovementController movement = new MovementController();
    private final ReproductionManager reproduction = new ReproductionManager();
    private int tickCount = 0;
    private int generation = 0;

    private static final double FEED_DISTANCE = 14;
    private static final double ENERGY_PER_TICK = 0.5;

    private double foodRespawnChance = 0.2;

    public SimulationEngine(Environment environment) {
        this.environment = environment;
    }

    public void setFoodRespawnChance(double chance) { this.foodRespawnChance = chance; }

    public void tick() {
        tickCount++;
        for (Organism o : environment.getOrganisms()) {
            movement.move(o, environment);
            double cost = ENERGY_PER_TICK * Math.max(0.25, 0.5 + o.getGene().getSize() / 4.0);
            o.changeEnergy(-cost);

            environment.getFood().removeIf(f -> {
                boolean eaten = Math.hypot(f.getX() - o.getX(), f.getY() - o.getY()) < FEED_DISTANCE;
                if (eaten) o.changeEnergy(f.getValue() * o.getGene().getFoodEfficiency());
                return eaten;
            });
        }
        environment.getOrganisms().removeIf(o -> !o.isAlive());

        List<Organism> children = reproduction.reproduce(environment.getOrganisms());
        for (Organism c : children) {
            environment.addOrganism(c);
            generation = Math.max(generation, c.getGeneration());
        }

        if (Math.random() < foodRespawnChance) {
            environment.addFood(new Food(
                Math.random() * environment.getWidth(),
                Math.random() * environment.getHeight(),20));
        }
    }

    public Environment getEnvironment() { return environment; }
    public int getTickCount() { return tickCount; }
    public int getGeneration() { return generation; }
}