package org.example.utils;

import org.example.enums.Color;
import org.example.assets.Texture;
import org.example.assets.TextureRegistry;

public class Loader{

  public static void loadTextures(String[][] texture){
    String[][][] textures = new String[1][32][32];
    Color[][] parsedTex = parseTexture(texture);
    Texture tex = new Texture(parsedTex, 1);
    TextureRegistry.register(tex.getId(), tex);
  }

  private static Color[][] parseTexture(String[][] texture){
    Color[][] parsedTex = new Color[32][32];
    for(int i = 0;i < texture.length; i++){
      for (int j = 0; j < texture[i].length; j++){
        String toParse = texture[i][j];
        Color color = Color.byId(toParse);
        parsedTex[i][j] = color;
      }
    }
    return parsedTex;
  } 
}
