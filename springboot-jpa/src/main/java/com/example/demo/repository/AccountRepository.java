package com.example.demo.repository;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiaozhiguang on 2017/8/21.
 */
public interface AccountRepository  extends JpaRepository<Account, Integer> {

}
