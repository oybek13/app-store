package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.UserRepository;
import uz.team.dao.WarehouseRepository;
import uz.team.dto.ResultDto;
import uz.team.dto.UserDto;
import uz.team.entity.User;
import uz.team.entity.Warehouse;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public ResultDto addUser(UserDto userDto){
        User user = new User();
        user.setCode(userDto.getCode());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        Set<Warehouse> w = new HashSet<>();
        for(Integer i: userDto.getWarehouseIds()){
            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(i);
            if (!optionalWarehouse.isPresent()){
                return new ResultDto("Sorry this warehouse doesn't exist!", false);
            }
            Warehouse warehouse = optionalWarehouse.get();
            w.add(warehouse);
        }
        user.setWarehouses(w);
        userRepository.save(user);
        return new ResultDto("Successfully added!", true);
    }




}
