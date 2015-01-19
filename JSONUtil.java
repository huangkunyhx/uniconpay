import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kevin Huang
 * @date 2014年10月30日 上午11:04:28
 */

public class JSONUtil {
    private static Logger logger = LoggerFactory.getLogger(JSONUtil.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转为JSON字符串
     */
    public static String toJson(Object object) {
        String str = null;
        try {
            str = objectMapper.writer().writeValueAsString(object);
        } catch (IOException e) {
            logger.info("对象转为JSON字符串失败" + e.getMessage(), e);
        }
        return str;
    }

    /**
     * JSON字符串转为对象
     * @param valueType 目标对象的类型
     * @param json JSON字符串
     * @return object 目标对象(转换失败返回 null)
     */
    public static <T> T toObject(String json, Class<T> valueType) {
        T object = null;
        try {
            object = objectMapper.reader(valueType).readValue(json);
        } catch (IOException e) {
            logger.info("JSON字符串转为对象" + e.getMessage());
        }
        return object;
    }
}
