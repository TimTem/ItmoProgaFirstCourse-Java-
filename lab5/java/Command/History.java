package Command;

public class History implements CommandWithoutVariable{
    Stack stack;

    public History(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute() {
        stack.history();
    }
}
