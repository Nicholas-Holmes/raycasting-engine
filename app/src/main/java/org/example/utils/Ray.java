package org.example.utils;
import org.example.enums.WallSide;

public class Ray{
  private double posX;
  private double posY;
  private double startX;
  private double startY;
  private double heading;
  private double distance = 0;
  private int[] arrayPos; //stores the row and column(in that order) the ray position maps to
  private WallSide side = null;
  private double deltaDistX;
  private double deltaDistY;
  private int stepX;
  private int stepY;
  private double sideDistX;
  private double sideDistY;
  

  public Ray(double posX, double posY,double heading){
    this.posX = posX;
    this.posY = posY;
    this.startX = posX;
    this.startY = posY;
    this.heading = heading;
    initializeRay();
  }

  /**
   * Gets the data associated with a ray neccessary for rendering.
   * @return double array containing the Ray's x position, y position, distance, and ray angle.
   */
  public double[] getData(){
    this.distance = this.side == WallSide.VERTICAL ? (sideDistX - deltaDistX):(sideDistY - deltaDistY);
    return new double[]{this.posX, this.posY, this.distance, this.heading};
  }

  public int[] getArrayPos(){
    return this.arrayPos;
  }

  public WallSide getCollisionSide(){
    return this.side;
  }

  private void initializeRay(){
    double rayDirX = Math.cos(this.heading);
    double rayDirY = Math.sin(this.heading);
    double posTileX = this.posX/64;
    double posTileY = this.posY/64;
    this.arrayPos = new int[]{(int)(this.posY/64),(int)(this.posX/64)};
    this.deltaDistX = Math.abs(1/rayDirX);
    this.deltaDistY = Math.abs(1/rayDirY);
    if (rayDirX < 0){
      this.stepX = -1;
      this.sideDistX = (posTileX - this.arrayPos[1]) * this.deltaDistX;
    } else {
      this.stepX = 1;
      this.sideDistX = ((this.arrayPos[1] + 1) - posTileX) * this.deltaDistX;
    }

    if (rayDirY < 0){
      this.stepY = -1;
      this.sideDistY = (posTileY - this.arrayPos[0]) * this.deltaDistY;
    } else {
      this.stepY = 1;
      this.sideDistY = ((this.arrayPos[0] + 1) - posTileY) * this.deltaDistY;

    }


  }

  public void step(){
    if (sideDistX < sideDistY){
      sideDistX += deltaDistX;
      this.arrayPos[1] += stepX;
      this.side = WallSide.VERTICAL;
    } else {
      sideDistY += deltaDistY;
      this.arrayPos[0] += stepY;
      this.side = WallSide.HORIZONTAL;
    }
  }

}
