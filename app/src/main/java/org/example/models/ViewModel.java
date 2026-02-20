package org.example.models;

import org.example.entities.Player;
public class ViewModel{
  private double screenCenterX;
  private double screenCenterY;
  private int[][] map = {{1,1,1,1,1,1,1,1},
                 {1,0,0,0,0,0,0,1},
                 {1,0,0,0,0,0,0,1},
                 {1,0,0,1,0,0,0,1},
                 {1,0,0,0,0,0,0,1},
                 {1,0,0,0,0,0,0,1},
                 {1,0,0,0,0,0,0,1},
                 {1,1,1,1,1,1,1,1}
                };
  private Player player;

  public ViewModel(Player player){
    this.player = player;

  }

  public int[][] getMap(){
    return this.map;
  }

  public Player getPlayer(){
    return this.player;
  }

  public double[] getScreenCenter(){
    return new double[]{this.screenCenterX,this.screenCenterY};
  }

  public void setScreenCenter(double x, double y){
    this.screenCenterX = x;
    this.screenCenterY = y;
  }


}
