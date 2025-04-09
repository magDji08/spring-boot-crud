package sn.magdev.spring_crud.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sn.magdev.spring_crud.entity.User;
import sn.magdev.spring_crud.repository.UserRepository;
import sn.magdev.spring_crud.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //AJOUTER UN USER
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    //LISTE DE MES USERS
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository.findById(Long.valueOf(id)).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id" + id));
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
        userRepository.findById(Long.valueOf(id)).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id" + id));

        user.setId(Long.valueOf(id));
//        userUpdate.setName(user.getName());
//        userUpdate.setAge(user.getAge());
//        userUpdate.setAddress(user.getAddress());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
//        userRepository.findById(Long.valueOf(id)).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id" + id));
        userRepository.deleteById(Long.valueOf(id));
    }


}
