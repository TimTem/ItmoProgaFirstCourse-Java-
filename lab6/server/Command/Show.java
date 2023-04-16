package Command;

public class Show implements CommandWithoutVariable{
    Stack stack;

    public Show(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute() {
        stack.show();
    }
}
