//package Command;
//
//import java.io.IOException;
//
//public class ExecuteScript implements CommandWithVariable{
//    Stack stack;
//
//    public ExecuteScript(Stack stack) {
//        this.stack = stack;
//    }
//
//    @Override
//    public void exucute(String str){
//        try {
//            stack.executeScript(str);
//        }catch (IOException e){
//            System.out.println("File not found");
//        }
//    }
//}
