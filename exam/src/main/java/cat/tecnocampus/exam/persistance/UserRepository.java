package cat.tecnocampus.exam.persistance;

import cat.tecnocampus.exam.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
