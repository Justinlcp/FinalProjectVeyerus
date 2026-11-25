/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reeves.finalprojectveyerus;

import java.util.function.Consumer;
import javafx.scene.control.Slider;

/**
 *
 * @author SEVEE
 */
public class ControlPanelView {
    private final Slider foodSlider;
    private final Slider populationSlider;
    private final Slider speedSlider;


    public ControlPanelView(Slider foodSlider, Slider populationSlider, Slider speedSlider) {
        this.foodSlider = foodSlider;
        this.populationSlider = populationSlider;
        this.speedSlider = speedSlider;

    }
    public double getSpeed() {
        return speedSlider.getValue();
    }
    public int getFoodCount() { 
        return(int) foodSlider.getValue(); 
    }
    public int getPopulationCount() {
        return (int) populationSlider.getValue();
    }
    public double getFoodRespawnChance() { 
        return foodSlider.getValue()/100.0; 
    }
    
    public void onFoodChanged(Consumer<Double> listener) {
        foodSlider.valueProperty().addListener((obs, oldVal, newVal) ->
            listener.accept(newVal.doubleValue() / 100.0));
    }
}
