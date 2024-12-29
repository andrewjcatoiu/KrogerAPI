import java.io.IOException;

public class Fetcher {
    public static void main(String[] args) {
        ConfigProcessor configProcessor = new ConfigProcessor();

        try {
            configProcessor.processConfig();
            System.out.println(configProcessor);
        } catch (IOException e) {
            System.out.println("Cannot access file: " + configProcessor.getEnv());
        }
    }
}
