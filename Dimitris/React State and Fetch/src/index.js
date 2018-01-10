import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import facade from "./countryFacade";

 ReactDOM.render(
    <App countryFacade={facade} />,document.getElementById('root')
  );


