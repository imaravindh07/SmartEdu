import React, { useEffect, useState } from 'react';
import axios from 'axios';

const SubtopicsList = ({ categoryId }) => {
  const [subtopics, setSubtopics] = useState([]);
  const [selectedContent, setSelectedContent] = useState(null);

  useEffect(() => {
    axios.get(`/api/subtopics/${categoryId}`)
      .then(res => setSubtopics(res.data))
      .catch(err => console.error(err));
  }, [categoryId]);

  return (
    <div>
      <h3>Subtopics</h3>
      <ul>
        {subtopics.map(st => (
          <li key={st.id} onClick={() => setSelectedContent(st.content)}>
            {st.title}
          </li>
        ))}
      </ul>

      {selectedContent && (
        <div style={{ marginTop: '1rem', padding: '1rem', border: '1px solid #ccc' }}>
          <h4>Content</h4>
          <p>{selectedContent}</p>
        </div>
      )}
    </div>
  );
};

export default SubtopicsList;
