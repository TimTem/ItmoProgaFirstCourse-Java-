import ArgsReader.ReaderArgs;
import Launcher.StackRunner;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        ReaderArgs.argsReader(args);
        StackRunner.runner();
    }
}
