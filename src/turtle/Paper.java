package turtle;

public class Paper {

  private final char[][] paper;

  Paper(int width, int height) {
    this.paper = new char[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        paper[i][j] = ' ';
      }
    }
  }

  public int getWidth() {
    return paper[0].length;
  }

  public int getHeight() {
    return paper.length;
  }

  public boolean withinBounds(int x, int y) {
    return x >= 0 && y >= 0 && x < this.getWidth() && y < this.getHeight();
  }

  public boolean isOutsideCorners(int x, int y) {
    return x < 0 && y < 0 ||
        x < 0 && y >= this.getHeight() ||
        y < 0 && x >= this.getWidth() ||
        y >= this.getHeight() && x >= this.getWidth();
  }

  public void markPaper(int x, int y, char character) {
    if (withinBounds(x, y)) {
      // y == 0  is at the bottom left as opposed to top left so need to do
      // height - 1 - y
      paper[(this.getHeight() - 1) - y][x] = character;
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (char[] lines : paper) {
      sb.append(lines);
      sb.append("\n");
    }
    return sb.toString();
  }




}
