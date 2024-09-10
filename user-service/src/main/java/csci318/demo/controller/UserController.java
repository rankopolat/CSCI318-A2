package csci318.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csci318.demo.model.Users.Customer;
import csci318.demo.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer){
        return userService.registerCustomer(customer);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        return userService.getCustomers();
    }

    @PostMapping("/users/login")
    public ResponseEntity<?> loginCustomer(@RequestBody Customer user){
        return userService.loginCustomer(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id){
        return userService.getCustomer(id);
    }

    @GetMapping("/hi")
    public String hi(){
        return "hellow there testing";
    }


    
}
