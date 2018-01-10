import React, { Component } from 'react';
import '../App.css'
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom"
import AllUsers from './AllUsers'
import Details from './Details'
import Welcome from './Welcome'

const App = (props) => {
    const users = props.users
    return (
        <div>
            <Router>
                <Switch>
                    <Route exact path="/" component={Welcome} />
                    <Route path="/all" render={(props) => {
                        return (
                            <AllUsers
                                {...props}
                                users={users}
                            />
                        )
                    }} />
                    <Route path="/details/:index" render={(props) => {
                        return (
                            <Details
                                {...props}
                                users={users}
                            />
                        )
                    }} />
                </Switch>
            </Router>
        </div>
    )
}

export default App
