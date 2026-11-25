package draw.model;

import java.awt.Graphics2D;

public enum ShapeTools implements ShapeTool {

    Line("Line") {
        @Override
        public void draw(Graphics2D g, int x1, int y1, int x2, int y2) {
            g.drawLine(x1, y1, x2, y2);
        }
    },

    Rect("Rectangle") {
        @Override
        public void draw(Graphics2D g, int x1, int y1, int x2, int y2) {
            g.drawRect(Math.min(x1, x2), Math.min(y1, y2),
                       Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    },

    RectangleFilled("RectangleFilled") {
        @Override
        public void draw(Graphics2D g, int x1, int y1, int x2, int y2) {
            g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
            g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    },

    Oval("Oval") {
        @Override
        public void draw(Graphics2D g, int x1, int y1, int x2, int y2) {
            g.drawOval(Math.min(x1, x2), Math.min(y1, y2),
                       Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    },
    
    OvalFilled("OvalFilled") {
        @Override
        public void draw(Graphics2D g, int x1, int y1, int x2, int y2) {
            g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
            g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    };

    private final String name;

    ShapeTools(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
