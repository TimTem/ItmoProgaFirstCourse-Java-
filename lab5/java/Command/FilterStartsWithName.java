package Command;

public class FilterStartsWithName implements CommandWithVariable{
    Stack stack;

    public FilterStartsWithName(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute(String str) {
        stack.filterStartsWithName(str);
    }
}
