package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.ResultDto;
import uz.team.dto.UserDto;
import uz.team.entity.User;
import uz.team.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResultDto add(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @GetMapping
    public List<User> get(){
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Integer id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id){
        return userService.getOneUser(id);
    }

}
