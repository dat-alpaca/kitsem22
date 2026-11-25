import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyDraw extends Frame implements MouseListener, ActionListener {
    private enum Shape { LINE, RECT, OVAL }

    private static class Figure {
        final Shape shape;
        final Color color;
        final int x1, y1, x2, y2;

        Figure(Shape shape, Color color, int x1, int y1, int x2, int y2) {
            this.shape = shape;
            this.color = color;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        void draw(Graphics rootGraphics) {
            Graphics2D graphics = (Graphics2D)rootGraphics.create();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            graphics.setColor(color);
            switch (shape) {
                case LINE -> graphics.drawLine(x1, y1, x2, y2);
                case RECT -> graphics.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                case OVAL -> graphics.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
            }
        }
    }

    private class DrawCanvas extends Canvas {
        @Override
        public void paint(Graphics rootGraphics) {
            for (Figure figure : figures)
                figure.draw(rootGraphics);
        }
    }

    private int startX, startY;
    private final ArrayList<Figure> figures = new ArrayList<>();
    private Shape currentShape = Shape.LINE;
    private Color currentColor = Color.BLACK;
    private final DrawCanvas canvas = new DrawCanvas();

    public MyDraw() {
        super("MyDraw");
        setSize(500, 400);
        setLayout(new BorderLayout());

        Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT));
        String[] names = { "Line", "Rect", "Oval", "Black", "Red", "Green", "Clear", "Quit" };
        for (String name : names) {
            Button button = new Button(name);
            button.addActionListener(this);
            panel.add(button);
        }
        add(panel, BorderLayout.NORTH);

        canvas.setBackground(Color.WHITE);
        canvas.addMouseListener(this);
        add(canvas, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Line" -> currentShape = Shape.LINE;
            case "Rect" -> currentShape = Shape.RECT;
            case "Oval" -> currentShape = Shape.OVAL;
            case "Black" -> currentColor = Color.BLACK;
            case "Red" -> currentColor = Color.RED;
            case "Green" -> currentColor = Color.GREEN;
            case "Clear" -> {
                figures.clear();
                canvas.repaint();
            }
            case "Quit" -> System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        figures.add(new Figure(currentShape, currentColor, startX, startY, e.getX(), e.getY()));
        canvas.repaint();
    }

    @Override public void mouseClicked(MouseEvent e) { }
    @Override public void mouseEntered(MouseEvent e) { }
    @Override public void mouseExited(MouseEvent e)  { }

    public static void main(String[] args) {
        MyDraw draw = new MyDraw();
        draw.setVisible(true);
    }
}