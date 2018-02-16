package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public class ReflectingTurtle extends AbstractTurtle implements Turtle {

  public ReflectingTurtle(int x, int y, Pen pen, char brushChar,
      Direction direction, Paper paper) {
    super(x, y, pen, brushChar, direction, paper);
  }

  @Override
  protected boolean actionAtEdge(int xStep, int yStep) {
    if (direction.isOrdinal() ||
        paper.isOutsideCorners(xCoord + xStep, yCoord + yStep)) {
      rotateTurtle(180, Rotation.RIGHT);
    }
    else if (isTravellingClockwiseVertWall()) {
      rotateTurtle(90, Rotation.RIGHT);
      yCoord += direction.getY();
    }
    else if (isTravellingClockwiseHorizWall()) {
      rotateTurtle(90, Rotation.RIGHT);
      xCoord += direction.getX();
    }
    else if (isTravellingAntiClockwiseVertWall()) {
      rotateTurtle(90, Rotation.LEFT);
      yCoord += direction.getY();
    }
    else if (isTravellingAntiClockwiseHorizWall()) {
      rotateTurtle(90, Rotation.LEFT);
      xCoord += direction.getX();
    }
    return true;
  }

  private boolean isTravellingClockwiseVertWall() {
    return
        xCoord == 0 && direction.toString().contains("NW") ||
            xCoord == paper.getWidth() -1 && direction.toString().contains
                ("SE");
  }

  private boolean isTravellingClockwiseHorizWall() {
    return yCoord == 0 && direction.toString().contains("SW") ||
        yCoord == paper.getHeight() -1 && direction.toString().contains("NE");
  }

  private boolean isTravellingAntiClockwiseVertWall() {
    return
        xCoord == 0 && direction.toString().contains("SW") ||
            xCoord == paper.getWidth() -1 && direction.toString().contains
                ("NE");
  }

  private boolean isTravellingAntiClockwiseHorizWall() {
    return
        yCoord == 0 && direction.toString().contains("SE") ||
            yCoord == paper.getHeight() - 1 && direction.toString().contains
                ("NW");
  }

}
