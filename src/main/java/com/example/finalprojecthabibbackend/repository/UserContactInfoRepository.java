package com.example.finalprojecthabibbackend.repository;

import com.example.finalprojecthabibbackend.model.entity.UserContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserContactInfoRepository extends JpaRepository<UserContactInfo, Long> {

    @Query(value = """
            SELECT e
            FROM  UserContactInfo e
            WHERE e.user.id=:userId
            """)
    List<UserContactInfo> findUserContactByUserId(@Param("userId") Long userId);

}
