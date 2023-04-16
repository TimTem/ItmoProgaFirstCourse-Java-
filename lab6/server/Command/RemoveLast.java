package Command;

public class RemoveLast implements CommandWithoutVariable{
    Stack stack;

    public RemoveLast(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute() {
        stack.removeLast();
    }
}
