package com.example.demo.repository;
import com.example.demo.model.SubTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubTopicRepository extends JpaRepository<SubTopic, Long> {
    List<SubTopic> findByCategoryId(Long categoryId);
}
