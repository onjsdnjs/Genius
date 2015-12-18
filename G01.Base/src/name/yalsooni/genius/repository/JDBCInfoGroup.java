package name.yalsooni.genius.repository;

import name.yalsooni.genius.util.jdbc.JDBCConnectInfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JDBCInfoGroup {

    private Map<String, JDBCConnectInfo> map;

    public JDBCInfoGroup() {
        map = new HashMap<String, JDBCConnectInfo>();
    }

    public void setJdbcInfo(String key, JDBCConnectInfo info) {
        this.map.put(key, info);
    }

    public void getJdbcInfo(String key) {
        this.map.get(key);
    }

    public int size() {
        return this.map.size();
    }

    public void close() {

        Iterator<String> key = map.keySet().iterator();
        JDBCConnectInfo info = null;

        while (key.hasNext()) {
            info = map.get(key);
            if (info != null) {
                info.close();
            }
        }
    }
}
