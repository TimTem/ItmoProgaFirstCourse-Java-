package Command;

public class Clear implements CommandWithoutVariable{
    Stack stack;

    public Clear(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute() {
        stack.clear();
    }
}
