package com.channel.service.user.repository;

import com.channel.service.user.entity.User;
import com.channel.service.user.entity.UserPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, UserPK> {

    @Query(value = "SELECT * FROM Users u WHERE u.userid = ?1", nativeQuery = true)
    User findByUserId(String userid);

}
