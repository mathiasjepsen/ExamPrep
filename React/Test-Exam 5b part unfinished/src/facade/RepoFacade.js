import React from 'react';

class RepoFacade extends React.Component {

    constructor() {
        super()
        this._repos = ""
    }

    setReposObserver = (handler) => {
        this._reposHandler = handler
    }

    setRepoObserver = (handler) => {
        this._repoHandler = handler
    }

    fetchRepositories = () => {
        fetch("https://api.github.com/orgs/Cphdat3sem2017f/repos")
            .then((res) => {
                return res.json()
            })
            .then((data) => {
                this._repos = data
                if (this._reposHandler) {
                    this._reposHandler(data)
                }
            })
    }

    // fetchRepositories = () => {
    //     fetch("http://localhost:8080/textexamendpoint/api/repos", {
    //         method: 'GET',
    //         headers: {
    //             'Access-Control-Allow-Origin': '*'
    //         },

    //     })
    //         .then((res) => {
    //             return res.json()
    //         })
    //         .then((data) => {
    //             this._repos = data
    //             if (this._reposHandler) {
    //                 this._reposHandler(data)
    //             }
    //         })
    // }

    getRepositoryFromName = (name) => {
        const foundRepo = this._repos.filter((repo) => {
            return repo.name === name
        })[0]
        
        if (this._repoHandler) {
            this._repoHandler(foundRepo)
        }
    }

}    

let repoFacade = new RepoFacade()
export default repoFacade