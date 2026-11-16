package com.mycompany.finalprojectveyerusjustin;

import java.util.ArrayList;
import java.util.List;

public class ReproductionManager {
    private static final double REPRODUCE_THRESHOLD = 80;
    private static final double MUTATION_RATE = 0.5;

    public List<Organism> reproduce(List<Organism> organisms) {
        List<Organism> children = new ArrayList<>();
        for (int i = 0; i < organisms.size(); i++) {
            Organism a = organisms.get(i);
            if (a.getEnergy() < REPRODUCE_THRESHOLD) continue;

            Organism b = organisms.get((i + 1) % organisms.size());
            Gene childGene = Gene.crossover(a.getGene(), b.getGene()).mutate(MUTATION_RATE);

            a.changeEnergy(-REPRODUCE_THRESHOLD / 2);
            Organism child = new Organism(a.getX(), a.getY(), REPRODUCE_THRESHOLD / 2, childGene);
            child.setGeneration(Math.max(a.getGeneration(), b.getGeneration()) + 1);
            children.add(child);
        }
        return children;
    }
}