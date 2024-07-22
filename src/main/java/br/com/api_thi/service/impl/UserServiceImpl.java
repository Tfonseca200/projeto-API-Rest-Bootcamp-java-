package br.com.api_thi.service.impl;

import br.com.api_thi.domain.model.User;
import br.com.api_thi.domain.repository.UserRepository;
import br.com.api_thi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if(  userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("this account number already exists");
        }
        return userRepository.save(user);
    }
}
