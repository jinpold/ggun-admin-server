package com.james.api.post.application.port.out;

import com.james.api.post.domain.Post;

public interface CreatePostPort {
    boolean createPost(Post post);
}
