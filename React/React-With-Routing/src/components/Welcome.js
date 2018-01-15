import React from 'react'
import {Link} from 'react-router-dom'

const Welcome = () => {
    return (
        <div>
            <h2>Welcome to the site</h2>
            <Link to="/all">Go to all users</Link>
        </div>
    )
}

export default Welcome