/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animation;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;




/**
 *
 * @author angelfigeralperezestevez
 */
public class BallControl extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BouncingBall bouncingBall = new BouncingBall();
        
        Scene scene = new Scene(bouncingBall, 800, 600);
        primaryStage.setTitle("ZeroGravityTenis_Beta");
        primaryStage.setScene(scene);
        primaryStage.show();
        bouncingBall.requestFocus();
        
        
        
        
        bouncingBall.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                bouncingBall.pause();
            }
             
        });
        bouncingBall.setOnMouseReleased(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
            bouncingBall.play();            }
        
        });
        bouncingBall.ballIntersect();
        
        
        bouncingBall.setOnKeyPressed(e ->
        {
            
            if (e.getCode() == KeyCode.RIGHT)
            {
                bouncingBall.moveRectangleRight();
            }
            else if (e.getCode() == KeyCode.LEFT)
            {
                bouncingBall.moveRectangleLeft();
            }
        });

    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
