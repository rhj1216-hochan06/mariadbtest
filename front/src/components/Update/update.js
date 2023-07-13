import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function Update() {
    const [searchResults, setSearchResults] = useState([]);
    const [updatedItem, setUpdatedItem] = useState({ pid: '', pt_nm: '' });

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

    const handleUpdateItem = (pid) => {
        const itemToUpdate = searchResults.find(item => item.pid === pid);
        if (!itemToUpdate) {
            alert('입력한 pid가 목록에 없습니다.');
            return;
        }

        axios.post('http://localhost:8080/test/update', {
            pid: pid,
            pt_nm: updatedItem.pt_nm
        })
            .then(response => {
                // 업데이트 후 목록을 갱신하기 위해 검색을 실행
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
            <h2>아이템 업데이트</h2>
            <input
                type="text"
                placeholder="pid"
                value={updatedItem.pid}
                onChange={(e) => setUpdatedItem({ ...updatedItem, pid: e.target.value })}
            />
            <input
                type="text"
                placeholder="pt_nm"
                value={updatedItem.pt_nm}
                onChange={(e) => setUpdatedItem({ ...updatedItem, pt_nm: e.target.value })}
            />
            <button onClick={() => handleUpdateItem(updatedItem.pid)}>업데이트</button>
            <ul>
                {searchResults.map((item) => (
                    <li key={item.pid}>
                        <span>pid: {item.pid}, pt_nm: {item.pt_nm}</span>

                    </li>
                ))}
            </ul>
            <br />
            <Link to="/">Main 페이지로 이동</Link><br />
        </div>
    );
}