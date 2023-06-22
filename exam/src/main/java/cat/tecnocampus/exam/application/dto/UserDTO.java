package cat.tecnocampus.exam.application.dto;

import cat.tecnocampus.exam.domain.User;

public class UserDTO {
    private String id;
    private String name;
    private String surname;

    public UserDTO(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
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
