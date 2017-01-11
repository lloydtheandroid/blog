package com.codeup.repository;

import com.codeup.models.CommentRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRatingRepository extends JpaRepository<CommentRating, Long> {

    @Query("SELECT r FROM CommentRating r WHERE r.comment.id = :commentId AND r.user.id = :userId")
    CommentRating findUserRating(@Param("commentId") Long commentId, @Param("userId") Long userId);
}
