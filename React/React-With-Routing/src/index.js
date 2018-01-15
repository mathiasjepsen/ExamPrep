import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './components/App.js';
import data from './data/data.json'

ReactDOM.render(<App users={data.users}/>, document.getElementById('root'));
