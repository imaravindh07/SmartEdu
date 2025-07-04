package com.example.demo.service;

import com.example.demo.dto.TopicRequestDTO;
import com.example.demo.model.TopicCategory;
import com.example.demo.model.SubTopic;
import com.example.demo.repository.TopicCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicCategoryRepository topicCategoryRepository;

    public TopicCategory saveTopicWithSubTopics(TopicRequestDTO dto) {
        TopicCategory topic = new TopicCategory();
        topic.setName(dto.getName());
        topic.setDescription(dto.getDescription());

        List<SubTopic> subTopicList = new ArrayList<>();

        for (TopicRequestDTO.SubTopicDTO subDto : dto.getSubTopics()) {
            SubTopic sub = new SubTopic();
            sub.setTitle(subDto.getTitle());
            sub.setContent(subDto.getContent());
            sub.setCategory(topic);  
            subTopicList.add(sub);
        }

        topic.setSubTopics(subTopicList);

        return topicCategoryRepository.save(topic); 
    }
}
