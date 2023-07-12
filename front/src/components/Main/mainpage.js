import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function Main() {
    const [time, setTime] = useState('');

    const fetchTime = () => {
        axios.get('http://localhost:8080/test/time')
            .then(response => {
                setTime(response.data);
            })
            .catch(error => {
                console.error(error);
                setTime(null);
            });
    };

    useEffect(() => {
        fetchTime();
    }, []);

    return (
        <div>
            <h1>Main 페이지</h1>
            {time ? (
                <p>현재 시간: {time}</p>
            ) : (
                <p>연결되지 않았습니다</p>
            )}
            <button onClick={fetchTime}>
                시간 갱신
            </button>
            <br /><br /><br />
            <Link to="/create">Create 페이지로 이동</Link><br />
            <Link to="/read">Read 페이지로 이동</Link><br />
            <Link to="/update">Update 페이지로 이동</Link><br />
            <Link to="/delete">Delete 페이지로 이동</Link>

        </div>
    );
}
