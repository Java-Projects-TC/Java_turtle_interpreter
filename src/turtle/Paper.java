package turtle;

public class Paper {

  private char[][] paper;

  Paper(int width, int height) {
    this.paper = new char[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        paper[i][j] = ' ';
      }
    }
  }

  private int getWidth() {
    return paper[0].length;
  }

  private int getHeight() {
    return paper.length;
  }

  boolean withinBounds(int x, int y) {
    return x >= 0 && y >= 0 && x < this.getWidth() && y < this.getHeight();
  }

  void markPaper(int x, int y, char character) {
    if (withinBounds(x, y)) {
      paper[(this.getHeight() - 1) - y][x] = character;
    }
  }

  public String toString() {
    String output = "";
    for (char[] lines : paper) {
      for (char character : lines) {
        output += character;
      }
      output += "\n";
    }
    return output;
  }


}
