package com.ak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.entity.CreateNewUserEntity;

public interface ICreateNewUserRepository extends JpaRepository<CreateNewUserEntity, Integer> {

}
