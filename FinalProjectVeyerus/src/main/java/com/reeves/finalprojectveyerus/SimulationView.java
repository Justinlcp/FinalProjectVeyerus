/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reeves.finalprojectveyerus;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 *
 * @author SEVEE
 */
public class SimulationView {
    
    public void render(Pane arenaPane, Environment env){
        arenaPane.getChildren().clear();
        
        for (Food f : env.getFood()) {
            Circle dot = new Circle(f.getX(), f.getY(), 3, Color.ORANGE);
            arenaPane.getChildren().add(dot);
        }
        for (Organism o : env.getOrganisms()) {
            Circle dot = new Circle(o.getX(), o.getY(), 6, Color.AZURE);
            arenaPane.getChildren().add(dot);
        }
    }
    
}
