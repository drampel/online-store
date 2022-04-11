package az.apple_corporation.user.util;

import az.apple_corporation.user.dao.UserEntity;
import az.apple_corporation.user.dao.UserRepository;
import az.apple_corporation.user.model.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserUtil {
    private final UserRepository userRepository;

    public UserUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity userExist(Long id) {
        Optional<UserEntity> entityOptional = userRepository.findById(id);
        if (entityOptional.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        return entityOptional.get();
    }
}