package org.example.services;
import org.example.utils.Ray;

public class ViewService{
  
  public static double[] castRay(Ray ray, int[][] map){
    boolean collided = false;
    while(!collided){
      ray.step();
      double[] pos = ray.getData();
      int cell = map[((int)pos[0])/64][((int)pos[1])/64];
      if (cell == 1){
        collided = !collided;
      }
    }
    return ray.getData();
  }

}
