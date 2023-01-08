package com.jpa.test.dao;

import com.jpa.test.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findByName(String name);
    public List<User> findByCity(String city);
    public List<User> findByNameAndCity(String name, String city);
    public List<User> findByNameStartingWith(String prefix);
    public List<User> findByNameEndingWith(String suffix);
    public List<User> findByNameContaining(String words);
    public List<User> findByNameLike(String likePattern);
    public List<User> findByAgeGreaterThan(int age);
    public List<User> findByAgeLessThan(int age);
    public List<User> findByAgeGreaterThanEqual(int age);
    public List<User> findByAgeIn(Collection<Integer> ages);

//    JPQL QUERY
    @Query("SELECT u FROM User u")
    public List<User> getAllUser();
    @Query("SELECT u FROM User u WHERE u.name = :name AND u.city = :city")
    public List<User> getUserByName(@Param("name") String name, @Param("city") String city);

//    NATIVE QUERY
    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getUsers();
}
