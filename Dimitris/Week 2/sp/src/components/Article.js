import React, { Component } from 'react';
import { Link, Route } from 'react-router-dom'
import ArticleDetail from './ArticleDetail'

export default class Article extends Component {
    constructor(props) {
        super(props)
        this.state = {
            articles: []
        }
    }

    componentDidMount() {
        this.props.facade.setObserver(this.articleUpdater)
        this.props.facade.getArticles()
    }

    articleUpdater = (articles) => {
        this.setState({
            articles: articles
        })
    }

    render() {
        this.facade = this.props.facade
        return (
            <div className="row">
                <div className="col-xs-6">
                    <ArticlesTable articles={this.state.articles} />
                </div>
                <div className="col-xs-6">
                    <Route path="/articles/:id" render={(props) => {
                        return (
                            <ArticleDetail
                                {...props}
                                facade={this.facade}
                            />
                        )
                    }} />
                </div>
            </div>
        )
    }
}

const ArticlesTable = (props) => {
    return (
        <div>
            <table className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Author</th>
                        <th>Title</th>
                    </tr>
                </thead>
                {props.articles.length > 0 &&
                    <tbody>
                        {props.articles.map((article) => {
                            return <tr key={article.id}>
                                <td>{article.id}</td>
                                <td>{article.author}</td>
                                <td><Link to={`/articles/${article.id}`}>{article.title}</Link></td>
                            </tr>
                        })}
                    </tbody>
                }
            </table>
        </div>
    )
}