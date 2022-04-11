package az.apple_corporation.auth.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
public class AuthUserListener {
    private static AuthUserHistoryRepository authUserHistoryRepository;

    @Autowired
    public void init(AuthUserHistoryRepository authUserHistoryRepository) {
        AuthUserListener.authUserHistoryRepository = authUserHistoryRepository;
    }

    @PostPersist
    @PostUpdate
    public void saveUserChanges(AuthUserEntity entity) {
        authUserHistoryRepository.save(entity.toAuthUserHistoryEntity());
    }
}