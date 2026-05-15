package org.example.services;
import org.example.utils.Ray;
import org.example.enums.WallSide;

public class ViewService{
  
  public static double[] castRay(Ray ray, int[][] map){
    boolean collided = false;
    WallSide collisionSide = null;
    while(!collided){
      ray.step();
      int[] indexPos = ray.getArrayPos();
      int cell = map[indexPos[0]][indexPos[1]];
      if (cell == 1){
        collided = !collided;
        collisionSide = ray.getCollisionSide();
      }
    }
    double[] pos = ray.getData();
    int side = collisionSide == WallSide.HORIZONTAL ? 0:1;
    return new double[]{side,pos[0],pos[1],pos[2],pos[3], pos[4]};
  }

}
