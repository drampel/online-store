package az.apple_corporation.auth.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthUserRepository extends CrudRepository<AuthUserEntity, Long> {
    Optional<AuthUserEntity> findByEmail(String email);
}