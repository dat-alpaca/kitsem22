package draw.view;

import draw.model.ShapeTool;
import java.awt.*;
import javax.swing.Icon;

public class ToolIcon implements Icon {

    private static final int SIZE = 32, PADDING = 6;
    private final ShapeTool tool;

    public ToolIcon(ShapeTool tool) {
        this.tool = tool;
    }

    @Override
    public void paintIcon(Component component, Graphics rootGraphics, int x, int y) {
        Graphics2D graphics = (Graphics2D) rootGraphics.create();

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.DARK_GRAY);
        graphics.setStroke(new BasicStroke(2f));
        graphics.translate(x, y);
        
        tool.draw(graphics, PADDING, SIZE - PADDING, SIZE - PADDING, PADDING);
        
        graphics.dispose();
    }

    @Override
    public int getIconWidth() {
        return SIZE;
    }

    @Override
    public int getIconHeight() {
        return SIZE;
    }
}
