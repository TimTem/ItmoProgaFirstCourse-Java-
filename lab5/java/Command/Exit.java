package Command;

public class Exit implements  CommandWithoutVariable{
    Stack stack;

    public Exit(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute() {
        stack.exit();
    }
}
