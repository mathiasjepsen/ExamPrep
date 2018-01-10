const URL = "https://gist.githubusercontent.com/Thomas-Hartmann/549240f621df3331b4af7c70b5f44746/raw/746112f28f2201a90ff1ae25982ac0b2e3c0a942/articles.json"

class DataFacade {
    constructor() {
        this._articles = []
        this.getArticles()
    }

    getArticles = (cached) => {
        if (cached) {
            return this._articles
        }
        fetch(URL)
        .then((res) => res.json())
        .then((data) => {
            this._articles = data.article
            if (this._handler) {
                this._handler(data.article)
            }
        })
    }

    get articles() {
        return this._articles
    } 

    setObserver = (handler) => {
        this._handler = handler
    }
}

export default new DataFacade()