package org.example.controllers;
import org.example.models.ViewModel;
import org.example.utils.Ray;
import org.example.services.ViewService;

import java.util.ArrayList;
import java.util.List;

import org.example.entities.Player;
import org.example.enums.Direction;
import org.example.enums.Color;

public class ViewController{

  private ViewModel vModel;
  private Player player;
  private double angleStep = (Math.PI/3)/60;
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

  public int parseTexture(String s){
    switch(s){
      case "0":
        texColor = Color.C0.getValue();
       break;
      case "1":
        texColor = Color.C1.getValue();
      break;
    }
    return texColor;
  }

  public double[] calculateColumn(int i){
    double projPlaneDist = (640 / 2.0) / Math.tan((Math.PI/3)/2.0);
    double rayAngle = player.getHeading() - ((Math.PI/3) / 2) + i * angleStep; 
    double[] collision = ViewService.castRay(new Ray(player.getPosX(), player.getPosY(), rayAngle), vModel.getMap());
    //double correctedDistance = collision[3] * Math.cos(collision[4] - vModel.getPlayer().getHeading());//Fixing fisheye effect by adjusting distance
    double wallHeight = (projPlaneDist) / (collision[3] * Math.cos(collision[4] - player.getHeading()));//Wall height = tileSize * screenHeight divided by the corrected distance
    double wallTop = (480 - wallHeight) / 2;//Wall top = screenHeight - wallHeight divided by 2. (centers the wall in the view)
    double columnWidth = (double)640 / 60;//Calculating the width of each screen slice
    double x = i * columnWidth;//Calculating the starting x coordinate of the slice corresponding to this ray
    //Calculating the world collision cordinates of the ray.
    return new double[]{collision[0],x,wallTop,columnWidth,wallHeight, collision[5]};

  }


}
