package az.apple_corporation.auth.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.SerializationCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class CacheConfig {
    @Bean
    @Profile("default")
    public RedissonClient redissonSingleClient() {
        Config config = new Config();
        config.setCodec(new SerializationCodec())
                .useSingleServer()
                .setAddress("redis://my-release-redis-master.default.svc.cluster.local:6379")
                .setUsername("default")
                .setPassword("Qjjjwg9xdi");
        return Redisson.create(config);
    }

    @Bean
    @Profile("dev")
    public RedissonClient redissonSingleClientDev() {
        Config config = new Config();
        config.setCodec(new SerializationCodec())
                .useSingleServer()
                .setAddress("redis://localhost:6379");
        return Redisson.create(config);
    }
}