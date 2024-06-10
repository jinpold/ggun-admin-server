package com.james.api.article.repository;
import com.james.api.article.model.Article;
import com.james.api.article.model.ArticleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    // JPQL Default 방식
    @Query("select a "
            + "from articles a where a.board.id = :boardId order by a.id desc")
    List<Article> getArticleByBoardId(@Param("boardId") Long boardId);

}
