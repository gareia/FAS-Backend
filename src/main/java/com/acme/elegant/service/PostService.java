package com.acme.elegant.service;

import com.acme.elegant.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PostService {

    //funcionalidades para el cliente
    Post createPost(Long userId, Post post);
    Post updatePost(Long postId, Post postRequest);
    ResponseEntity<?> deletePost(Long postId);

    //obtener todos los posts para el feed
    Page<Post> getAllPosts(Pageable pageable);

    //obtener solo 1 post al hacer click
    Post getPostById(Long postId);


    //obtener solo los posts de tienda (sellable=true)
    Page<Post> getSellablePosts(Pageable pageable);

    //obtener solo los posts de galeria (sellable=false)
    Page<Post> getNonSellablePosts(Pageable pageable);

    //obtener solo los posts de 1 persona
    Page<Post> getPostsByUserId(Long userId, Pageable pageable);

}
