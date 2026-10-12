package org.example.DTO;

public class ScreenColumnData{

  private int side;
  private double wallTop;
  private double wallHeight;
  private double wallHit;
  private double step;
  private int rawTop;
  private int drawStart;
  private int drawEnd;

  /**
   * Creates a ScreenColumnData object to hold data needed for drawing each screen column. 
   *
   * @param side An int value representing if the ray collided with a vertical or horizontal wall face. 
   * @param wallTop The screen y-coordinate representing the top of the wall to be drawn to the screen. 
   * @param wallHeight A value representing how tall the wall to be drawn is in screen pixels. 
   * @param wallHit A value in the inclusive range of 0 to 1 representing how far along a wall tile a ray collided. 
   * @param step A value representing the texture array traversal step size.
   * @param rawTop A value representing the top of a wall slice. 
   * @param drawStart A value representing the starting x coordinate of a wall slice. 
   * @param drawEnd A value representing the ending x coordinate of a wall slice. 
   */
  public ScreenColumnData(int side, double wallTop, double wallHeight, double wallHit, double step, int rawTop, int drawStart, int drawEnd){
    this.side = side;
    this.wallTop = wallTop;
    this.wallHeight = wallHeight;
    this.wallHit = wallHit;
    this.step = step;
    this.rawTop = rawTop;
    this.drawStart = drawStart;
    this.drawEnd = drawEnd; 
  }

  /**
   * Returns an int representing if a ray collided with a vertical or horizontal wall face.
   *
   * @return 0 if the ray collided with a horizontal wall face and 1 for a vertical wall face. 
   */
  public int getSide(){
    return this.side;
  }

  /**
   * Returns the y-coordinate representing the top of a wall. 
   *
   * @return The y-coordinate of the top of a wall to be rendered.
   */
  public double getWallTop(){
    return this.wallTop;
  }

  /**
   * Returns the value representing the height of a wall to be rendered. 
   *
   * @return A value representing the height of a wall to be rendered. 
   */
  public double getWallHeight(){
    return this.wallHeight;
  }

  /**
   * Returns a value in the inclusive reange of 0 to 1 representing how far along a wall tile a ray collision occurred. 
   *
   * @return A value representing how far along a wall tile a ray collision occurred. 
   */
  public double getWallHit(){
    return this.wallHit;
  }

  /**
   * Returns the value of the texture traversal step size. 
   *
   * @return A value representing the texture array traversal step size.
   */
  public double getStep(){
    return this.step;
  }

  /**
   * Returns a value representing the top of a wall within a screen slice.
   *
   * @return A value representing the top of a wall within a screen slice. 
   */
  public int getRawTop(){
    return this.rawTop;
  }
  
  /**
   * Returns a value representing the starting x coordinate to begin drawing a wall slice.
   *
   * @return A value represent the starting x coordinate to begin drawing a wall slice. 
   */
  public int getDrawStart(){
    return this.drawStart;
  }

  /**
   * Returns a value representing the end x coordinate of a wall slice.
   *
   * @return A value representing the end x coodinate of a wall slice.
   */
  public int getDrawEnd(){
    return this.drawEnd;
  }
}

