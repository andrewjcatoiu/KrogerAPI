import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ConfigProcessor {

    private final Map<String, String> config;

    private static final Path env = Path.of(".env");
    
    public ConfigProcessor() {
        this.config = new HashMap<>();
    }

    public void processConfig() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(env)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    config.put(parts[0], parts[1]);
                }
            }
        }
    }

    public String getEnv() {
        return env.toString();
    }

    public String getValue(String key) {
        return config.getOrDefault(key, "");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (var entry : config.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" : ");
            sb.append(entry.getValue());
            sb.append("\n");
        }

        return sb.toString();
    }
}