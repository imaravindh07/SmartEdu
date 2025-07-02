package com.example.demo.model;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class TopicCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<SubTopic> subTopics;

    public void setId(Long  id)
    {
        this.id=id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }
    public Long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public List<SubTopic> getSubTopics() {
    return subTopics;
    }
    public void setSubTopics(List<SubTopic> subTopics) 
    {
        this.subTopics = subTopics;
    }


    
}
