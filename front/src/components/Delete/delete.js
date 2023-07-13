import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function Delete() {
    const [searchResults, setSearchResults] = useState([]);
    const [deleteInput, setDeleteInput] = useState('');

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

    const handleDeleteItem = (pid) => {
        const shouldDelete = window.confirm('정말로 삭제하시겠습니까?');
        if (!shouldDelete) {
            return; // 삭제 취소
        }

        axios.post('http://localhost:8080/test/delete', { pid: pid })
            .then(response => {
                // 삭제 후 목록을 갱신하기 위해 검색을 실행
                handleSearch();
            })
            .catch(error => {
                console.error(error);
            });
    };

    const handleDeleteInput = () => {
        const itemToDelete = searchResults.find(item => item.pid === deleteInput);
        if (!itemToDelete) {
            alert('입력한 pid가 목록에 없습니다.');
            return;
        }

        handleDeleteItem(deleteInput);
    };

    useEffect(() => {
        handleSearch();
    }, []);

    return (
        <div>
            <br />
            <h2>아이템 삭제</h2>
            <input
                type="text"
                placeholder="pid 입력"
                value={deleteInput}
                onChange={(e) => setDeleteInput(e.target.value)}
            />
            <button onClick={handleDeleteInput}>삭제</button>
            <ul>
                {searchResults.map((item) => (
                    <li key={item.pid}>
                        <span>pid: {item.pid}, pt_nm: {item.pt_nm}</span>
                        <button onClick={() => handleDeleteItem(item.pid)}>삭제</button>
                    </li>
                ))}
            </ul>
            <br />
            <Link to="/">Main 페이지로 이동</Link><br />
        </div>
    );
}