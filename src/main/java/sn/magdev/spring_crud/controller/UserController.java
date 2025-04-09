package sn.magdev.spring_crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.magdev.spring_crud.entity.User;
import sn.magdev.spring_crud.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //pour ajouter un utilisateur
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {

        userService.addUser(user);
        return "user added successfully ";
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id) {

    return userService.getUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser( @PathVariable Integer id,@RequestBody User user) {

         userService.updateUser(id, user);
         return ResponseEntity.noContent().build();
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
@DeleteMapping("/delete/{id}")
public String deleteUser(@PathVariable Integer id) {
    userService.deleteUser(id);
    return "User deleted successfully ";
}

}
