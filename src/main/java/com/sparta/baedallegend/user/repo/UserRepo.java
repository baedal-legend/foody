package com.sparta.baedallegend.user.repo;

import com.sparta.baedallegend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	boolean existsByNickname(String nickname);

}
