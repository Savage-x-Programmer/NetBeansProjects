/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author angelfigeralperezestevez
 */
public class BouncingBall extends Pane {

    public final double radius = 20; //nall size 40
    private double x = radius, y = radius; //coordinates of the ball 
    private double dx = 1, dy = 1;          // direction of the ball
    private Circle circle = new Circle(x, y, radius); // the ball
    private Timeline animation;     //animate the ball

    public BouncingBall() {
        circle.setFill(Color.BROWN);
        getChildren().add(circle);

        animation = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moveBall();

            }
        })
        );
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setRate(animation.getRate() * 50);
        animation.play();
    
        
    
    }

    private void moveBall() {
        if (x < radius || x > getWidth() - radius) {
              dx *= -1; // change the ball move direction
          
        }
        if( y < radius || y > getHeight() - radius){
            dy *= -1; // change the ball move direction
        }
        
        x+= dx;
        y+= dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
    public void play(){
            animation.play();
        }
    
    public void pause(){
        animation.pause();
        
    }
    public void increaseSpeed(){
        animation.setRate(animation.getRate() * 1.5);
        
    }
    public void descreaseSpeed(){
        animation.setRate(animation.getRate() * 1.5 > 0 ? animation.getRate() / 1.5 :0);
    }
    
    public DoubleProperty rateProperty(){
        return animation.rateProperty();
    }
    
   
}
