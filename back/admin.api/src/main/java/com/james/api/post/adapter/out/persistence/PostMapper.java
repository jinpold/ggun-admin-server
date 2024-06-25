package com.james.api.post.adapter.out.persistence;


import com.james.api.chatcommon.annotation.Mapper;
import com.james.api.post.domain.Post;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@Mapper
@RequiredArgsConstructor
class PostMapper {
    private final CommentMapper commentMapper;
    public PostJpaEntity domainToEntity(Post post){
        return PostJpaEntity.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
    public Post entityToDomain(PostJpaEntity postJpaEntity) {
        return Post.builder()
                .id(new Post.PostId(postJpaEntity.getPostId()))
                .title(postJpaEntity.getTitle())
                .content(postJpaEntity.getContent())
                .comments(postJpaEntity.getComments().stream()
                        .map(commentMapper::entityToDomain)
                        .collect(Collectors.toList()))
                .build();
    }
}
