package com.example.demo.dto;
import java.util.*;
public class TopicCategoryDTO {
    public Long id;
    public String name;
    public String description;
    public List<SubTopicDTO> subTopics;

    public TopicCategoryDTO(Long id, String name, String description, List<SubTopicDTO> subTopics) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.subTopics = subTopics;
    }
}
