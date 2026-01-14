package org.example.utils;

public class Ray{
  //private static final double EPSILON = 2e-3;
  private static final double EPSILON = 0.2;
  private double posX;
  private double posY;
  private double prevX;
  private double prevY;
  private double startX;
  private double startY;
  private double heading;
  private double stepSize = 0.1;
  private double distance = 0;

  public Ray(double posX, double posY,double heading){
    this.posX = posX;
    this.posY = posY;
    this.startX = posX;
    this.startY = posY;
    this.heading = heading;
    this. prevX = 0;
    this.prevY = 0;
  }

  /**
   * Gets the data associated with a ray neccessary for rendering.
   * @return double array containing the Ray's x position, y position, distance, and ray angle.
   */
  public double[] getData(){
    this.distance = (double)Math.hypot(this.posX - this.startX, this.posY - this.startY);
    return new double[]{this.posX, this.posY, this.distance, this.heading};
  }

  /**
   * Determines if the ray collided with a vertical or horizontal wall.
  * @param hitX x coordinates of the ray's collision.
  * @param hitY y coordinates of the ray's collision.
  * @return vertical or horizontal WallFace enum.
  */
  public double getCollisionFace(double hitX, double hitY){
    double rayXDir = Math.cos(this.heading);
    double rayYDir = Math.sin(this.heading);
    double nextVertical = rayXDir > 0 ? Math.floor(prevX / 64) * 64 +64
                                      : Math.floor(prevX / 64) * 64;
    double nextHorizontal = rayYDir > 0 ? Math.floor(prevY / 64) * 64 + 64
                                        : Math.floor(prevY / 64) * 64;
    double distToVertical = Double.POSITIVE_INFINITY;
    double distToHorizontal = Double.POSITIVE_INFINITY;

    if (Math.abs(rayXDir) > 1e-8) {
      distToVertical = (nextVertical - prevX) / rayXDir;
      if (distToVertical < 0) distToVertical = Double.POSITIVE_INFINITY;
    }

    if (Math.abs(rayYDir) > 1e-8){
      distToHorizontal = (nextHorizontal - prevY) / rayYDir;
      if (distToHorizontal < 0) distToHorizontal = Double.POSITIVE_INFINITY;
    }
    return distToVertical < distToHorizontal ? 1:0;

  }

  public void step(){
    this.prevX = this.posX;
    this.prevY = this.posY;
    this.posX += Math.cos(heading) * stepSize;
    this.posY += Math.sin(heading) * stepSize;
    
  }

}
