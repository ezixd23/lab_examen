package cat.tecnocampus.exam.domain;

import cat.tecnocampus.exam.application.dto.UserDTO;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "users")
@NoArgsConstructor
public class User {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
    }

    public void update(UserDTO userDTO) {
        this.name = userDTO.getName() == null ? this.name : userDTO.getName();
        this.surname = userDTO.getSurname() == null ? this.surname : userDTO.getSurname();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }
}
