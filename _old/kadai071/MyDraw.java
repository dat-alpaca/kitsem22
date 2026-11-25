
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MyDraw extends Frame implements MouseListener {

    private int startX, startY;
    private final ArrayList<int[]> lines = new ArrayList<>();

    public MyDraw() {
        super("MyDraw");
        setSize(300, 300);
        addMouseListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics rootGraphics) {
        Graphics2D graphics = (Graphics2D)rootGraphics.create();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int[] line : lines)
            graphics.drawLine(line[0], line[1], line[2], line[3]);
    
        graphics.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        lines.add(new int[] { startX, startY, e.getX(), e.getY() });
        repaint();
    }

    @Override public void mouseClicked(MouseEvent e) { }
    @Override public void mouseEntered(MouseEvent e) { }
    @Override public void mouseExited(MouseEvent e)  { }

    public static void main(String[] args) {
        MyDraw draw = new MyDraw();
        draw.setVisible(true);
    }
}