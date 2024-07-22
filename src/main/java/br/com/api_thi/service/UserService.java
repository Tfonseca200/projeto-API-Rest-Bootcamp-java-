package br.com.api_thi.service;

import br.com.api_thi.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);


}
