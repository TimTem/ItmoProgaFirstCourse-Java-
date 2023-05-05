package AuthorizationClient;

import AuthorizationClient.Authentication.UserAuthentication;
import AuthorizationClient.RedisterUser.RegistUser;

import java.util.Scanner;

public class Config {
    public static void config()throws Exception{
        System.out.println("Добро пожаловать!");
        while (true){
            System.out.println("Выберите действие" + "\n"
                    + "1) Авторизоваться " + "\n"
                    + "2) Зарегистрироваться");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if(answer.equals("1")){
                UserAuthentication.authenticationForClient();
                continue;
            }if(answer.equals("2")) {
                RegistUser.registUser();
                continue;
            }
            System.out.println("Неверный синтаксис!");
        }
    }
}
