import React from 'react'

const Image = (props) => {
    const article = props.articles.filter((article) => {
        return article.id === props.match.params.id
    })[0]

    return (
        <div>
        {article &&
            <img src={article.img} style={{ width: 384, height: 256 }} />
        }
        </div>
    )
}

export default Image