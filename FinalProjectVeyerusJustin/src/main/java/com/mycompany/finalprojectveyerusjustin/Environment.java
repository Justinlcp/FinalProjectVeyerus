package com.mycompany.finalprojectveyerusjustin;

import java.util.ArrayList;
import java.util.List;

public class Environment {
    private final double width;
    private final double height;
    private final List<Organism> organisms = new ArrayList<>();
    private final List<Food> food = new ArrayList<>();

    public Environment(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void addOrganism(Organism o) { organisms.add(o); }
    public void addFood(Food f) { food.add(f); }

    public List<Organism> getOrganisms() { return organisms; }
    public List<Food> getFood() { return food; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}