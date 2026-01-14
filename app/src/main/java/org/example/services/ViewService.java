package org.example.services;
import org.example.utils.Ray;

public class ViewService{
  
  public static double[] castRay(Ray ray, int[][] map){
    boolean collided = false;
    double[] pos = new double[4];
    while(!collided){
      ray.step();
      pos = ray.getData();
      int cell = map[((int)pos[0])/64][((int)pos[1])/64];
      if (cell == 1){
        collided = !collided;
      }
    }
    return new double[]{ray.getCollisionFace(pos[0], pos[1]),pos[0],pos[1],pos[2],pos[3]};
  }

}
