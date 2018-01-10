import React from 'react';
import ReactDOM from 'react-dom';
import RouterX from './components/RouterX'
import dataFacade from './dataFacade'

ReactDOM.render(<RouterX facade={dataFacade}/>, document.getElementById('root'));
