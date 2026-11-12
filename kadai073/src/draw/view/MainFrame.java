package draw.view;

import draw.controller.*;
import draw.model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    public MainFrame(DrawModel model, DrawController controller, List<? extends ShapeTool> tools, List<Color> palette, List<Command> commands) {
        super("Bootleg Paint");

        initializeGUI(model, controller, tools, palette, commands);
    }

    private void initializeGUI(DrawModel model, DrawController controller, List<? extends ShapeTool> tools, List<Color> palette, List<Command> commands) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(640, 480);
        
        setLayout(new BorderLayout());

        add(new SidebarPanel(model, controller, tools, palette, commands), BorderLayout.WEST);

        Canvas canvas = new Canvas(model);
        canvas.addMouseListener(controller);
        canvas.addMouseMotionListener(controller);
        add(canvas, BorderLayout.CENTER);
    }
}