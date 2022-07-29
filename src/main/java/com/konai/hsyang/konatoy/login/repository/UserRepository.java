package com.konai.hsyang.konatoy.login.repository;

import com.konai.hsyang.konatoy.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameContaining(String name);
    User findByNicknameContaining(String nickname);
}
