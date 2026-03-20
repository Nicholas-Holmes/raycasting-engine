package org.example.entities;

import org.example.enums.Direction;

public class Player{
  private static final double ANGLE_STEP = Math.toRadians(1);
  private double posX;
  private double posY;
  private double heading;
  private double step = 2.0;

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

  public void rotate(double dx){
    this.heading += ANGLE_STEP * dx;
  }
      

  public void move(double dx, double dy){
    this.posX += dx * this.step;
    this.posY += dy * this.step;
  }



}
