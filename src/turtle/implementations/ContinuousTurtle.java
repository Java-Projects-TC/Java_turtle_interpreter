package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;

public class ContinuousTurtle extends AbstractTurtle implements Turtle {

  public ContinuousTurtle(int x, int y, Pen pen, char brushChar,
      Direction direction, Paper paper) {
    super(x, y, pen, brushChar, direction, paper);
  }

  @Override
  protected boolean actionAtEdge(int xStep, int yStep) {
    xCoord += xStep;
    yCoord += yStep;
    return true;
  }
}
