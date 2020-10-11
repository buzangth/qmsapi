package com.genetics.qmslogApi.repository;

import com.genetics.qmslogApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
    User getById(Integer id);
}
