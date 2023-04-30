package com.SapPortal.repository;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SapPortal.dto.AdminUserDto;
import com.SapPortal.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
  Boolean existsByEmail(String email);
  @Transactional
  @Modifying
  @Query(value = "UPDATE users u SET u.password =:password WHERE u.email = :email",nativeQuery = true)
  void updatepasswordwithemail(@Param("email") String email,@Param("password")String password);
  
  @Transactional
  @Modifying
  @Query(nativeQuery = true)
  List<AdminUserDto> findAllAdminUser(@Param("status") String status);
  Optional<User> findById(Long id);
}
