package utility;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangzhengyue on 8/15/16.
 */
public class GeneralJsonBuilder {
    public static String error(String info) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", info);
        map.put("success", false);
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    public static String success() {
        return "{\"success\":true}";
    }

    public static String success(boolean success) {
        if (success) {
            return "{\"success\":true}";
        } else {
            return "{\"success\":false}";
        }
    }
}
