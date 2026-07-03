package org.example.DTO;

import org.example.enums.WallSide;

public class RayCollision{

  private double posX;
  private double posY;
  private double distance; 
  private double heading;
  private double wallHit;
  private WallSide side;

  /**
   * Creates an object holding data relevant to a ray collision with a wall. 
   *
   * @param posX The x-coordinate of the ray collision. 
   * @param posY The y-coordinate of the ray collision. 
   * @param distance The distance the ray went before the collision. 
   * @param heading The radian angle of the ray.
   * @param wallHit The value in the inclusive range of 0 to 1 representing where along a wall tile the collision occured. 
   * @param side An enum representing if the ray collided with a vertical or horizontal wall. 
   */
  public RayCollision(double posX, double posY, double distance, double heading, double wallHit, WallSide side){
    this.posX = posX;
    this.posY = posY; 
    this.distance = distance; 
    this.heading = heading;
    this.wallHit = wallHit;
    this.side = side;
  }


  /**
   * Returns the value of the x-coordinate. 
   *
   * @return The x-coordinate of the ray collision.
   */
  public double getPosX(){
    return this.posX;
  }

  /**
   * Returns the value of the y-coordinate. 
   * 
   * @return The y-coordinate of the ray collision.
   */
  public double getPosY(){
    return this.posY;
  }

  /**
   * Returns the perpendicular distance the ray travled before the collision. 
   *
   * @return The perpendicular distance from the player to the wall collision.
   */
  public double getDist(){
    return this.distance;
  }

  /**
   * Returns the radian angle of the ray. 
   *
   * @return The radian angle of the ray.
   */
  public double getHeading(){
    return this.heading;
  }

  /**
   * Returns how far along a wall tile the collision occurred. 
   *
   * @return The value in the inclusive range of 0 to 1 representing how far along a wall tile the collision occurred. 
   */
  public double getWallHit(){
    return this.wallHit;
  }

  /**
   * Returns the side of a wall the ray collided with. 
   *
   * @return An enum representing if the ray collided with a vertical or horizontal wall face.
   */
  public WallSide getSide(){
    return this.side;
  }

}
