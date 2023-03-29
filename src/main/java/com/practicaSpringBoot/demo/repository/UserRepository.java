package com.practicaSpringBoot.demo.repository;

import com.practicaSpringBoot.demo.dto.UserDto;
import com.practicaSpringBoot.demo.entity.User;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //JPQL
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUseremail(String email);

    @Query("SELECT u FROM User u WHERE u.name like %?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);
    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthdayBetween(LocalDate dateOne, LocalDate dateTwo);
    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContaining(String name);

    @Query("select  new com.practicaSpringBoot.demo.dto.UserDto(u.id, u.name, u.birthday) from User u" +
            " where u.birthday=:parameterFecha and u.email =:parameterEmail")
    Optional<UserDto> getAllByBirthdayAAndEmail(@Param("parameterFecha") LocalDate date,
                                                @Param( "parameterEmail" ) String email);
 }

