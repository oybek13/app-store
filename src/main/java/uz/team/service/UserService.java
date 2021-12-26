package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.UserRepository;
import uz.team.dao.WarehouseRepository;
import uz.team.dto.ResultDto;
import uz.team.dto.UserDto;
import uz.team.entity.User;
import uz.team.entity.Warehouse;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public ResultDto add(UserDto userDto){
        User user = new User();
        user.setCode(userDto.getCode());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(userDto.getWarehouseId());
        if (!optionalWarehouse.isPresent()){
            return new ResultDto("Sorry this warehouse doesn't exist!", false);
        }
        Warehouse warehouse = optionalWarehouse.get();

        return null;
    }

}
