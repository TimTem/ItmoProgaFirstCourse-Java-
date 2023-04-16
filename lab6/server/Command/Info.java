package Command;

public class Info implements CommandWithoutVariable {
    Stack stack;

    public Info(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute() {
        stack.info();
    }
}
