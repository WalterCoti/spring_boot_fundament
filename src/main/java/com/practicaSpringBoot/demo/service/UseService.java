package com.practicaSpringBoot.demo.service;

import com.practicaSpringBoot.demo.entity.User;
import com.practicaSpringBoot.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseService {
    private final Log LOG = LogFactory.getLog(UseService.class);
    private UserRepository userRepository;

    public UseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void saveTransactional(List<User> users){
        users.stream().peek(user -> LOG.info("Usuario Insertado: " + user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public void remove(Long id) {
        userRepository.delete(new User(id));

    }

    public User update(User newUser, Long id) {
        return userRepository.findById(id)
                .map(
                        user -> {
                                    user.setName(newUser.getName());
                                    user.setBirthday(newUser.getBirthday());
                                    user.setEmail(newUser.getEmail());
                                    return userRepository.save(user);
                        }
                ).get();
    }


}
