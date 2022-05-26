package util;

import java.util.HashMap;
import java.util.Map;

public class ViewUtil {

    private static Map<String, Object> baseModel;

    public static Map<String, Object> getBaseModel() {
        baseModel = new HashMap<>();
        return baseModel;
    }
}
