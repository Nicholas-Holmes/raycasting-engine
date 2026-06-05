package org.example.assets;

import java.util.HashMap;
import java.util.Map;
import org.example.enums.Color;

public class TextureRegistry{
  private static Map<Integer, Texture> registry = new HashMap<>();
  
  public static void register(int id, Texture texture){
    registry.put(id, texture);
  }

  public static Color getPixel(int id, int texY, int texX){
    Texture texture = registry.get(id);
    return texture.getPixel(texY, texX);
  }
}
