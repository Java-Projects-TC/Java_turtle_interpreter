package turtle.util;

public enum Direction {

  N(0, 1),
  NE(1, 1),
  E(1, 0),
  SE(1, -1),
  S(0, -1),
  SW(-1, -1),
  W(-1, 0),
  NW(-1, 1);

  private final int x;
  private final int y;
  private static final int NUM_VALUES = values().length;

  Direction(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isOrdinal() {
    return x == 0 || y == 0;
  }

  public Direction rotate(Rotation rotation) {
    switch (rotation) {
      case LEFT:
        return pred();
      case RIGHT:
        return succ();
      default:
        return this;
    }
  }

  private Direction pred() {
    return values()[(this.ordinal() - 1 + NUM_VALUES) % NUM_VALUES];
  }

  private Direction succ() {
    return values()[(this.ordinal() + 1) % NUM_VALUES];
  }

}
