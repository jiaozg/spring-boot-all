package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiaozhiguang on 2017/10/21.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);
    Long deleteById(Long id);

}
