package Command.ImplementationCommands;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ImplementationCommandHelp {
        public static void implementationHelp(ObjectOutputStream out)throws IOException {
            out.writeObject(" 1) info:  вывести в стандартный поток вывода информацию о коллекции." + "\n" +
             "2) show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении." + "\n" +
             "3) add {\"name of the film\"}: добавить новый элемент в коллекцию." + "\n" +
             "4) update {\"id\"}: обновить значение элемента коллекции, id которого равен заданному." + "\n" +
             "5) remove_by_id {\"id\"}: удалить элемент из коллекции по его id." + "\n" +
             "6) clear: очистить коллекцию." + "\n" +
             "7) save: сохранить коллекцию в файл." + "\n" +
             "8) execute_script {\"file name\"}: считать и исполнить скрипт из указан-\nного файла." + "\n" +
             "9) add_if_max {\"oscars count\"}: добавить новый элемент в коллекцию, если \nего количество полученных оскаров превышает значение наибольшего элемента этой коллекции." + "\n" +
            "10) remove_last: удалить последний элемент из коллекции" + "\n" +
            "11) remove_greater {\"element\"}:удалить из коллекции все элементы, превышающие заданный." + "\n" +
            "12) average_of_number_of_rooms:  вывести среднее значение поля numberOfRooms для всех элементов коллекции." + "\n" +
            "13) filter_starts_with_name:вывести элементы, значение поля name которых начинается с заданной подстроки." + "\n" +
            "14) filter_less_than_transport: вывести элементы, значение поля transport которых меньше заданного." + "\n" +
            "15) insert_at index {\"element\"}:  добавить новый элемент в заданную позицию remove_last : удалить последний элемент из коллекции" + "\n" +
            "16) help: вывести справку по доступным командам" + "\n" +
            "17) exit: завершить программу.");
        }
}
