package cat.tecnocampus.exam.application;

import cat.tecnocampus.exam.application.dto.UserDTO;
import cat.tecnocampus.exam.domain.User;
import cat.tecnocampus.exam.persistance.UserRepository;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
   private UserRepository userRepository;

   public UserController(UserRepository userRepository) {
       this.userRepository = userRepository;
   }

   public UserDTO createUser(String name, String surname) {
       User user = new User(name, surname);
       this.userRepository.save(user);
       return new UserDTO(user);
   }

   public UserDTO createUser(UserDTO userdto) {
       User user = new User(userdto);
       this.userRepository.save(user);
       return new UserDTO(user);
   }

   public List<UserDTO> getAllUsers() {
       return this.userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
   }

   public UserDTO updateUser(String idUser, UserDTO userDTO) {
       User user = this.userRepository.findById(idUser).get();
       user.update(userDTO);
       this.userRepository.save(user);
       return new UserDTO(user);
   }
    public void deleteUser(String id){
        this.userRepository.deleteById(id);
    }
    public UserDTO getUser(String id) {
        User user = this.userRepository.findById(id).get();
        return new UserDTO(user);
    }
}
