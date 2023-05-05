package Launcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExitClient {
    public static boolean exitClient() {
        System.out.println("Вы уверены, что вы хотите отключиться?(Да|Нет)");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.toLowerCase().replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^(да|нет|yes|no)$");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()) {
            if (mt.group(1).equals("да") || mt.group(1).equals("yes"))  {
                return true;
            }
            if (mt.group(1).equals("нет") || mt.group(1).equals("no")) {
                System.out.println("Вы остались.");
                return false;
            }
        } else {
            System.out.println("Непонятный синтаксис");
            exitClient();
        }
        return false;
    }
}

