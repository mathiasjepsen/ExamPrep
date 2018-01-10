import React, { Component } from 'react';
import CountryTable from "./CountryTable";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            countries: [],
            labels: []
        }
    }

    componentDidMount() {
        const facade = this.props.countryFacade
        facade.setLabelObserver(this.labelUpdater)
        facade.setCountriesObserver(this.countryUpdater)
        facade.getDataContinuously(5000)
    }

    componentWillUnmount() {
        this.props.facade.stopIntervalFetching() 
    }

    countryUpdater = (data) => {
        this.setState({
            countries: data
        })
    }

    labelUpdater = (data) => {
        this.setState({
            labels: data
        })
    }

    render() {
        return (
            <div>
                <div className="App-header">
                    <h2>React, State, Fetch and Mobx</h2>
                </div>
                <div className="App-intro">
                    <p>Your initial task is to fetch data from the server (see exercise for how to start it),
           and create a table below, with these data</p>
                    <CountryTable
                        countries={this.state.countries}
                        labels={this.state.labels} />
                </div>
            </div>
        );
    }
}

export default App;
