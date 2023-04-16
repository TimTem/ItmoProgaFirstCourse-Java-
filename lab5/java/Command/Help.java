package Command;

public class Help implements CommandWithoutVariable{
    Stack stack;

    public Help(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute() {
        stack.help();
    }
}
