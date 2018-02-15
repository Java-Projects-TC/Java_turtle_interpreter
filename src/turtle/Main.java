package turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner input;
    PrintStream output;
    if (args.length == 0) {
      input = new Scanner(System.in);
      output = new PrintStream(System.out);
    } else {
      input = new Scanner(new File(args[0]));
      if (args.length == 2) {
        output = new PrintStream(args[1]);
      } else {
        output = new PrintStream(System.out);
      }
    }
    TurtleInterpreter interpreter = new TurtleInterpreter(input, output);
    interpreter.run();
  }
}
