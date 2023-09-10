/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animation;

import jakarta.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 *
 * @author angelfigeralperezestevez
 */
public class BouncingBall extends Pane {

    public final double radius = 10; //nall size 40
    private double x = radius, y = radius; //coordinates of the ball 
    private double dx = 1, dy = 1;          // direction of the ball
    private Circle circle = new Circle(x, y, radius); // the ball

    private Timeline animation;     //animate the ball 

    public double recMoveRight = 0;//moves rectangle right
    public double recMoveLeft = 0;// moves rectangle left
    private double recX; // rec start x val
    private double recY; // rec start y val
    final private int RecHeight = 25; // rectangle height
    final private int RecWidth = 150; // rectangle width
    Rectangle rectangle = new Rectangle(recX, recY, RecWidth, RecHeight); // the rectangle

    public int score; //your score on the game
    public int computerScore; // just to get all my points on the MP, this its not nessary
    public final int lives = 3; // you only get 3 lives and its game over 
    public int level = 1; //your level on the game
    public int levelLogic = 50; public int moveLogic = 70; // logic on the game play 

    Label scoreLabel = new Label("Score: " + score);                          //all your labels 
    Label computerScoreLabel = new Label("Computer Score: " + computerScore); // |
    Label copyRightLabel = new Label("CopyRight@Angel Perez Estevez");        // |
    Label levelLabel = new Label("Level: " + level);                          // <
    
    Image life1 = new Image("images/lifes.png",40,40,false,true); //lifes icons
                                                                   //
       
        
        ImageView imv1 = new ImageView(life1);                     //
        ImageView imv2 = new ImageView(life1);                     //
        ImageView imv3 = new ImageView(life1);                     //
        
    
    public  int lifeCounter = 0;

    public BouncingBall() { // constructor // your pane
        setWidth(800);
        setHeight(600);
        
        BackgroundImage myBI= new BackgroundImage(new Image("images/backgroundImage.jpg",800,600,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        
        setBackground(new Background(myBI)); // the background 
        
        
        
        
        imv1.relocate(650, 150);
        imv2.relocate(700, 150);
        imv3.relocate(750, 150);
        
        getChildren().add(imv1);
        getChildren().add(imv2);
        getChildren().add(imv3);
        
        
        
        
        
        
        getChildren().add(scoreLabel);
        scoreLabel.setLayoutX(30.0);
        scoreLabel.setLayoutY(30.0);
        scoreLabel.setFont(Font.font("Impact",15));

        getChildren().add(levelLabel);
        levelLabel.setLayoutX(30.0);
        levelLabel.setLayoutY(60.0);
        levelLabel.setFont(Font.font("Impact",15));
        
        getChildren().add(computerScoreLabel);
        computerScoreLabel.setLayoutX(30.0);
        computerScoreLabel.setLayoutY(90.0);
        computerScoreLabel.setFont(Font.font("Impact",15));
        
        getChildren().add(copyRightLabel);
        copyRightLabel.setLayoutX(550.0);
        copyRightLabel.setLayoutY(30.0);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(6.0);
        dropShadow.setOffsetY(-4.0);
        circle.setFill(Color.CHARTREUSE);
        getChildren().add(circle);
        circle.setEffect(dropShadow);
        
        
        recX = (getWidth() - 150) / 2;// rectangle x cord
        recY = getHeight() - 25; // rectangle y cord

        rectangle.setX(recX);
        rectangle.setY(recY);
        rectangle.setFill(Color.BURLYWOOD);
        rectangle.setArcHeight(70);
        rectangle.setArcWidth(20);
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setOffsetX(6.0);
        dropShadow2.setOffsetY(-4.0);
        rectangle.setEffect(dropShadow2);
        getChildren().add(rectangle);

        animation = new Timeline(new KeyFrame(Duration.millis(50), (ActionEvent event) -> {
            moveBall();
            ballIntersect();
            gameOver();
        })
        );
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setRate(animation.getRate() * 15);
        animation.play();

    }   
    public void gameOver(){
        if(lifeCounter == 3){
            scoreLabel.setLayoutX(400.0);
            scoreLabel.setLayoutY(303.0);
            scoreLabel.setFont(Font.font("Impact",30));
            animation.pause();
            scoreLabel.setText("GAMEOVER:(\n " + " FINAL SCORE IS: " + score);
        }
    }

    private void moveBall() {
        if (x < radius || x > getWidth() - radius) {
            dx *= -1; // change the ball move direction

        }
        if (y < radius || y > getHeight() - radius) {
            dy *= -1; // change the ball move direction
        }
        
        if(y > getHeight() - radius){
            computerScoreLabel.setText("Computer Score: " + (computerScore += 20 )); // the computer gets 20 points every time it scores.
            lifeCounter += 1;
        }
        
        switch (lifeCounter) {  //removes hearts accordingly.
            case 1:
                imv1.setVisible(false);
                break;
            case 2:
                imv2.setVisible(false);
                break;
            case 3:
                imv3.setVisible(false);
                break;
            default:
                break;
        }
        
        
        
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    public void moveRectangleRight() { 
        if (recX >= getWidth() - 150) {
            recX = getWidth() - 150;

        }
        
        recMoveRight = moveLogic;
        rectangle.setX(recX += recMoveRight);
        
    }

    public void moveRectangleLeft() {
        if (recX <= 0) {
            recX = 0;
        }
        recMoveLeft = -moveLogic;
        
        rectangle.setX(recX += recMoveLeft);
       

    }



    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();

    }

    public DoubleProperty rateProperty() { // spped of your moving ball 
        return animation.rateProperty();
    }

    public void ballIntersect() {
        if (circle.intersects(rectangle.getBoundsInLocal())) {

            dx *= 1; // change the ball move direction

            dy *= -1; // change the ball move direction

            x += dx; // circle movement 
            y += dy - 25; //|
            circle.setCenterX(x);//|
            circle.setCenterY(y); // | 
            
            if(level % 2 == 0){// your movement speed logic 
                if(level <= 7)
                    animation.setRate(animation.getRate() + (moveLogic * 0.1)); //every 2 levels the speed of the ball increases  
                
                
                if(level >=6)
                    moveLogic = 150;
                else
                    moveLogic  = moveLogic + 5;                   // hence the paddle speed must also increase 
               
            }
            
            if(score >= levelLogic){ // level dificulty logic
             
             levelLogic = levelLogic + 10; // the amount of points needed to pass a level is incremented every level.
             levelLogic += 40; // level variance each level has a different points to pass
             levelLabel.setText("Level " + (level += 1));
            }
            
            
             scoreLabel.setText("Score: " + (score += 20));//your score
           
                      
           
           
            
            
        }

    }

}
