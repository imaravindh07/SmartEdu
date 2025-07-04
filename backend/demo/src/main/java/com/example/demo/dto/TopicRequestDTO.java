package com.example.demo.dto;

import java.util.List;

public class TopicRequestDTO {

    private String name;
    private String description;
    private List<SubTopicDTO> subTopics;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<SubTopicDTO> getSubTopics() { return subTopics; }
    public void setSubTopics(List<SubTopicDTO> subTopics) { this.subTopics = subTopics; }

    public static class SubTopicDTO {
        private String title;
        private String content;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }

    }
}
