package az.apple_corporation.user.service;

import az.apple_corporation.user.dao.UserEntity;
import az.apple_corporation.user.dao.UserRepository;
import az.apple_corporation.user.mapper.UserMapper;
import az.apple_corporation.user.model.UserDto;
import az.apple_corporation.user.util.UserUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static az.apple_corporation.user.model.Status.DELETED;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserUtil userUtil;

    public UserServiceImpl(UserRepository userRepository, UserUtil userUtil) {
        this.userRepository = userRepository;
        this.userUtil = userUtil;
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(entity -> users.add(UserMapper.toDto(entity)));
        return users;
    }

    @Override
    public UserDto getUser(Long id) {
        UserEntity entity = userUtil.userExist(id);
        return UserMapper.toDto(entity);
    }

    @Override
    public UserDto addUser(UserDto dto) {
        UserEntity entity = userRepository.save(UserMapper.toEntity(dto));
        return UserMapper.toDto(entity);
    }

    @Override
    public UserDto updateUser(UserDto dto) {
        UserEntity entity = userUtil.userExist(dto.getId());
        UserMapper.toEntity(dto, entity);
        entity = userRepository.save(entity);
        return UserMapper.toDto(entity);
    }

    @Override
    public UserDto deleteUser(Long id) {
        UserEntity entity = userUtil.userExist(id);
        entity.setStatus(DELETED);
        userRepository.save(entity);
        return UserMapper.toDto(entity);
    }
}