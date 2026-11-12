package draw.controller;

public interface Command {
    String getName();

    void execute();

    static Command of(String name, Runnable action) {
        return new Command() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public void execute() {
                action.run();
            }
        };
    }
}
