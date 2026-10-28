/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reeves.finalprojectveyerus;

import java.lang.classfile.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

/**
 *
 * @author SEVEE
 */
public class MainController {
    
    @FXML private Label populationLabel;
    @FXML private Label generationLabel;
    @FXML private Label foodLabel;
    
    @FXML private Slider populationSlider;
    @FXML private Slider speedSlider;
    @FXML private Slider foodSlider ;
    
    
    @FXML private Pane arenaPane;
    
    
    @FXML private Button startButton;
    @FXML private Button pauseButton;
    @FXML private Button resetButton;
    
    @FXML 
    public void initialize(){
        resetButton.setOnAction(e -> onReset());
        startButton.setOnAction(e -> onStart());
        pauseButton.setOnAction(e -> onPause());
    }

    private void onReset() {
        System.out.println("Reset clicked!");
    }

    private void onStart() {
        System.out.println("Reset clicked!");
    }

    private void onPause() {
        System.out.println("Reset clicked!");
    }
}
