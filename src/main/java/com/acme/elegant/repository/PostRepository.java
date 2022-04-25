package com.acme.elegant.repository;

import com.acme.elegant.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    Page<Post> findByUserId(Long userId, Pageable pageable);
    Page<Post> findBySellable(boolean sellable, Pageable pageable);

}
