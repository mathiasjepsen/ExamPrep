class countryFacade {
    constructor() {
        this._labels = []
        this._countries = []
        this.getCountries()
        this.getLabels()
    }

    getLabels = (cached) => {
        if (cached) {
            if (this._labelHandler) {
                this._labelHandler(this._labels)
            }
        }

        fetch('http://localhost:3333/labels')
            .then((res) => {
                return res.json();
            }).then((data) => {
                if (this._labelHandler) {
                    this._labelHandler(data);
                };
            });
    }

    getCountries = (cached) => {
        if (cached) {
            if (this._countriesHandler) {
                this._countriesHandler(this._countries)
            }
        }

        fetch('http://localhost:3333/countries')
            .then((res) => {
                return res.json();
            }).then((data) => {
                if (this._countriesHandler) {
                    this._countriesHandler(data);
                };
            });
    }

    setLabelObserver = (handler) => {
        this._labelHandler = handler
    }

    setCountriesObserver = (handler) => {
        this._countriesHandler = handler
    }

    getDataContinuously = (time) => {
        this.timerId = setInterval(this.getCountries, time);
    }
    
    stopIntervalFetching = () => {
        if (this.timerId) {
            clearInterval(this.timerId);
        }
    }
}

export default new countryFacade();