package turtle;

import turtle.util.Coord;

public class Paper {

  private char[][] paper;

  public Paper(int width, int height) {
    this.paper = new char[height][width];

    for (char[] lines : paper) {
      for (char character : lines) {
        character = ' ';
      }
    }
  }

  int getWidth() {
    return paper[0].length;
  }

  int getHeight() {
    return paper.length;
  }

  boolean withinBounds(Coord coords) {
    return coords.getX() >= 0 && coords.getY() >= 0 &&
        coords.getX() < this.getWidth() && coords.getY() < this.getHeight();
  }

  // not sure what's easier, the user inputting a coord or inputting x and y.
  void markPaper(int x, int y, char character) {
    if (withinBounds(new Coord(x, y))) {
      paper[(this.getHeight() - 1) - y][x] = character;
    }
  }

  public String toString() {
    String output = "";
    for (char[] lines : paper) {
      for (char character : lines) {
        output = output + character;
      }
      output = output + "\n";
    }
    return output;
  }


}
