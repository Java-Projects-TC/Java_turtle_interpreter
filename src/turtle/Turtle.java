package turtle;

import turtle.util.Rotation;

public interface Turtle {

  void setPenUP();

  void setPenDOWN();

  void alterBrush(char c);

  void rotateTurtle(int angle, Rotation rotation);

  void move(int numSteps);
}
