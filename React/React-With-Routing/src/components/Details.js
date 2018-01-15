import React from 'react'

const Details = (props) => {
    const user = props.users[props.match.params.index]
    return (
        <div className="row">
            <div className="col-xs-10 col-xs-offset-1" style={{ paddingTop: 20 }}>
                <div className="col-xs-6">
                    <table>
                        <tbody>
                            <tr>
                                <td>{user.gender}</td>
                            </tr>
                            <tr>
                                <td>{user.first}</td>
                            </tr>
                            <tr>
                                <td>{user.last}</td>
                            </tr>
                        </tbody>
                    </table>
                    <hr />
                    <table>
                        <tbody>
                            <tr>
                                <td>{user.street}</td>
                            </tr>
                            <tr>
                                <td>{user.city}</td>
                            </tr>
                            <tr>
                                <td>{user.zip}</td>
                            </tr>
                        </tbody>
                    </table>
                    <hr />
                    <table>
                        <tbody>
                            <tr>
                                <td>{user.phone}</td>
                            </tr>
                            <tr>
                                <td>{user.cell}</td>
                            </tr>
                            <tr>
                                <td>{user.email}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div className="col-xs-6">
                    <img src={user.picture.large} style={{ width: 384, height: 384 }} />
                </div>
            </div>
        </div>
    )
}

// const Details = (props) => {
//     const user = props.users[props.match.params.index]
//     const tableRows = []

//     for (var property in user) {
//         if (user.hasOwnProperty(property)) {
//             if (typeof user[property] !== 'object') {
//                 tableRows.push(user[property])
//             } 
//         }
//     }

//     return (
//         <div className="row">
//             <div className="col-xs-6">
//                 <table>
//                     <thead>
//                     </thead>
//                     <tbody>
//                         {tableRows.map((property, index) => {
//                             return (
//                                 <tr key={index}>
//                                     <td>{property}</td>
//                                 </tr>
//                             )
//                         })}
//                     </tbody>
//                 </table>
//             </div>
//             <div className="col-xs-6">
//                 <img src={user.picture.large} />
//             </div>
//         </div>
//     )
// }

export default Details