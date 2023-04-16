package Command;

public class Add implements CommandWithVariable{
    Stack stack;

    public Add(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute(String str) {
        stack.addElement(str);
    }
}
