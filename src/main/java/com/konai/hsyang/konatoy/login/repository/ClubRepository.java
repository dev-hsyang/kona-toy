package com.konai.hsyang.konatoy.login.repository;

import com.konai.hsyang.konatoy.login.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    @Override
    Optional<Club> findById(Long aLong);
}
