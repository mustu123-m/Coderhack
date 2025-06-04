package com.crio.coderhack.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crio.coderhack.Dto.UpdateScoreRequest;
import com.crio.coderhack.Dto.UserDto;
import com.crio.coderhack.Entities.User;
import com.crio.coderhack.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
   @PostMapping
   ResponseEntity<User> createUser(@RequestBody UserDto user)
   {
    return ResponseEntity.ok().body(userService.createUser(user));
   }
   @GetMapping("/{userId}")
    ResponseEntity<User>getUser(@PathVariable String userId)
    {
        Optional<User>optional=userService.getUser(userId);
        if(optional.isEmpty())
        {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
             
    }
    @PutMapping("/{userId}")
public ResponseEntity<User> updateUserScore(@PathVariable String userId,
                                         @Valid @RequestBody UpdateScoreRequest request) {
    Optional<User> optionalUser = userService.updateUserScore(userId,request);

    if (optionalUser.isEmpty()) {
        return ResponseEntity.notFound().build(); // 404 Not Found
    }

    User user = optionalUser.get();
   
    return ResponseEntity.ok(user); // 200 OK
}
@GetMapping
public ResponseEntity<List<User>>getAllUsers(){
    List<User>user=userService.getAllUsers();
    return ResponseEntity.ok().body(user);
}
@DeleteMapping("/{userId}")
public ResponseEntity<Void> deleteUser(@PathVariable String userId)
{
    Optional<User>optional=userService.getUser(userId);
    if(optional.isEmpty())
    {
        return ResponseEntity.notFound().build();
    }
    userService.deleteUser(userId);
    return ResponseEntity.noContent().build();
}
    
}

