// src/components/TopicsList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const TopicList = () => {
  const [topics, setTopics] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get('/api/topics')
      .then(res => {
        setTopics(res.data);
      })
      .catch(err => console.error(err));
  }, []);

  return (
    <div className="p-4">
      <h2 className="text-2xl font-bold mb-4 text-white">Topics</h2>
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-7">
        {topics.map(topic => (
          <div
            key={topic.id}
            onClick={() => navigate(`/topics/${topic.id}`)}
            className="cursor-pointer p-4 border rounded-xl shadow hover:shadow-lg transition duration-300 bg-white"
          >
            <h3 className="text-lg font-semibold">{topic.name}</h3>
          </div>
        ))}
      </div>
    </div>
  );
};

export default TopicList;
