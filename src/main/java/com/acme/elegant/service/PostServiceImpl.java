package com.acme.elegant.service;

import com.acme.elegant.exception.ResourceNotFoundException;
import com.acme.elegant.model.Post;
import com.acme.elegant.repository.PostRepository;
import com.acme.elegant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post createPost(Long userId, Post post) {

        return userRepository.findById(userId).map(user ->{
                post.setUser(user);
                return postRepository.save(post);
        }).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));

    }

    @Override
    public Post updatePost(Long postId, Post postRequest) {
        Post post = getPostById(postId);
        post.setDescription(postRequest.getDescription());
        post.setSellable(postRequest.isSellable());
        post.setPrice(postRequest.getPrice());
        post.setStock(postRequest.getStock());
        post.setSize(postRequest.getSize());
        return postRepository.save(post);
    }

    @Override
    public ResponseEntity<?> deletePost(Long postId) {
        Post post = getPostById(postId);
        postRepository.delete(post);
        return ResponseEntity.ok().build();
    }

    @Override
    public Page<Post> getAllPosts(Pageable pageable) {

        return postRepository.findAll(pageable);
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post","Id",postId));
    }

    @Override
    public Page<Post> getPostsBySellable(boolean sellable, Pageable pageable) {

        return postRepository.findBySellable(sellable, pageable);
    }

    @Override
    public Page<Post> getPostsByUserId(Long userId, Pageable pageable) {

        return postRepository.findByUserId(userId, pageable);
    }

    @Override
    public Page<Post> getPostsByUserLikedId(Long userLikedId, Pageable pageable) {

        return userRepository.findById(userLikedId).map(user->{
            List<Post> posts = user.getPostsLiked();
            return new PageImpl<>(posts, pageable, posts.size());
        }).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userLikedId));
    }
}
