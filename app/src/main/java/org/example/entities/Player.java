package org.example.entities;

public class Player{
  private double posX;
  private double posY;
  private double heading;

  public Player(int posX, int posY){
    this.posX = posX * 64;
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

  public void move(double dx, double dy){
    this.posX += dx;
    this.posY += dy;
  }


}
