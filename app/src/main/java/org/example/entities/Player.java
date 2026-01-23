package org.example.entities;

import org.example.enums.Direction;

public class Player{
  private static final double ANGLE_STEP = Math.toRadians(5);
  private double posX;
  private double posY;
  private double heading;
  private double step = 5.0;

  public Player(int posX, int posY){
    this.posX = posX * 64;// + 32;
    this.posY = posY * 64;
    this.heading = ((3 * Math.PI)/2);// + Math.toRadians(5);
  }

  public double getPosX(){
    return this.posX;
  }

  public double getPosY(){
    return this.posY;
  }

  public double getHeading(){
    return this.heading;
  }

  public void positionCheck(){
    if (this.posX % 64 == 0) this.posX += Math.cos(this.heading) * 0.01;
    if (this.posY % 64 == 0) this.posY += Math.sin(this.heading) * 0.01;

  }
      

  public void move(Direction direction){
    double headingDirX = Math.cos(this.heading);
    double headingDirY = Math.sin(this.heading);
    switch(direction){
      case Direction.FORWARD:
        this.posX += headingDirX * this.step;
        this.posY += headingDirY * this.step;
      break;

      case Direction.BACKWARD:
        this.posX -= headingDirX * this.step;
        this.posY -= headingDirY * this.step;
      break;

      case Direction.LEFT:
        this.heading -= ANGLE_STEP;
      break;

      case Direction.RIGHT:
        this.heading += ANGLE_STEP;
      break;
    }
  }



}
