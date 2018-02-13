package turtle;

import turtle.util.Coord;
import turtle.util.Direction;
import turtle.util.Pen;

public class Turtle {

  private Coord location;
  private Pen pen;
  private Direction direction;
  private Paper paper;


  public Turtle(int x, int y, Pen pen, Direction direction) {
    this.location = new Coord(x, y);
    this.pen = pen;
    this.direction = direction;
    this.paper = new Paper(10, 10);
  }

  void switchPenState() {
  }

  void alterBrush() {
  }

  void rotateTurtle(int n) {
  }

  void drawOnPaper() {}

  // move turtle n steps in it's direction

}
