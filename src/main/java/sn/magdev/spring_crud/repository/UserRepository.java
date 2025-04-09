package sn.magdev.spring_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.magdev.spring_crud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
