package com.ngoc.usercrud.repositories;

import com.ngoc.usercrud.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Integer> {
}
