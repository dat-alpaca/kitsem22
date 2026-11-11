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

        void draw(Graphics g) {
            g.setColor(color);
            switch (shape) {
                case LINE:
                    g.drawLine(x1, y1, x2, y2);
                    break;
                case RECT:
                    g.drawRect(Math.min(x1, x2), Math.min(y1, y2),
                               Math.abs(x2 - x1), Math.abs(y2 - y1));
                    break;
                case OVAL:
                    g.drawOval(Math.min(x1, x2), Math.min(y1, y2),
                               Math.abs(x2 - x1), Math.abs(y2 - y1));
                    break;
            }
        }
    }

    private class DrawCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            for (Figure f : figures)
                f.draw(g);
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
            case "Line":  currentShape = Shape.LINE;   break;
            case "Rect":  currentShape = Shape.RECT;   break;
            case "Oval":  currentShape = Shape.OVAL;   break;
            case "Black": currentColor = Color.BLACK;  break;
            case "Red":   currentColor = Color.RED;    break;
            case "Green": currentColor = Color.GREEN;  break;
            case "Clear":
                figures.clear();
                canvas.repaint();
                break;
            case "Quit":
                System.exit(0);
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        figures.add(new Figure(currentShape, currentColor,
                               startX, startY, e.getX(), e.getY()));
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