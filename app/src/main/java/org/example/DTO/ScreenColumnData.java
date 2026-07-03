package org.example.DTO;

public class ScreenColumnData{

  private int side;
  private double wallTop;
  private double wallHeight;
  private double wallHit;

  public ScreenColumnData(int side, double wallTop, double wallHeight, double wallHit){
    this.side = side;
    this.wallTop = wallTop;
    this.wallHeight = wallHeight;
    this.wallHit = wallHit;
  }

  public int getSide(){
    return this.side;
  }

  public double getWallTop(){
    return this.wallTop;
  }

  public double getWallHeight(){
    return this.wallHeight;
  }

  public double getWallHit(){
    return this.wallHit;
  }

  
}
