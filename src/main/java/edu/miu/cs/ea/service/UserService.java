package edu.miu.cs.ea.service;

import edu.miu.cs.ea.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUserName(String userName);
}
