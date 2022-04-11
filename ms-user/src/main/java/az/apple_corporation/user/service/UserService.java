package az.apple_corporation.user.service;

import az.apple_corporation.user.model.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();

    UserDto getUser(Long id);

    UserDto addUser(UserDto dto);

    UserDto updateUser(UserDto dto);

    UserDto deleteUser(Long id);
}