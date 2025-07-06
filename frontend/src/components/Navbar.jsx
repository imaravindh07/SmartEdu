import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="bg-[#0f172a] border-b border-gray-700">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-4 flex justify-between items-center">
        <Link to="/" className="text-transparent bg-clip-text bg-gradient-to-r from-blue-400 via-purple-500 to-pink-500 font-bold text-2xl">
          SmartEdu
        </Link>
        <div className="space-x-6 text-base font-medium">
          <Link to="/" className="hover:text-orange-400 transition">
            Home
          </Link>
          <Link to="/topics" className="hover:text-orange-400 transition">
            Topics
          </Link>
          <Link to="/about" className="hover:text-orange-400 transition">
            About
          </Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
