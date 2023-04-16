package Command;

public class RemoveGreater implements CommandWithVariable{
    Stack stack;

    public RemoveGreater(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute(String str) {
        stack.removeGreater(str);
    }
}
