package turtle;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

class TurtleInterpreter {

  private final Map<String, Turtle> turtles = new HashMap();
  private Paper paper = new Paper(10, 10);
  private Scanner input;
  private PrintStream output;

  TurtleInterpreter(Scanner input, PrintStream output) {
    this.input = input;
    this.output = output;
  }

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
          input.next();
          String name = input.next();
          int xCoord = input.nextInt();
          int yCoord = input.nextInt();
          turtles.put(name,
              new Turtle(xCoord, yCoord, Pen.UP, '*', Direction.N, paper));
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
}
