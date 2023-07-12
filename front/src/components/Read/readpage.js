import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function Read() {
    const [searchQuery, setSearchQuery] = useState('');
    const [searchResults, setSearchResults] = useState([]);

    const handleSearch = () => {
        axios.post('http://localhost:8080/test/selectSearch', {
            pid: searchQuery,
            pt_nm: searchQuery
        })
            .then(response => {
                setSearchResults(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    };

    const handleKeyPress = (event) => {
        if (event.key === 'Enter') {
            handleSearch();
        }
    };

    useEffect(() => {
        handleSearch();
    }, []);

    return (
        <div>
            <h1>Read 페이지</h1>
            <input
                type="text"
                placeholder="검색 단어"
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
                onKeyPress={handleKeyPress}
            />
            <button onClick={handleSearch}>검색</button>
            <ul>
                {searchResults.map((item) => (
                    <li key={item.pid}>
                        <span>pid: {item.pid}, pt_nm: {item.pt_nm}</span>
                    </li>
                ))}
            </ul>
        </div>
    );
}
