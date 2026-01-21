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
    this.arrayPos = new int[]{(int)Math.floor(posY/64), (int)Math.floor(posX/64)};
  }

  /**
   * Gets the data associated with a ray neccessary for rendering.
   * @return double array containing the Ray's x position, y position, distance, and ray angle.
   */
  public double[] getData(){
    this.distance = (double)Math.hypot(this.posX - this.startX, this.posY - this.startY);
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
    this.arrayPos = new int[]{(int)(this.posY/64),(int)(this.posX/64)};
    this.deltaDistX = Math.abs(64/rayDirX);
    this.deltaDistY = Math.abs(64/rayDirY);
    if (rayDirX < 0){
      this.stepX = -1;
      this.sideDistX = (posX - this.arrayPos[1] * 64) * this.deltaDistX;
    } else {
      this.stepX = 1;
      this.sideDistX = ((this.arrayPos[1] + 1) * 64 - this.posX) * this.deltaDistX;
    }

    if (rayDirY < 0){
      this.stepY = -1;
      this.sideDistY = (this.posY - this.arrayPos[0] * 64) * this.deltaDistY;
    } else {
      this.setpY = 1;
      this.sideDistY = ((this.arrayPos[0] + 1) * 64 - this.posY) * this.deltaDistY;

    }


  }

  public void step(){
    double rayDirX = Math.cos(this.heading);
    double rayDirY = Math.sin(this.heading);
    int arrayDirX = rayDirX > 0 ? 1:-1;
    int arrayDirY = rayDirY > 0 ? 1:-1;
    double nextHorizontal = arrayDirY == 1 ? Math.floor(this.posY / 64) * 64 + 64
                                           : Math.floor(this.posY / 64) * 64 - 0.01;
    double nextVertical = arrayDirX == 1 ? Math.floor(this.posX / 64) * 64 + 64
                                         : Math.floor(this.posX / 64) * 64 - 0.01;
    double distToVertical = Double.POSITIVE_INFINITY;
    double distToHorizontal = Double.POSITIVE_INFINITY;

    if (rayDirX != 0){
      distToVertical = (nextVertical - this.posX) /rayDirX; 
      if (distToVertical < 0){
        distToVertical = Double.POSITIVE_INFINITY;
      }
    }

    if (rayDirY != 0){
      distToHorizontal = (nextHorizontal - this.posY) / rayDirY;
      if (distToHorizontal < 0) {
        distToHorizontal = Double.POSITIVE_INFINITY;
      }
    }

    this.side = distToHorizontal > distToVertical ? WallSide.VERTICAL:WallSide.HORIZONTAL;
    double step = distToHorizontal > distToVertical ? distToVertical:distToHorizontal;
    if (side == WallSide.HORIZONTAL){
      this.arrayPos[0] += arrayDirY;
    } else {
      this.arrayPos[1] += arrayDirX;
    }
    this.posX += rayDirX * step;
    this.posY += rayDirY * step;
  }

}
