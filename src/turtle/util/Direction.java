package turtle.util;

public enum Direction {

  N, NE, E, SE, S, SW, W, NW;

  private static final int NUM_VALUES = values().length;

  public Direction rotate(Rotation rotation) {
    switch (rotation) {
      case LEFT: return Direction.values()[(this.ordinal() - 1 + NUM_VALUES)
          % NUM_VALUES];
      case RIGHT: return Direction.values()[(this.ordinal() + 1) % NUM_VALUES];
      default: return this;
    }
  }
}
