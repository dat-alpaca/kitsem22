package draw.view;

import draw.model.*;
import java.awt.*;
import javax.swing.JPanel;

public class Canvas extends JPanel implements ModelListener {

    private final DrawModel model;

    public Canvas(DrawModel model) {
        this.model = model;
        setBackground(Color.WHITE);
        model.addListener(this);
    }

    @Override
    protected void paintComponent(Graphics rootGraphics) {
        super.paintComponent(rootGraphics);

        Graphics2D graphics = (Graphics2D) rootGraphics.create();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Figure figure : model.getFigures())
            figure.draw(graphics);

        Figure preview = model.getPreview();
        if (preview != null)
            preview.draw(graphics);
        
        graphics.dispose();
    }

    @Override
    public void modelChanged() {
        repaint();
    }
}
