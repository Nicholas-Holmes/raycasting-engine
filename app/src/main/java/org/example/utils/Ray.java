package org.example.utils;

public class Ray{
  private double posX;
  private double posY;
  private double startX;
  private double startY;
  private double heading;
  private int stepSize = 2;
  private double distance = 0;

  public Ray(double posX, double posY,double heading){
    this.posX = posX;
    this.posY = posY;
    this.startX = posX;
    this.startY = posY;
    this.heading = heading;
  }

  public double[] getData(){
    return new double[]{this.posX, this.posY, this.distance, this.heading};
  }

  public void step(){
    this.posX += Math.cos(heading) * stepSize;
    this.posY += Math.sin(heading) * stepSize;
    this.distance = (double)Math.hypot(this.posX - this.startX, this.posY - this.startY);
  }


}
