package com.mycompany.finalprojectveyerusjustin;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SimulationEngineTest {

    @Test
    void organismWithAlmostNoEnergyDiesOnTick() {
        Environment env = new Environment(100, 100);
        env.addOrganism(new Organism(10, 10, 0.1, new Gene(1, 1, 1)));
        SimulationEngine engine = new SimulationEngine(env);
        engine.setFoodRespawnChance(0);
        engine.tick();
        assertEquals(0, env.getOrganisms().size());
    }

    @Test
    void organismEatsFoodAndGainsEnergy() {
        Environment env = new Environment(100, 100);
        Organism o = new Organism(10, 10, 50, new Gene(1, 1, 1));
        env.addOrganism(o);
        env.addFood(new Food(10, 10, 10));
        SimulationEngine engine = new SimulationEngine(env);
        engine.setFoodRespawnChance(0);
        engine.tick();
        assertEquals(0, env.getFood().size());
        assertTrue(o.getEnergy() > 50);
    }
}