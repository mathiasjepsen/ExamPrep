import React from 'react'
import {
    BrowserRouter as Router,
    Route,
    Link,
    NavLink,
    Switch,
} from 'react-router-dom'
import repoFacade from './facade/RepoFacade'

const Home = () => (
    <div>
        <h2>Welcome to Home</h2>
    </div>
)

const About = () => (
    <div>
        <h2>About</h2>
    </div>
)

class Repository extends React.Component {

    constructor(props) {
        super(props);
        this.state = { repo: {} }
    }

    componentWillMount() {
        repoFacade.setRepoObserver(this.repoUpdater)
        repoFacade.getRepositoryFromName(this.props.match.params.name)
    }

    repoUpdater = (repo) => {
        this.setState({
            repo
        })
    }

    render() {
        const repo = this.state.repo
        return (<div>
            <h2>ID: {repo.id}</h2>
            <h2>Name: {repo.name}</h2>
            <h2>Full Name: {repo.full_name}</h2>
            <h2>Size: {repo.size}</h2>
        </div>
        )
    }
}

class Repositories extends React.Component {

    constructor(props) {
        super(props);
        this.state = { repos: [] }
    }

    componentWillMount() {
        repoFacade.setReposObserver(this.repoUpdater)        
        repoFacade.fetchRepositories()
    }

    repoUpdater = (repos) => {
        this.setState({
            repos
        })
    }
    
    render() {
        const match = this.props.match;

        return (
            <div>
                <h2>Repositories</h2>
                <p>Complete this example to fecth the git-repositories (via link provided in the exercise),
          and populate the ul below with the name for each repository.</p>
                <ul>
                    {this.state.repos.map((repo, index) => {
                        return <li key={index}>{repo.name} - <Link to={`/repositories/${repo.name}`}>Details</Link></li>
                    })}
                </ul>
            </div>
        )
    }
}

const App = () => (
    <Router>
        <div>
            <div>
                <ul className="header">
                    <li><NavLink exact to="/">Home</NavLink></li>
                    <li><NavLink to="/repositories">Reposistories</NavLink></li>
                    <li><NavLink to="/about">About</NavLink></li>
                </ul>
            </div>
            <Switch>
                <Route exact path="/" component={Home} />
                <Route exact path="/repositories" component={Repositories} />
                <Route path="/about" component={About} />
                <Route path="/repositories/:name" component={Repository} />
            </Switch>
        </div>
    </Router>
)
export default App