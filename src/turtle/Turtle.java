package turtle;

import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

class Turtle {

  private int xCoord;
  private int yCoord;
  private Pen pen;
  private char brushChar;
  private Direction direction;
  private Paper paper;


  Turtle(int x, int y, Pen pen, char brushChar, Direction direction,
      Paper paper) {
    this.xCoord = x;
    this.yCoord = y;
    this.pen = pen;
    this.brushChar = brushChar;
    this.direction = direction;
    this.paper = paper;
  }

  void setPenUP() {
    pen = Pen.UP;
  }

  void setPenDOWN() {
    pen = Pen.DOWN;
  }

  void alterBrush(char c) {
    brushChar = c;
  }

  void rotateTurtle(int angle, Rotation rotation) {
    assert (angle % 45 == 0) : " incorrect rotation angle";
    while (angle > 0) {
      direction = direction.rotate(rotation);
      angle -= 45;
    }
  }

  private void mark() {
    if (pen.equals(Pen.DOWN))
    paper.markPaper(xCoord, yCoord, brushChar);
  }

  void move(int numSteps) {
    int xStep = 0, yStep = 0;
    if (direction.toString().contains("N")) {
      yStep = 1;
    } else if (direction.toString().contains("S")) {
      yStep = -1;
    }
    if (direction.toString().contains("E")) {
      xStep = 1;
    } else if (direction.toString().contains("W")) {
      xStep = -1;
    }
    while (numSteps > 0) {
      xCoord += xStep;
      yCoord += yStep;
      if (!paper.withinBounds(xCoord, yCoord)) {
        xCoord -= xStep;
        yCoord -= yStep;
        actionAtEdge();
        break;
      }
      mark();
      numSteps--;
    }
  }

  private void actionAtEdge(){
    mark();
  }

}
