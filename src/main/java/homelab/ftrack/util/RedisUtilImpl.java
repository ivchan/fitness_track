package homelab.ftrack.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisUtilImpl implements RedisUtil {
  private final StringRedisTemplate redisTemplate;

  public RedisUtilImpl(StringRedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  public Object getRedisValue(String key) {
    return redisTemplate.opsForValue().get(key);
  }

  @Override
  public void setRedisValue(String key, String value) {
    redisTemplate.opsForValue().set(key, value);

  }

}
