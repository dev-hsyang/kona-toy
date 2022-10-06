package com.konai.hsyang.konatoy.posts.service;

import com.konai.hsyang.konatoy.TestAdd;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PostsServiceTest {

    @Test
    public void testAdd() {
        int x = 3;
        int y = 5;

        assertEquals(8, TestAdd.add(3, 5));
    }
}
