package com.james.api.post.adapter.out.persistence;


import com.james.api.chatcommon.annotation.PersistenceAdapter;
import com.james.api.post.application.port.out.LoadPostPort;
import com.james.api.post.domain.Post;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
class PostLoadPersistenceAdapter implements LoadPostPort {
    private final SpringDataPostRepository springDataPostRepository;
    private final PostMapper postMapper;
    @Override
    public Post loadById(Long id) {
        PostJpaEntity postJpaEntity = springDataPostRepository.findByIdWithComments(id)
                .orElseThrow(RuntimeException::new);
        return postMapper.entityToDomain(postJpaEntity);
    }
    @Override
    public List<Post> searchByTitle(String title){
        List<PostJpaEntity> postJpaEntityList = springDataPostRepository.searchByTitle(title);
        return postJpaEntityList.stream()
                .map((entity)-> Post.builder()
                        .id(new Post.PostId(entity.getPostId()))
                        .title(entity.getTitle())
                        .content(entity.getContent())
                        .build())
                .collect(Collectors.toList());
    }
}
