package com.mycompany.finalprojectveyerusjustin;

public class SimulationEngine {
    private final Environment environment;
    private int tickCount = 0;

    public SimulationEngine(Environment environment) {
        this.environment = environment;
    }

    public void tick() {
        tickCount++;
        // movement, feeding, reproduction and death will be added here
        System.out.println("Tick " + tickCount + " - organisms: " + environment.getOrganisms().size());
    }

    public int getTickCount() { return tickCount; }
}