package com.mycompany.finalprojectveyerusjustin;

public class MovementController {

    public void move(Organism o, Environment env) {
        Food nearest = findNearestFood(o, env);
        if (nearest == null) return;

        double dx = nearest.getX() - o.getX();
        double dy = nearest.getY() - o.getY();
        double dist = Math.sqrt(dx * dx + dy * dy);
        if (dist < 1) return;

        double speed = o.getGene().getSpeed();
        double newX = o.getX() + (dx / dist) * speed;
        double newY = o.getY() + (dy / dist) * speed;
        o.setPosition(newX, newY);
    }

    private Food findNearestFood(Organism o, Environment env) {
        Food closest = null;
        double closestDist = Double.MAX_VALUE;
        for (Food f : env.getFood()) {
            double d = Math.hypot(f.getX() - o.getX(), f.getY() - o.getY());
            if (d < closestDist) {
                closestDist = d;
                closest = f;
            }
        }
        return closest;
    }
}