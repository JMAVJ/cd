package me.cd.overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import me.cd.overflow.models.Tag;
import me.cd.overflow.repositories.TagRepository;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> addTags(List<String> subjects) {
        List<Tag> newTags = new ArrayList<>();
        List<Tag> existingTags = tagRepository.findAll();
        List<String> existingSubjects = new ArrayList<>();
        for (Tag tag : existingTags) {
            existingSubjects.add(tag.getSubject());
        }
        for (String subject : subjects) {
            Tag t = new Tag(subject);
            if (!existingSubjects.contains(subject)) {
                tagRepository.save(t);
                newTags.add(t);
            } else {
                newTags.add(tagRepository.findBySubjectEquals(subject));
            }
        }
        return newTags;
    }
}
