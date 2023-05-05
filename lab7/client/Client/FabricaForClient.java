package Client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FabricaForClient {
    ExecutorService exec = Executors.newFixedThreadPool(2);
}
