package Command.ImplementationCommands;

public class ImplementationCommandHelp {
        public static void implementationHelp(){
            System.out.println(" 1) info:  вывести в стандартный поток вывода информацию о коллекции.");
            System.out.println(" 2) show: вывести в стандартный поток вывода все элементы коллекции в \nстроковом представлении.");
            System.out.println(" 3) add {\"name of the film\"}: добавить новый элемент в коллекцию.");
            System.out.println(" 4) update {\"id\"}: обновить значение элемента коллекции, id которого \nравен заданному.");
            System.out.println(" 5) remove_by_id {\"id\"}: удалить элемент из коллекции по его id.");
            System.out.println(" 6) clear: очистить коллекцию.");

            System.out.println(" 7) save: сохранить коллекцию в файл.");
            System.out.println(" 8) execute_script {\"file name\"}: считать и исполнить скрипт из указан-\nного файла.");

            System.out.println(" 9) add_if_max {\"oscars count\"}: добавить новый элемент в коллекцию, если \nего количество полученных оскаров превышает значение наибольшего элемента этой \nколлекции.");
            System.out.println("10) remove_last: удалить последний элемент из коллекции");
            System.out.println("11) remove_greater {\"element\"}:удалить из коллекции все элементы, превышающие заданный.");

            System.out.println("12) average_of_number_of_rooms:  вывести среднее значение поля numberOfRooms для всех элементов коллекции.");
            System.out.println("13) filter_starts_with_name:вывести элементы, значение поля name которых начинается с заданной подстроки.");
            System.out.println("14) filter_less_than_transport: вывести элементы, значение поля transport которых меньше заданного.");
            System.out.println("15) insert_at index {\"element\"}:  добавить новый элемент в заданную позицию remove_last : удалить последний элемент из коллекции");
            System.out.println("16) help: вывести справку по доступным командам");
            System.out.println("17) exit: завершить программу.");
        }
}
