package com.james.api.post.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

interface SpringDataPostRepository extends JpaRepository<PostJpaEntity, Long> {
    @Query("SELECT p FROM PostJpaEntity p LEFT JOIN FETCH p.comments c WHERE p.postId = :id AND c.parent IS NULL")
    Optional<PostJpaEntity> findByIdWithComments(Long id);

    @Query("SELECT p FROM PostJpaEntity p WHERE p.title LIKE concat('%', :title, '%')")
    List<PostJpaEntity> searchByTitle(@Param("title") String title);
}
