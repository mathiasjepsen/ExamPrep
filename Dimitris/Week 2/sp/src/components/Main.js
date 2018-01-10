import React from 'react'
import { Link, Switch, Route } from 'react-router-dom'
import Article from './Article'
import ArticleDetail from './ArticleDetail'
import About from './About'
import Image from './Image'

const Main = (props) => {
    this.facade = props.facade
    return (
        <main>
            <Switch>
                <Route path='/articles' render={(props) => {
                    return (
                        <Article
                            {...props}
                            facade={this.facade}
                        />
                    )
                }} />
                <Route path='/images' render={(props) => {
                    return (
                        <Image
                            {...props}
                            articles={this.facade.articles}
                        />
                    )
                }} />
                {/*<Route path='/about' component={About} />*/}
            </Switch>
        </main>
    )
}

export default Main