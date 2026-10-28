package com.mycompany.finalprojectveyerusjustin;

public class Organism {
    private double x;
    private double y;
    private double energy;
    private Gene gene;

    public Organism(double x, double y, double energy, Gene gene) {
        this.x = x;
        this.y = y;
        this.energy = energy;
        this.gene = gene;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getEnergy() { return energy; }
    public Gene getGene() { return gene; }

    public boolean isAlive() {
        return energy > 0;
    }
    
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void changeEnergy(double amount) {
        this.energy += amount;
    }
}