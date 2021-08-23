package com.cognizant.truyum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByName(String name);
	
	@Query("SELECT u FROM User u WHERE u.id = :userId")
	User getMenuItems(@Param("userId") long userId);

	@Query("SELECT SUM(mi.price) FROM Cart c JOIN MenuItem mi on c.menuItem=mi.id WHERE c.user.id = :userId")
	double getCartTotal(@Param("userId") long userId);
}
