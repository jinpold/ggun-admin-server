package com.james.api.post.adapter.out.persistence;


import com.james.api.chatcommon.annotation.PersistenceAdapter;
import com.james.api.post.application.port.out.LoadCommentPort;
import com.james.api.post.domain.Comment;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
class CommentLoadPersistenceAdapter implements LoadCommentPort {
    private final SpringDataCommentRepository springDataCommentRepository;
    private final CommentMapper commentMapper;
    @Override
    public Comment loadById(Long id) {
        CommentJpaEntity commentJpaEntity = springDataCommentRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return commentMapper.entityToDomainWithReplies(commentJpaEntity);
    }
}
