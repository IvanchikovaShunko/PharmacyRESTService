package by.fpmi.pharmacy.controllers;

import by.fpmi.pharmacy.model.User;
import by.fpmi.pharmacy.model.UserDetail;
import by.fpmi.pharmacy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRestController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public User userGet(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        return user;
    }

    @RequestMapping(value = "/user/find", method = RequestMethod.GET)
    public ResponseEntity<User> userFind(@RequestParam(value = "login") String login,
                                         @RequestParam(value = "password") String password) {
        User user = userService.find(login, password);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/auth", method = RequestMethod.POST)
    public ResponseEntity<User> userAuth(@RequestParam(value = "login") String login,
                                         @RequestParam(value = "password") String password) {
        User user = userService.find(login, password);
        if (user != null)
            return new ResponseEntity<User>(user, HttpStatus.OK);
        else
            return new ResponseEntity<User>(user, HttpStatus.FORBIDDEN);

    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResponseEntity<User> userAdd(@RequestParam(value = "login") String login,
                                            @RequestParam(value = "password") String password,
                                            @RequestParam(value = "name") String name,
                                            @RequestParam(value = "age") int age,
                                            @RequestParam(value = "gender") String gender,
                                            @RequestParam(value = "about") String about,
                                            @RequestParam(value = "home_address") String address,
                                            @RequestParam(value = "email") String email,
                                            @RequestParam(value = "telephone") String telephone) {
        UserDetail userDetail = new UserDetail(name, age, gender, about, address, email, telephone);
        User user = new User(login, password, userDetail);
        User savedUser  = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
