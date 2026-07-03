package org.example.controllers;
import org.example.models.ViewModel;
import org.example.utils.Ray;

import javafx.stage.Screen;

import org.example.services.ViewService;

import java.util.ArrayList;
import java.util.List;

import org.example.DTO.ScreenColumnData;
import org.example.entities.Player;
import org.example.enums.Direction;
import org.example.enums.Color;

public class ViewController{

  private ViewModel vModel;
  private Player player;
  private double angleStep = (Math.PI/3.0)/640;
  private List<Direction> movementBuffer = new ArrayList<>(); 
  private int texColor;

  public ViewController(ViewModel vModel){
    this.vModel = vModel;
    this.player = vModel.getPlayer();
  }

  public void appendMovement(Direction direction){
    if (movementBuffer.contains(direction)){
      return;
    }
    movementBuffer.add(direction);
  }

  public void removeMovement(Direction direction){
    movementBuffer.remove(direction);
  }

  public void move(){
    //Grabbing the player heading and getting the x and y component.
    double heading = this.player.getHeading();
    double dirX = Math.cos(heading);
    double dirY = Math.sin(heading);
    double dx = 0; 
    double dy = 0; 
    //Accumulating movement into dx and dy to handle multiple directional input at once. 
    if (movementBuffer.contains(Direction.FORWARD)){
      dx += dirX;
      dy += dirY;
    }
    if (movementBuffer.contains(Direction.BACKWARD)){
      dx -= dirX;
      dy -= dirY;
    }
    if (movementBuffer.contains(Direction.LEFT)){
      //Accumulating the left perpendicular vector.
      dx += dirY;
      dy -= dirX;
    }
    if (movementBuffer.contains(Direction.RIGHT)){
      //Accumulating the right perpendicular vector. 
      dx -= dirY;
      dy += dirX;
    }
    //Calculating the magnitude of the movement vector and checking that it is greater than zero so we don't divide by zero for normalization. 
    double magnitude = Math.sqrt(dx * dx + dy * dy);
    if (magnitude <= 0){
      return;
    }
    //Normalizing the vector. 
    dx /= magnitude;
    dy /= magnitude; 
    player.move(dx,dy);
  }

  public void rotate( double dx){
    player.rotate(dx);
  }


  public double[] calculateColumn(int i){
    double rayAngle = player.getHeading() - ((Math.PI/3) / 2) + i * angleStep; 
    ScreenColumnData collision = ViewService.castRay(new Ray(player.getPosX(), player.getPosY(), rayAngle), vModel.getMap(), player.getHeading(), i, angleStep);
    double columnWidth = (double)640 / 60;//Calculating the width of each screen slice
    double x = i * columnWidth;//Calculating the starting x coordinate of the slice corresponding to this ray
    //Calculating the world collision cordinates of the ray.
    //collision[0]:side, collision[5]:wallHit;
    return new double[]{collision.getSide(),x,collision.getWallTop(),columnWidth,collision.getWallHeight(), collision.getWallHit()};
  }


}
