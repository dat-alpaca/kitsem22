package draw.model;

import java.awt.Graphics2D;

public interface ShapeTool {
    String getName();
    void draw(Graphics2D g, int x1, int y1, int x2, int y2);
}
