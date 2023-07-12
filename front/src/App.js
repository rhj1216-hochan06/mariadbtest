
import './App.css';
import React from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";


import Main from './components/Main/mainpage';
import Read from './components/Read/readpage';
import Create from './components/Create/createpage';
import Update from './components/Update/update';
import Delete from './components/Delete/delete';
function App() {
  return (
    <>
      <div>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Main />} />
            <Route path="create" element={<Create />} />
            <Route path="read" element={<Read />} />
            <Route path="update" element={<Update />} />
            <Route path="delete" element={<Delete />} />
          </Routes>
        </BrowserRouter>

      </div>
    </>
  );
}

export default App;
