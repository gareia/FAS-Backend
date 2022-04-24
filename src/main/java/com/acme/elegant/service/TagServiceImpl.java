package com.acme.elegant.service;

import com.acme.elegant.exception.ResourceNotFoundException;
import com.acme.elegant.model.Tag;
import com.acme.elegant.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagById(Long tagId) {
        return tagRepository.findById(tagId)
                .orElseThrow(()->new ResourceNotFoundException("Tag", "Id", tagId));
    }

    @Override
    public Page<Tag> getAllTags(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public Tag updateTag(Long tagId, Tag tagRequest) {
        Tag tag = getTagById(tagId);
        tag.setName(tagRequest.getName());
        return tagRepository.save(tag);
    }

    @Override
    public ResponseEntity<?> deleteTag(Long tagId) {
        Tag tag = getTagById(tagId);
        tagRepository.delete(tag);
        return ResponseEntity.ok().build();
    }
}
