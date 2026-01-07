package homelab.ftrack.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisKeyValueUtility implements KeyValueUtility {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Override
  public String getValue(String key) throws Exception {
    return stringRedisTemplate.opsForValue().get(key);
  }

  @Override
  public void setValue(String key, String value) throws Exception {
    stringRedisTemplate.opsForValue().set(key, value);
  }

  @Override
  public void removeValue(String key) throws Exception {
    stringRedisTemplate.delete(key);
  }
}
