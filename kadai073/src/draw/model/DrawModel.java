package draw.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawModel {
    private final List<Figure> figures = new ArrayList<>();
    private final List<ModelListener> listeners = new ArrayList<>();

    private ShapeTool tool;
    private Color color;
    private Figure preview;

    public DrawModel(ShapeTool firstTool, Color firstColor) {
        this.tool = firstTool;
        this.color = firstColor;
    }

    // Observer:
    public void addListener(ModelListener listener) {
        listeners.add(listener);
    }

    private void emitModelChanged() {
        for (ModelListener listener : listeners)
            listener.modelChanged();
    }

    // Figure:
    public void addFigure(Figure figure) {
        figures.add(figure);
        preview = null;
        emitModelChanged();
    }

    public void clear() {
        figures.clear();
        preview = null;
        emitModelChanged();
    }

    // State:
    public List<Figure> getFigures() { return Collections.unmodifiableList(figures); }
    public ShapeTool getTool() { return tool; }
    public Color getColor() { return color; }
    public Figure getPreview() { return preview; }

    public void setTool(ShapeTool tool) {
        this.tool = tool;
        emitModelChanged();
    }

    public void setColor(Color color) {
        this.color = color;
        emitModelChanged();
    }

    public void setPreview(Figure preview) {
        this.preview = preview;
        emitModelChanged();
    }
}