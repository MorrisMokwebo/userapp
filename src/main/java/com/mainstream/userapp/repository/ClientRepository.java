package com.mainstream.userapp.repository;

import com.mainstream.userapp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByIdNumber(String idNumber);

    Client findByFirstName(String firstName);

    Client findByMobileNumber(String mobileNumber);

    //Custom Query
    @Query(value = "select * from users where first_name like %:keyword% or mobile_number like %:keyword% or identity_number like %:keyword%",nativeQuery = true)
    List<Client> findByKeyword(@Param("keyword") String keyword);

}
