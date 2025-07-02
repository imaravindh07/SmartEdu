import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
     axios.get("/api/test")
      .then(res => setMessage(res.data))
      .catch(err => setMessage("Error: " + err.message));
  }, []);

  return (
    <div style={{ padding: "2rem", fontSize: "1.5rem" }}>
      <h3>{message}</h3>
    </div>
  );
}

export default App;
