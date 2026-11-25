package draw.view;

import java.awt.*;
import javax.swing.*;

public class ColorIcon implements Icon {

    private static final int SIZE = 24;
    private final Color color;

    public ColorIcon(Color color) {
        this.color = color;
    }

    @Override
    public void paintIcon(Component component, Graphics rootGraphics, int x, int y) {
        Graphics2D graphics = (Graphics2D) rootGraphics.create();
        graphics.setColor(color);
        graphics.fillRect(x, y, SIZE, SIZE);
        
        boolean selected = component instanceof AbstractButton && ((AbstractButton) component).isSelected();
        {
            graphics.setColor(selected ? Color.BLACK : Color.GRAY);
            graphics.setStroke(new BasicStroke(selected ? 3f : 1f));
            graphics.drawRect(x, y, SIZE - 1, SIZE - 1);
        }

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
