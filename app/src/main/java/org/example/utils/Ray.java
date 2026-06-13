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
  private double posTileX;
  private double posTileY;
  private double rayDirX;
  private double rayDirY;
  

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
   * @return double array containing the Ray's x position, y position, distance, ray angle, and texture X index.
   */
  public double[] getData(double playerHeading){
    this.distance = this.side == WallSide.VERTICAL ? (sideDistX - deltaDistX):(sideDistY - deltaDistY);
    //Exact point in world cordinates a ray hits a surface.
    double collisionX = this.posTileX + this.rayDirX * this.distance;
    double collisionY = this.posTileY + this.rayDirY * this.distance;
    double wallHit = this.side == WallSide.VERTICAL ? collisionY:collisionX;
    wallHit = wallHit - Math.floor(wallHit);
    
    //int texX = (int)(wallHit * 32.0);
    //if (texX < 0) texX = 0;
    //if (texX >= 32) texX = 31;
    //System.out.println(texX);
    if (this.side == WallSide.VERTICAL && this.rayDirX < 0){
      wallHit = 1.0 - wallHit;
    }
    if (this.side == WallSide.HORIZONTAL && this.rayDirY > 0){
      wallHit = 1.0 - wallHit;
    }

    if (wallHit < 0.0) wallHit = 0.0;
    if (wallHit >= 1.0) wallHit = 0.9999;
    
    return new double[]{this.posX, this.posY, this.distance, this.heading, wallHit};
  }

  public int[] getArrayPos(){
    return this.arrayPos;
  }

  public WallSide getCollisionSide(){
    return this.side;
  }

  private void initializeRay(){
    this.rayDirX = Math.cos(this.heading);
    this.rayDirY = Math.sin(this.heading);
    this.posTileX = this.posX/64.0;
    this.posTileY = this.posY/64.0;
    this.arrayPos = new int[]{(int)Math.floor(this.posTileY),(int)Math.floor(this.posTileX)};
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
