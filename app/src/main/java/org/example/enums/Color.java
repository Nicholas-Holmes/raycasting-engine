package org.example.enums;

import java.util.HashMap;
import java.util.Map;

public enum Color{
  MISSING(-1, 0xFFFF00FF),
  BLACK(0, 0xFF000000),
  WHITE(1, 0xFFFFFFFF),
  RED(2, 0xFFCC0000);

  private final int VALUE;
  private final int KEY;
  private static final Map<Integer, Color> ID_MAP = new HashMap<>();

  static {
    for (Color color: values()){
      ID_MAP.put(color.KEY, color);
    }
  }

  private Color(int key, int value){
    this.KEY = key;
    this.VALUE = value;
  }

  public static Color byId(int id){
    return ID_MAP.getOrDefault(id, MISSING);
  }

  public int getValue() {
    return this.VALUE;
  }

  public int getId(){
    return this.KEY;
  }

}
