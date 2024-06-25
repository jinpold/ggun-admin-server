package com.james.api.chat.adapter.in.web.dto;


import com.james.api.post.adapter.in.web.response.PostSearchResponse;
import com.james.api.post.application.port.in.command.PostSearchByTitleQuery;
import com.james.api.post.application.port.out.LoadPostPort;
import com.james.api.post.domain.Post;
import com.james.api.post.adapter.in.web.response.CommentResponse;
import com.james.api.post.adapter.in.web.response.PostResponse;
import com.james.api.post.application.port.in.PostLoadUseCase;
import com.james.api.post.application.port.in.command.PostQuery;
import com.james.api.chatcommon.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@UseCase
@Transactional
class LoadPostService implements PostLoadUseCase {
    private final LoadPostPort loadPostPort;

    @Override
    public PostResponse getPostById(PostQuery postQuery) {
        Post post = loadPostPort.loadById(postQuery.postId());
        return PostResponse.builder()
                .postId(post.getId().value())
                .title(post.getTitle())
                .content(post.getContent())
                .comment(post.getComments().stream()
                        .map((comment) -> CommentResponse.builder()
                                .commentId(comment.getId().value())
                                .content(comment.getContent())
                                .postId(comment.getPostId().value())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public List<PostSearchResponse> searchPostListByTitle(PostSearchByTitleQuery postSearchByTitleQuery) {
        List<Post> postList = loadPostPort.searchByTitle(postSearchByTitleQuery.title());
        return postList.stream().map(post->PostSearchResponse.builder()
                .postId(post.getId().value())
                .title(post.getTitle())
                .content(post.getContent())
                .build())
                .collect(Collectors.toList());
    }
}
