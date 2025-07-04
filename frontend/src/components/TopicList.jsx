import React, { useEffect, useState } from 'react';
import axios from 'axios';
import SubtopicsList from './SubtopicsList';

const TopicsList = () => {
  const [topics, setTopics] = useState([]);
  const [selectedTopicId, setSelectedTopicId] = useState(null);

    useEffect(() => {
  axios.get('/api/topics')
    .then(res => {
      console.log('Topics API response:', res.data);
      setTopics(res.data);
    })
    .catch(err => console.error(err));
}, []);


  return (
    <div>
      <h2>Topics</h2>
      <ul>
        {topics.map(topic => (
          <li key={topic.id} onClick={() => setSelectedTopicId(topic.id)}>
            {topic.name}
          </li>
        ))}
      </ul>

      {selectedTopicId && <SubtopicsList categoryId={selectedTopicId} />}
    </div>
  );
};

export default TopicsList;
