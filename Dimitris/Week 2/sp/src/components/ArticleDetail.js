import React, { Component } from 'react';
import Image from './Image'

const ArticleDetail = (props) => {
    this.facade = props.facade
    return (
        <div>
            <Detail
                {...props}
                facade={this.facade}
            />
        </div>
    )

}

const Detail = (props) => {
    let article = props.facade.articles.filter((article) => {
        return article.id === props.match.params.id
    })
    
    return (
        <div>
            {article &&
                <div>
                    <h1>{article.title}</h1>
                    <h2><a href={article.url}>Click here to go to the article</a></h2>
                    <Image
                        {...props}
                        articles={article}
                    />
                </div>
            }
        </div>
    )
}

export default ArticleDetail