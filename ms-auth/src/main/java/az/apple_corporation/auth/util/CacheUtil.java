package az.apple_corporation.auth.util;

import az.apple_corporation.auth.model.exception.AuthException;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CacheUtil {
    private final RedissonClient redissonClient;

    public CacheUtil(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public <T> T getBucket(String cacheKey) {
        RBucket<T> bucket = redissonClient.getBucket(cacheKey);
        if (bucket == null) {
            throw new AuthException();
        }
        return bucket.get();
    }

    public <T> void saveToCache(String key, T value, Long expireTime, TimeUnit timeUnit) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        bucket.set(value);
        bucket.expire(expireTime, timeUnit);
    }
}