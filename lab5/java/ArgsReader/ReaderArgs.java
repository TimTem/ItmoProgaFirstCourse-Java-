package ArgsReader;

import Json.Deserializer;
import Launcher.StackRunner;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReaderArgs {
    public static void argsReader(String[] args) {

        try {
            StringBuilder stringBuilder = new StringBuilder();

            for (String element : args) {

                FileInputStream file = new FileInputStream(element);
                InputStreamReader inputStreamReader = new InputStreamReader(file);
                while (inputStreamReader.ready()) {
                    stringBuilder = stringBuilder.append(Character.toString(inputStreamReader.read()));
                }
                System.out.println(element + " was correctly added in Tree Set.");
                inputStreamReader.close();
                file.close();
            }


            StackRunner.flats.addAll(Deserializer.deserializer(stringBuilder.toString()));
        } catch (Exception e) {

            System.out.println("Reading files through the command line argument did not happen correctly.");

        }

    }
}
