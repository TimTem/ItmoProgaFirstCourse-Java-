package Json;

import Launcher.StackRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DesirializeFromJson {
    public static void fromJson() throws Exception{
        if ((new File("D:\\Berserk\\Server_Test\\src\\test\\java\\file.txt")).length() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            File file = new File("D:\\Berserk\\Server_Test\\src\\test\\java\\file.txt");
            if (file.canRead()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader;
                for (inputStreamReader = new InputStreamReader(fileInputStream); inputStreamReader.ready(); stringBuilder = stringBuilder.append(Character.toString(inputStreamReader.read()))) {
                }
                inputStreamReader.close();
            } else {
                System.out.println("File have same problems");
            }
            if (!stringBuilder.isEmpty()) {
                StackRunner.flats.addAll(Deserializer.deserializer(stringBuilder.toString()));
            }
        }
    }
}
