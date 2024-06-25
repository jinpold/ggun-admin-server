package com.james.api.post.application.port.in;

import com.james.api.post.application.port.in.command.PostCreateCommand;

public interface PostCreateUseCase {
    boolean createPost(PostCreateCommand postCreateCommand);
}
