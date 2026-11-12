package draw.view;

import draw.controller.*;
import draw.model.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class SidebarPanel extends JPanel implements ModelListener {
    private final DrawModel model;
    private final DrawController controller;

    private final Map<ShapeTool, JToggleButton> toolButtons = new LinkedHashMap<>();
    private final Map<Color, JToggleButton> colorButtons = new LinkedHashMap<>();
    private final ButtonGroup toolGroup = new ButtonGroup();
    private final ButtonGroup colorGroup = new ButtonGroup();
    private final JPanel currentColorView = new JPanel();

    private final int BORDER_PADDING = 6;
    private final int VERTICAL_STRUT = 8;

    public SidebarPanel(DrawModel model, DrawController controller, List<? extends ShapeTool> tools, List<Color> palette, List<Command> commands) {
        this.model = model;
        this.controller = controller;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(BORDER_PADDING, BORDER_PADDING, BORDER_PADDING, BORDER_PADDING));

        add(createSection("Shapes", buildShapeToolPanel(tools)));
        add(Box.createVerticalStrut(VERTICAL_STRUT));

        add(createSection("Colors", buildColorsPanel(palette)));
        add(Box.createVerticalStrut(VERTICAL_STRUT));
        
        add(createSection("Commands", buildCommandsPanel(commands)));
        add(Box.createVerticalGlue());

        model.addListener(this);
        modelChanged();
    }

    private JComponent buildShapeToolPanel(List<? extends ShapeTool> tools) {
        JPanel panel = new JPanel(new GridLayout(0, 2, 4, 4));

        for (ShapeTool tool : tools) {
            JToggleButton button = new JToggleButton(new ToolIcon(tool));
            button.setToolTipText(tool.getName());
            button.setFocusPainted(false);
            button.addActionListener(e -> controller.selectTool(tool));
            
            toolGroup.add(button);
            toolButtons.put(tool, button);
            panel.add(button);
        }

        return panel;
    }

    private JComponent buildColorsPanel(List<Color> palette) {
        // Default color swatches:
        JPanel swatches = new JPanel(new GridLayout(0, 4, 4, 4));
        for (Color color : palette) {
            JToggleButton button = new JToggleButton(new ColorIcon(color));
            button.setMargin(new Insets(2, 2, 2, 2));
            button.setFocusPainted(false);
            button.setToolTipText(String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue()));
            button.addActionListener(e -> controller.selectColor(color));
        
            colorGroup.add(button);
            colorButtons.put(color, button);
            swatches.add(button);
        }

        // Custom Color:
        JButton custom = new JButton("Custom...");
        custom.setToolTipText("Open the color picker");
        custom.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(this, "Choose a color", model.getColor());
            if (chosen != null) {
                controller.selectColor(chosen);
            }
        });
        custom.setMaximumSize(new Dimension(Integer.MAX_VALUE, custom.getPreferredSize().height));

        // Color Preview:
        currentColorView.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        currentColorView.setToolTipText("Current color");
        currentColorView.setPreferredSize(new Dimension(10, 20));
        currentColorView.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));

        // Panels:
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (JComponent c : new JComponent[] { swatches, custom })
            c.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(swatches);
        panel.add(Box.createVerticalStrut(BORDER_PADDING));
        panel.add(custom);
        panel.add(Box.createVerticalStrut(BORDER_PADDING));
        panel.add(currentColorView);

        return panel;
    }

    private JComponent buildCommandsPanel(List<Command> commands) {
        JPanel panel = new JPanel(new GridLayout(0, 1, 4, 4));
        
        for (Command command : commands) {
            JButton button = new JButton(command.getName());
            button.addActionListener(e -> command.execute());
            panel.add(button);
        }

        return panel;
    }

    private static JComponent createSection(String title, JComponent content) {
        JPanel wrapper = new JPanel(new BorderLayout());

        wrapper.setBorder(BorderFactory.createTitledBorder(title));
        wrapper.add(content, BorderLayout.CENTER);
        wrapper.setAlignmentX(Component.LEFT_ALIGNMENT);
        wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, wrapper.getPreferredSize().height));
        
        return wrapper;
    }

    @Override
    public void modelChanged() {
        JToggleButton toolButton = toolButtons.get(model.getTool());
        if (toolButton != null)
            toolButton.setSelected(true);

        JToggleButton colorButton = colorButtons.get(model.getColor());
        if (colorButton != null)
            colorButton.setSelected(true);
        else
            colorGroup.clearSelection();
        
        currentColorView.setBackground(model.getColor());
        repaint();
    }
}
