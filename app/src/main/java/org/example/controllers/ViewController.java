package org.example.controllers;
import org.example.models.ViewModel;
import org.example.utils.Ray;
import org.example.services.ViewService;
import org.example.entities.Player;

public class ViewController{

  private ViewModel vModel;
  private Player player;
  private double angleStep = (Math.PI/3)/60;

  public ViewController(ViewModel vModel){
    this.vModel = vModel;
    this.player = vModel.getPlayer();
  }

  public void move(double dx, double dy){
    player.move(dx, dy);
  }

  public void rotate(String direction){
    player.rotate(direction);
  }


  public double[] calculateColumn(int i){
    double rayAngle = player.getHeading() - ((Math.PI/3) / 2) + i * angleStep; 
    double[] collision = ViewService.castRay(new Ray(player.getPosX(), player.getPosY(), rayAngle), vModel.getMap());
    double correctedDistance = collision[3] * Math.cos(collision[4] - vModel.getPlayer().getHeading());//Fixing fisheye effect by adjusting distance
    double wallHeight = (64 * 480) / collision[3];//Wall height = tileSize * screenHeight divided by the corrected distance
    double wallTop = (480 - wallHeight) / 2;//Wall top = screenHeight - wallHeight divided by 2. (centers the wall in the view)
    double columnWidth = (double)640 / 60;//Calculating the width of each screen slice
    double x = i * columnWidth;//Calculating the starting x coordinate of the slice corresponding to this ray
    return new double[]{collision[0],x,wallTop,columnWidth,wallHeight};

  }


}
