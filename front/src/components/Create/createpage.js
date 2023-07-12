import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function Create() {
    const [searchResults, setSearchResults] = useState([]);
    const [newItem, setNewItem] = useState({ pid: '', pt_nm: '' });

    const handleSearch = () => {
        axios.post('http://localhost:8080/test/selectSearch', {
            pid: null,
            pt_nm: null
        })
            .then(response => {
                setSearchResults(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    };
    const handleAddItem = () => {
        axios.post('http://localhost:8080/test/insert', newItem)
            .then(response => {
                // 추가 후 목록을 갱신하기 위해 검색을 실행
                handleSearch();
            })
            .catch(error => {
                console.error(error);
            });
    };

    useEffect(() => {
        handleSearch();
    }, []);

    return (
        <div>
            <br />
            <h2>새로운 아이템 추가</h2>
            <input
                type="text"
                placeholder="pid"
                value={newItem.pid}
                onChange={(e) => setNewItem({ ...newItem, pid: e.target.value })}
            />
            <input
                type="text"
                placeholder="pt_nm"
                value={newItem.pt_nm}
                onChange={(e) => setNewItem({ ...newItem, pt_nm: e.target.value })}
            />
            <button onClick={handleAddItem}>추가</button>
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
