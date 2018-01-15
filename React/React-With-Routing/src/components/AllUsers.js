import React from 'react'
import { Link } from 'react-router-dom'

const AllUsers = (props) => {
    return (
        <div className="box" style={{ paddingTop: 20}}>
            <div className="col-xs-10 col-xs-offset-1">
                <table className="table">
                    <thead>
                        <tr>
                            <td></td>
                            <td>Name</td>
                            <td>Details</td>
                        </tr>
                    </thead>
                    <tbody>
                        {props.users.map((user, index) => {
                            return <tr key={index}>
                                <td><img src={user.picture.thumbnail} className="img-thumbnail"/></td>
                                <td>{`${user.first} ${user.last}`}</td>
                                <td><Link to={`/details/${index}`}>Details</Link></td>
                            </tr>
                        })}
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default AllUsers