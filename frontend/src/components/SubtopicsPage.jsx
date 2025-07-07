import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';

const SubtopicsPage = () => {
  const { id } = useParams();
  const [topicName, setTopicName] = useState('');
  const [subtopics, setSubtopics] = useState([]);

  useEffect(() => {
    axios.get(`/api/topics/${id}`)
      .then(res => setTopicName(res.data.name))
      .catch(err => console.error(err));

    axios.get(`/api/subtopics/${id}`)
      .then(res => setSubtopics(res.data))
      .catch(err => console.error(err));
  }, [id]);

  return (
    <div className="flex flex-col md:flex-row gap-6 bg-[#0f172a] text-white min-h-screen p-6">
      
      {/* Sidebar */}
      <div className="md:w-1/3 w-full">
        <h2 className="text-3xl font-bold mb-4">{topicName}</h2>
        <ul className="space-y-3">
          {subtopics.map((sub, index) => (
            <li key={index} className="bg-slate-800 p-3 rounded-lg hover:bg-slate-700 transition">
              {sub.title}
            </li>
          ))}
        </ul>
      </div>

      {/* Content Area */}
      <div className="md:w-2/3 w-full bg-slate-900 p-6 rounded-xl shadow-lg">
        <h3 className="text-2xl font-semibold mb-2">Content Area</h3>
        <p className="text-gray-300">Click a subtopic (coming soon: display subtopic content here or integrate Judge0).</p>
      </div>
    </div>
  );
};

export default SubtopicsPage;
