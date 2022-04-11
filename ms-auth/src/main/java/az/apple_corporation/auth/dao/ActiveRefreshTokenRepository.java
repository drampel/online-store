package az.apple_corporation.auth.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ActiveRefreshTokenRepository extends CrudRepository<ActiveRefreshTokenEntity, Long> {
    Optional<ActiveRefreshTokenEntity> findByUuid(String uuid);
}