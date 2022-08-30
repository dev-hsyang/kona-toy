package com.konai.hsyang.konatoy.login.service;

import com.konai.hsyang.konatoy.login.domain.Club;
import com.konai.hsyang.konatoy.login.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public Optional<Club> findByClubId(Long id){
        return clubRepository.findById(id);
    }
}
