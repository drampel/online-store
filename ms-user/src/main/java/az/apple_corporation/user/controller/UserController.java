package az.apple_corporation.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import az.apple_corporation.user.model.UserDto;
import az.apple_corporation.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;
@CrossOrigin
@RestController
@RequestMapping("/users")
@Api(value = "User resource endpoints.")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("Endpoint to get all users.")
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), FOUND);
    }

    @ApiOperation("Endpoint to get a user by ID.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), FOUND);
    }

    @ApiOperation("Endpoint for user adding.")
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto dto) {
        return new ResponseEntity<>(userService.addUser(dto), CREATED);
    }

    @ApiOperation("Endpoint for updating user data.")
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto dto) {
        dto.setId(id);
        return new ResponseEntity<>(userService.updateUser(dto), OK);
    }

    @ApiOperation("Endpoint for deleting user by ID.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), OK);
    }
}