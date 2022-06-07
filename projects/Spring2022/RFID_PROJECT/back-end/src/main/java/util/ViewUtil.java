package util;

import java.util.HashMap;
import java.util.Map;

public class ViewUtil {

    private static Map<String, Object> baseModel;

    public static final Integer port = Integer.parseInt(PropertiesUtil.get("port"));

    public static Map<String, Object> getBaseModel() {
        baseModel = new HashMap<>();
        baseModel.put("port", port);
        return baseModel;
    }
}
