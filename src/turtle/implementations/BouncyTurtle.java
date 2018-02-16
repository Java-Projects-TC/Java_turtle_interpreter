package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public class BouncyTurtle extends AbstractTurtle implements Turtle {

  public BouncyTurtle(int x, int y, Pen pen, char brushChar,
      Direction direction, Paper paper) {
    super(x, y, pen, brushChar, direction, paper);
  }

  @Override
  protected boolean actionAtEdge(int xStep, int yStep) {
    rotateTurtle(180, Rotation.RIGHT);
    mark();
    return true;
  }
}
