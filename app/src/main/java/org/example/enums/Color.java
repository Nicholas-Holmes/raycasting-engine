package org.example.enums;
public enum Color{
  C0(0xFF000000),
  C1(0xFFFFFFFF);

  private final int value;

  private Color(int value){
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

}
