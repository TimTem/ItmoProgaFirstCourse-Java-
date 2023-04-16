package Command;

public class Save implements CommandWithoutVariable{
    Stack stack;

    public Save(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute() {
        stack.save();
    }
}
