package com.genetics.qmslogApi.repository;

import com.genetics.qmslogApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
