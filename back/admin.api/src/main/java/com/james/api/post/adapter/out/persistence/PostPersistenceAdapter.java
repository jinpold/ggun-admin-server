package com.james.api.post.adapter.out.persistence;


import com.james.api.chatcommon.annotation.PersistenceAdapter;
import com.james.api.post.application.port.out.CreatePostPort;
import com.james.api.post.domain.Post;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class PostPersistenceAdapter implements CreatePostPort {
    private final SpringDataPostRepository springDataPostRepository;
    private final PostMapper postMapper;
    @Override
    public boolean createPost(Post post) {
        PostJpaEntity postJpaEntity = postMapper.domainToEntity(post);
        springDataPostRepository.save(postJpaEntity);
        return true;
    }
}
