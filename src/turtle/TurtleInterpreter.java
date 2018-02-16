package turtle;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import turtle.implementations.BouncyTurtle;
import turtle.implementations.ClusterTurtle;
import turtle.implementations.ContinuousTurtle;
import turtle.implementations.NormalTurtle;
import turtle.implementations.ReflectingTurtle;
import turtle.implementations.WrappingTurtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

class TurtleInterpreter {

  private final Map<String, Turtle> turtles = new HashMap();
  private Paper paper = new Paper(10, 10);
  private final Scanner input;
  private final PrintStream output;

  TurtleInterpreter(Scanner input, PrintStream output) {
    this.input = input;
    this.output = output;
  }

  // I would normally break the code down into separate methods which the
  // switch cases call to make it neater.
  void run() {
    while (input.hasNext()) {
      String command = input.next();
      switch (command) {
        case "paper":
          int width = input.nextInt();
          int height = input.nextInt();
          this.paper = new Paper(width, height);
          break;
        case "new":
          String type = input.next();
          String name = input.next();
          turtles.put(name, makeTurtle(type, name));
          break;
        case "pen":
          String turtleName = input.next();
          String penState = input.next();
          Turtle turtle = turtles.get(turtleName);
          if (penState.equals("up")) {
            turtle.setPenUP();
          } else if (penState.equals("down")) {
            turtle.setPenDOWN();
          } else {
            assert penState.length() == 1 : "not a valid pen state";
            turtle.alterBrush(penState.charAt(0));
          }
          break;
        case "move":
          turtle = turtles.get(input.next());
          turtle.move(input.nextInt());
          break;
        case "right":
          turtle = turtles.get(input.next());
          turtle.rotateTurtle(input.nextInt(), Rotation.RIGHT);
          break;
        case "left":
          turtle = turtles.get(input.next());
          turtle.rotateTurtle(input.nextInt(), Rotation.LEFT);
          break;
        case "show":
          output.println(paper.toString());
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
  }

  private Turtle makeTurtle(String tType, String tname) {
    Turtle turtle = null;
    switch (tType) {
      case "normal":
        int xCoord = input.nextInt();
        int yCoord = input.nextInt();
        turtle = new NormalTurtle(xCoord, yCoord,
            Pen.UP, '*', Direction.N, paper);
        break;
      case "bouncy":
        xCoord = input.nextInt();
        yCoord = input.nextInt();
        turtle = new BouncyTurtle(xCoord, yCoord,
            Pen.UP, '*', Direction.N, paper);
        break;
      case "continuous":
        xCoord = input.nextInt();
        yCoord = input.nextInt();
        turtle = new ContinuousTurtle(xCoord, yCoord,
            Pen.UP, '*', Direction.N, paper);
        break;
      case "wrapping":
        xCoord = input.nextInt();
        yCoord = input.nextInt();
        turtle = new WrappingTurtle(xCoord, yCoord,
            Pen.UP, '*', Direction.N, paper);
        break;
      case "reflecting":
        xCoord = input.nextInt();
        yCoord = input.nextInt();
        turtle = new ReflectingTurtle(xCoord, yCoord,
            Pen.UP, '*', Direction.N, paper);
        break;
      case "cluster":
        int numTurts = input.nextInt();
        List<Turtle> cTurtles = new ArrayList<>();
        for (int i = 0; i < numTurts; i++) {
          input.next();
          String subType = input.next();
          String subName = input.next();
          cTurtles.add(makeTurtle(subType,tname + "." + subName));
          turtles.put(tname + "." + subName, cTurtles.get(i));
        }
        turtle = new ClusterTurtle (cTurtles);
    }
    return turtle;
  }

}
