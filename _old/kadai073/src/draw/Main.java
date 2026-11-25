package draw;

import draw.controller.Command;
import draw.controller.DrawController;
import draw.model.DrawModel;
import draw.model.ShapeTool;
import draw.model.ShapeTools;
import draw.view.MainFrame;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ShapeTool> shapes = Arrays.<ShapeTool>asList(ShapeTools.values());

        List<Color> palette = Arrays.asList
        (
            Color.BLACK, 
            Color.RED, 
            Color.GREEN, 
            Color.BLUE,
            Color.ORANGE, 
            Color.MAGENTA, 
            Color.CYAN, 
            Color.GRAY
        );

        DrawModel drawModel = new DrawModel(ShapeTools.Line, Color.BLACK);
        DrawController drawController = new DrawController(drawModel);

        List<Command> commands = Arrays.asList
        (
            Command.of("Clear", drawModel::clear),
            Command.of("Quit", () -> System.exit(0))
        );

        new MainFrame(drawModel, drawController, shapes, palette, commands).setVisible(true);
    }
}