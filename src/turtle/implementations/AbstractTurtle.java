package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public abstract class AbstractTurtle implements Turtle {

  protected int xCoord;
  protected int yCoord;
  private Pen pen;
  private char brushChar;
  protected Direction direction;
  protected final Paper paper;


  public AbstractTurtle(int x, int y, Pen pen, char brushChar,
      Direction direction,
      Paper paper) {
    assert paper.withinBounds(x, y) : "turtle not created on paper";
    this.xCoord = x;
    this.yCoord = y;
    this.pen = pen;
    this.brushChar = brushChar;
    this.direction = direction;
    this.paper = paper;
  }

  public void setPenUP() {
    pen = Pen.UP;
  }

  public void setPenDOWN() {
    pen = Pen.DOWN;
  }

  public void alterBrush(char c) {
    brushChar = c;
  }

  public void rotateTurtle(int angle, Rotation rotation) {
    assert (angle % 45 == 0) : " incorrect rotation angle";
    while (angle > 0) {
      direction = direction.rotate(rotation);
      angle -= 45;
    }
  }

  void mark() {
    if (pen.equals(Pen.DOWN)) {
      paper.markPaper(xCoord, yCoord, brushChar);
    }
  }

  public void move(int numSteps) {
    assert numSteps >= 0 : "can't move a negative number of steps";
    while (numSteps > 0) {
      int xStep = direction.getX();
      int yStep = direction.getY();
      int nextX = xCoord + xStep;
      int nextY = yCoord + yStep;
      if (paper.withinBounds(nextX, nextY)) {
        xCoord = nextX;
        yCoord = nextY;
      } else if (!actionAtEdge(xStep, yStep)){
        // did this for normal turtle so it breaks out of the loop rather
        // than repeats hitting the edge.
        break;
      }
      mark();
      numSteps--;
    }
  }

  protected abstract boolean actionAtEdge(int xStep, int yStep);

}
