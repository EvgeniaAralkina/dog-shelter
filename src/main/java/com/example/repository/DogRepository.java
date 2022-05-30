package com.example.repository;

import com.example.Dog;
import com.example.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findAllByGender(String gender);

    List<Dog> findAllBySizeAndGender(String size, String gender);

    List<Dog> findAllBySize(String size);

    List<Dog> findAllByName(String name);

    Dog findByName(String name);



    /*@Query("update Customer c set c.name = :name WHERE c.id = :customerId")
    void setCustomerName(@Param("customerId") Long id, @Param("name") String name);

     */
}
