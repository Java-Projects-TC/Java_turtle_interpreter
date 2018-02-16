package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;

public class WrappingTurtle extends AbstractTurtle implements Turtle {

  public WrappingTurtle(int x, int y, Pen pen, char brushChar,
      Direction direction, Paper paper) {
    super(x, y, pen, brushChar, direction, paper);
  }

  // I know there's a better way to do this but i'm super rushed and want to
  // get on to part III.
  @Override
  protected boolean actionAtEdge(int xStep, int yStep) {
    if (yCoord == paper.getHeight()-1){
      yCoord = 0;
      xCoord += xStep;
    } else if(yCoord == 0 ) {
      yCoord = paper.getHeight() - 1;
      xCoord += xStep;
    } else if(xCoord == 0) {
      xCoord = paper.getWidth() - 1;
      yCoord += yStep;
    } else if(xCoord == paper.getWidth() -1) {
      xCoord = 0;
      yCoord += yStep;
    }
    return true;
  }

}
