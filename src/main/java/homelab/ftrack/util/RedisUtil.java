package homelab.ftrack.util;

public interface RedisUtil {
  Object getRedisValue(String key);

  void setRedisValue(String key, String value);
}
