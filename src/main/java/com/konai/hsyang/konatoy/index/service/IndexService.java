package com.konai.hsyang.konatoy.index.service;

import com.konai.hsyang.konatoy.login.repository.UserRepository;
import com.konai.hsyang.konatoy.posts.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IndexService {

    private final PostsRepository postsRepository;
    private final UserRepository userRepository;
}
