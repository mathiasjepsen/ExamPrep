import React, { Component } from 'react';
import { Switch, Route, Link, BrowserRouter } from 'react-router-dom'
import Header from './Header'
import Main from './Main'

export default function RouterX(props) {
    return (
        <div>
            <BrowserRouter>
                <App facade={props.facade} />
            </BrowserRouter>
        </div>
    )
}

const App = (props) => {
    return (
        <div>
            <Header />
            <Main facade={props.facade} />
        </div>
    )
}