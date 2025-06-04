package com.crio.coderhack.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crio.coderhack.Dto.UpdateScoreRequest;
import com.crio.coderhack.Dto.UserDto;
import com.crio.coderhack.Entities.Badges;
import com.crio.coderhack.Entities.User;
import com.crio.coderhack.Mappers.UserMapper;
import com.crio.coderhack.Repository.UserRespository;

import jakarta.validation.Valid;
@Service
public class UserService {
  @Autowired
    UserRespository userRepository;
     public User createUser(UserDto userDto)
    {
        UserMapper userMapper=new UserMapper();
        User user=userMapper.toEntity(userDto);
        return userRepository.save(user);
    }

     public Optional<User> getUser(String userId) {
        // TODO Auto-generated method stub

        return userRepository.findById(userId);
     }

     public Optional<User> updateUserScore(String userId, UpdateScoreRequest request) {
      Optional<User>optional=userRepository.findById(userId);
        // TODO Auto-generated method stub
        if(optional.isEmpty())
        {
         return Optional.empty();
        }
      User user=optional.get();
        user.setScore(request.getScore());

    // Optional: badge logic
    if (user.getScore() >= 1 && request.getScore()<30 && !user.getBadges().contains(Badges.CODE_NINJA)) {
        user.getBadges().add(Badges.CODE_NINJA);
    }
    if (user.getScore() >= 30 && request.getScore()<60 && !user.getBadges().contains(Badges.CODE_CHAMP)) {
        user.getBadges().add(Badges.CODE_CHAMP);
    }
    if (user.getScore() >= 60 && request.getScore()<=100 && !user.getBadges().contains(Badges.CODE_MASTER)) {
        user.getBadges().add(Badges.CODE_MASTER);
    }
    
    userRepository.save(user);
    return Optional.of(user);
   }

     public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        List<User>users=userRepository.findAll();
       users.sort(Comparator.comparing(User::getScore));
       return users;
     }

     public void deleteUser(String userId) {
        // TODO Auto-generated method stub
        userRepository.deleteById(userId);
     }
}
