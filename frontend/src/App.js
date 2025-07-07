// src/App.jsx
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import TopicList from './components/TopicList'; 
import Home from './components/Home'; 
import SubtopicsPage from './components/SubtopicsPage'; 


function App() {
  return (
    <Router>
      <Navbar />
      <div className="p-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/topics" element={<TopicList />} />
          <Route path="/about" element={<div>About SmartEdu</div>} />
          <Route path="/topics/:id" element={<SubtopicsPage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
