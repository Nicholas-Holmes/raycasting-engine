package org.example.entities;

public class Player{
  private static final double ANGLE_STEP = Math.toRadians(5);
  private double posX;
  private double posY;
  private double heading;

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
      

  public void move(double dx, double dy){
    this.posX += dx;
    this.posY += dy;
  }

  public void rotate(String direction){
    if (direction.equals("left")){
      this.heading -= ANGLE_STEP;
    } else {
      this.heading += ANGLE_STEP;
    }

  }


}
