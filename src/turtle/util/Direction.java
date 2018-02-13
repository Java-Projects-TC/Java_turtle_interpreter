package turtle.util;

public enum Direction {

  N(0),
  NE(45),
  E(90),
  SE(135),
  S(180),
  SW(225),
  W(270),
  NW(315);

  private int dir;

  Direction() { this.dir = 0;}

  Direction(int dir) { this.dir = dir;}

  public Direction rotate(Rotation rotation) {
    switch (rotation) {
      case LEFT: return Direction.values()[(this.ordinal() - 1) % 8];
      case RIGHT: return Direction.values()[(this.ordinal() + 1) % 8];
    }
    return null;
  }
}
