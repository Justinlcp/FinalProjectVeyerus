/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reeves.finalprojectveyerus;


import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

/**
 *
 * @author SEVEE
 */
public class MainController {
    
    @FXML private Label populationLabel;
    @FXML private Label generationLabel;
    @FXML private Label foodLabel;
    @FXML private Label avgSpeedLabel;    
    
    @FXML private Slider populationSlider;
    @FXML private Slider speedSlider;
    @FXML private Slider foodSlider ;
    
    
    
    @FXML private Pane arenaPane;
    
    
    @FXML private Button startButton;
    @FXML private Button pauseButton;
    @FXML private Button resetButton;
    
    private static final double ARENA_W = 600;
    private static final double ARENA_H = 400;

    private final SimulationView view = new SimulationView();
    private SimulationEngine engine;
    private AnimationTimer timer;
    
    @FXML 
    public void initialize() {
        resetButton.setOnAction(e -> onReset());
        startButton.setOnAction(e -> onStart());
        pauseButton.setOnAction(e -> onPause());

        timer = new AnimationTimer() {
            private long last = 0;
            
            @Override
            public void handle(long now) {
                double ticksPerSecond = Math.max(1, speedSlider.getValue() * 6);
                if (now - last >= 1_000_000_000L / ticksPerSecond) {
                    engine.tick();
                    refresh();
                    last = now;
                }
            }
        };
        onReset();
    }

    private void onReset() {   
        timer.stop();
        Environment env = new Environment(ARENA_W, ARENA_H);
        for (int i = 0; i < populationSlider.getValue(); i++) {
            Gene gene = new Gene(1 + Math.random() * 3, 0.5 + Math.random(), 1 + Math.random() * 3);
            env.addOrganism(new Organism(Math.random() * ARENA_W, Math.random() * ARENA_H, 50, gene));
        }
        
        for (int i = 0; i < foodSlider.getValue(); i++) {
            env.addFood(new Food(Math.random() * ARENA_W, Math.random() * ARENA_H, 10));
        }
        
        engine = new SimulationEngine(env);
        refresh();
    }

    private void onStart() {
        timer.start();
    }

    private void onPause() {
        timer.stop();
    }
    
    //helper
    private void refresh() {
        
        Environment env = engine.getEnvironment();
        view.render(arenaPane, env);
        
        populationLabel.setText("Population: " + env.getOrganisms().size());
        foodLabel.setText("Food: " + env.getFood().size());
        generationLabel.setText("Generation: " + engine.getGeneration());
        //just a logic place holder fr when justin makes the getGen method in simEng
        
        double total = 0;
        for (Organism o : env.getOrganisms()) {
            total += o.getGene().getSpeed();
        }
        int count = env.getOrganisms().size();
        avgSpeedLabel.setText(count ==0 ? "Avg speed: -" : String.format("Avg speed: %.2f",total/count));
    }
}
