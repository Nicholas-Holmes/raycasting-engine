package org.example.models;

import org.example.entities.Player;

import javafx.geometry.Point2D;
public class ViewModel{
  private Point2D center;
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

  public Point2D getScreenCenter(){
    return this.center;
  }

  public void setScreenCenter(Point2D center){
    this.center = center; 
  }


}
