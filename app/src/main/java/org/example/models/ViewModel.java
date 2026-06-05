package org.example.models;

import org.example.entities.Player;

public class ViewModel{
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


}
