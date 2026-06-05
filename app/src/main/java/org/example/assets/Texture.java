package org.example.assets;
import org.example.enums.Color;

public class Texture{
  private Color[][] texture;
  private int id;

  public Texture(Color[][] texture, int id){
    this.texture = texture;
    this.id = id;
  }

  public Color[][] getTexture(){
    return this.texture;
  }

  public Color getPixel(int texY, int texX){
    return texture[texY][texX];
  }

  public int getId(){
    return this.id;
  }
}
