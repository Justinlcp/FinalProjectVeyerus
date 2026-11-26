package com.mycompany.finalprojectveyerusjustin;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GeneTest {

    @Test
    void crossoverTakesEachTraitFromAParent() {
        Gene a = new Gene(1, 1, 1);
        Gene b = new Gene(5, 5, 5);
        Gene child = Gene.crossover(a, b);
        assertTrue(child.getSpeed() == 1 || child.getSpeed() == 5);
        assertTrue(child.getFoodEfficiency() == 1 || child.getFoodEfficiency() == 5);
        assertTrue(child.getSize() == 1 || child.getSize() == 5);
    }

    @Test
    void mutateStaysWithinRate() {
        Gene g = new Gene(3, 3, 3);
        Gene mutated = g.mutate(0.5);
        assertEquals(3, mutated.getSpeed(), 0.25);
        assertEquals(3, mutated.getFoodEfficiency(), 0.25);
        assertEquals(3, mutated.getSize(), 0.25);
    }
}