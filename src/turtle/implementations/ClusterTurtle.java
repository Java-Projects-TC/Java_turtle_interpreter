package turtle.implementations;

import java.util.ArrayList;
import java.util.List;
import turtle.Turtle;
import turtle.util.Rotation;

public class ClusterTurtle implements Turtle{

  private List<Turtle> cTurtles = new ArrayList<>();

  public ClusterTurtle(List<Turtle> cTurtles) {
    this.cTurtles = cTurtles;
  }

  @Override
  public void setPenUP() {
    for (Turtle turtle : cTurtles) {
      turtle.setPenUP();
    }
  }

  @Override
  public void setPenDOWN() {
    for (Turtle turtle : cTurtles) {
      turtle.setPenDOWN();
    }
  }

  @Override
  public void alterBrush(char c) {
    for (Turtle turtle : cTurtles) {
      turtle.alterBrush(c);
    }
  }

  @Override
  public void rotateTurtle(int angle, Rotation rotation) {
    for (Turtle turtle : cTurtles) {
      turtle.rotateTurtle(angle, rotation);
    }
  }

  @Override
  public void move(int numSteps) {
    for (Turtle turtle : cTurtles) {
      turtle.move(numSteps);
    }
  }

}
