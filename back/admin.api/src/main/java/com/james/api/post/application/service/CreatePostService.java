package com.james.api.post.application.service;
import com.james.api.chatcommon.annotation.UseCase;
import com.james.api.post.application.port.in.PostCreateUseCase;
import com.james.api.post.application.port.in.command.PostCreateCommand;
import com.james.api.post.application.port.out.CreatePostPort;
import com.james.api.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
class CreatePostService implements PostCreateUseCase {
    private final CreatePostPort createPostPort;

    @Override
    public boolean createPost(PostCreateCommand postCreateCommand) {
        Post post = Post.builder()
                .title(postCreateCommand.title())
                .content(postCreateCommand.content())
                .build();
        createPostPort.createPost(post);
        return true;
    }
}
