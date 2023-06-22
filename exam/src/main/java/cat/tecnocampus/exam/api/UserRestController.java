package cat.tecnocampus.exam.api;

import cat.tecnocampus.exam.application.UserController;
import cat.tecnocampus.exam.application.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private UserController userController;

    public UserRestController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping()
    public List<UserDTO> getAllUsers(){
        return this.userController.getAllUsers();
    }

    @GetMapping("/{userID}")
    public UserDTO getUser(@PathVariable String userID){
        return this.userController.getUser(userID);
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return this.userController.createUser(userDTO);
    }
    @DeleteMapping("/{userID}")
    public void deleteUser(@PathVariable String userID){
        this.userController.deleteUser(userID);
    }
}
