package org.example.services;
import org.example.utils.Ray;
import org.example.DTO.RayCollision;
import org.example.DTO.ScreenColumnData;
import org.example.enums.WallSide;

public class ViewService{
  
  public static ScreenColumnData castRay(Ray ray, int[][] map, double playerHeading, int i, double angleStep){
    boolean collided = false;
    while(!collided){
      ray.step();
      int[] indexPos = ray.getArrayPos();
      int cell = map[indexPos[0]][indexPos[1]];
      if (cell == 1){
        collided = !collided;
        //collisionSide = ray.getCollisionSide();
      }
    }
    RayCollision pos = ray.getData();
    int side = pos.getSide() == WallSide.HORIZONTAL ? 0:1;

    double projPlaneDist = (640/2.0)/Math.tan((Math.PI/3)/2.0);
    double relativeAngle = -((Math.PI/3)/2) + i * angleStep;
    double correctedDistance = pos.getDist() * Math.cos(relativeAngle);
    double wallHeight = projPlaneDist / correctedDistance;
    double wallTop = (480 - wallHeight) / 2;

    ScreenColumnData columnData = new ScreenColumnData(side, wallTop, wallHeight, pos.getWallHit());

    return columnData;
    //0:side,1:posX, 2:posY, 3:dist, 4:heading, 5:wallHit
    //return new double[]{side,pos.getPosX(),pos.getPosY(),pos.getDist(),pos.getHeading(), pos.getWallHit()};
  }

  public static int applyShading(int color){
    //Preserve alpha value;
    int a = color & 0xFF000000;
    //Extract and shift down by 1 to divide by 2 and.
    int r = ((color & 0x00FF0000 >> 1) & 0x00FF0000);
    int g = ((color & 0x0000FF00 >> 1) & 0x0000FF00);
    int b = (color & 0x000000FF >> 1) & 0x000000FF;
    //Pack them back into a single integer. 
    return a | r | g | b;

  }

}
