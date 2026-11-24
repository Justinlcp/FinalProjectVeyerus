package com.reeves.finalprojectveyerus;

import java.util.List;

public class SimulationEngine {
    private final Environment environment;
    private final MovementController movement = new MovementController();
    private int tickCount = 0;
    private final ReproductionManager reproduction = new ReproductionManager();
    private int generation = 0;

    private static final double FEED_DISTANCE = 10;
    private static final double ENERGY_PER_TICK = 1;

    public SimulationEngine(Environment environment) {
        this.environment = environment;
    }

    public void tick() {
        tickCount++;
        for (Organism o : environment.getOrganisms()) {
            movement.move(o, environment);
            o.changeEnergy(-ENERGY_PER_TICK);

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
    }

    public Environment getEnvironment() { return environment; }
    public int getTickCount() { return tickCount; }
}