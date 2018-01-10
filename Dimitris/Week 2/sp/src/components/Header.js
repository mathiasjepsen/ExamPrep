import React from 'react'
import { NavLink } from 'react-router-dom'
import './../App.css'

export default function Header() {
    return (
        <div>
            <ul className="header">
                <li><NavLink to="/images">Images</NavLink></li>
                <li><NavLink to="/articles">Articles</NavLink></li>
                <li><NavLink to="/about">About Us</NavLink></li>
            </ul>
        </div>
    )
}