package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.SubTopicDTO;
import com.example.demo.dto.TopicCategoryDTO;
import com.example.demo.dto.TopicRequestDTO;
import com.example.demo.model.TopicCategory;
import com.example.demo.repository.SubTopicRepository;
import com.example.demo.repository.TopicCategoryRepository;
import com.example.demo.service.TopicService;
import java.util.stream.Collectors;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TopicController {

    private final TopicService topicService;
    private final TopicCategoryRepository topicCategoryRepository;
    private final SubTopicRepository subTopicRepository;

    public TopicController(TopicService topicService,
                           TopicCategoryRepository topicCategoryRepository,
                           SubTopicRepository subTopicRepository) {
        this.topicService = topicService;
        this.topicCategoryRepository = topicCategoryRepository;
        this.subTopicRepository = subTopicRepository;
    }

    @GetMapping("/test")
    public String testAPI() {
        return "SmartEdu backend is running..";
    }

    @PostMapping("/topics/bulk")
    public ResponseEntity<TopicCategory> addTopicWithSubtopics(@RequestBody TopicRequestDTO dto) {
        TopicCategory saved = topicService.saveTopicWithSubTopics(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/topics")
    public List<TopicCategoryDTO> getAllTopics() {
        return topicCategoryRepository.findAll().stream().map(topic -> {
            List<SubTopicDTO> subTopicDTOs = topic.getSubTopics().stream()
                    .map(st -> new SubTopicDTO(st.getId(), st.getTitle(), st.getContent()))
                    .collect(Collectors.toList());

            return new TopicCategoryDTO(topic.getId(), topic.getName(), topic.getDescription(), subTopicDTOs);
        }).collect(Collectors.toList());
    }

    @GetMapping("/subtopics/{categoryId}")
    public List<SubTopicDTO> getSubtopics(@PathVariable Long categoryId) {
        return subTopicRepository.findByCategoryId(categoryId).stream()
                .map(st -> new SubTopicDTO(st.getId(), st.getTitle(), st.getContent()))
                .collect(Collectors.toList());
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<TopicCategoryDTO> getTopicById(@PathVariable Long id) {
    Optional<TopicCategory> topic = topicCategoryRepository.findById(id);
    if (topic.isPresent()) {
        TopicCategory t = topic.get();
        List<SubTopicDTO> subtopics = t.getSubTopics().stream()
            .map(st -> new SubTopicDTO(st.getId(), st.getTitle(), st.getContent()))
            .collect(Collectors.toList());
        TopicCategoryDTO dto = new TopicCategoryDTO(t.getId(), t.getName(), t.getDescription(), subtopics);
        return ResponseEntity.ok(dto);
    } else {
        return ResponseEntity.notFound().build();
    }
}

}
