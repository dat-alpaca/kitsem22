package draw.controller;

import draw.model.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class DrawController extends MouseAdapter {
    private final DrawModel model;
    private int startX, startY;
    private boolean isDragging;

    public DrawController(DrawModel model) {
        this.model = model;
    }

    public void selectTool(ShapeTool tool) { model.setTool(tool); }
    public void selectColor(Color color) { model.setColor(color); }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!SwingUtilities.isLeftMouseButton(e))
            return;
        
        startX = e.getX();
        startY = e.getY();

        isDragging = true;
        model.setPreview(currentFigure(e));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!isDragging)
            return;
        
        model.setPreview(currentFigure(e));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!isDragging)
            return;

        isDragging = false;
        if (e.getX() == startX && e.getY() == startY) 
            model.setPreview(null);
        else
            model.addFigure(currentFigure(e));
    }

    private Figure currentFigure(MouseEvent e) {
        return new Figure(model.getTool(), model.getColor(), startX, startY, e.getX(), e.getY());
    }
}
