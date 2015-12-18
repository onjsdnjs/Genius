package name.yalsooni.genius.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author yoon
 */
public class PropertyReader {

    private Map<String, Properties> propertiesRepository;

    public PropertyReader() {
        propertiesRepository = new HashMap<String, Properties>();
    }

    public Properties read(String name, String path) throws Exception {

        if (propertiesRepository.get(name) != null) {
            throw new Exception("이미 존재하는 프로퍼티 이름입니다. : " + name);
        }

        FileInputStream inStream;
        Properties properties = null;

        try {

            inStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inStream);

            this.propertiesRepository.put(name, properties);

        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }

        return properties;
    }

    public String get(String name, String key) {
        return this.propertiesRepository.get(name).getProperty(key);
    }

    public Properties getProperties(String name) {
        return this.propertiesRepository.get(name);
    }
}
