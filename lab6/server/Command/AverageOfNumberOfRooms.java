package Command;

public class AverageOfNumberOfRooms implements CommandWithoutVariable{
    Stack stack;

    public AverageOfNumberOfRooms(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void exucute() {
        stack.averageOfRooms();
    }
}
