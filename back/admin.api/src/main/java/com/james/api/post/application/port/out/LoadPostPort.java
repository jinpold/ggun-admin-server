package com.james.api.post.application.port.out;

import com.james.api.post.domain.Post;

import java.util.List;

public interface LoadPostPort {
    Post loadById(Long id);
    List<Post> searchByTitle(String title);
}
