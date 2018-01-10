import React, { Component } from "react";

class CountryTable extends Component {
    constructor() {
        super();
    }

    render() {
        return (
            <table className="table">
                <LabelHeaders labels={this.props.labels} />
                <LabelBody countries={this.props.countries} />
            </table>
        );
    }
}

function LabelHeaders(props) {
    var mappedLabels = props.labels.map((label, index) =>
        <th key={index}>{label}</th>
    )

    return (
        <thead>
            <tr>
                {mappedLabels}
            </tr>
        </thead>
    )
}

function LabelBody(props) {
    var mappedCountries = props.countries.map((country, index) =>
        <tr key={index}>
            <td>{country.name}</td>
            <td>{country.capital}</td>
            <td>{country.region}</td>
            <td>{country.population}</td>
            <td>{country.area}</td>
            {country.timezones.length > 1 &&
                <td>{`${country.timezones[0]} +${country.timezones.length}`}</td>}
            {country.timezones.length <= 1 &&
                <td>{country.timezones}</td>}

            {country.borders.length > 1 &&
                <td>{`${country.borders[0]} +${country.borders.length}`}</td>}
            {country.borders.length <= 1 &&
                <td>{country.borders}</td>}

            {country.topLevelDomain.length > 1 &&
                <td>{`${country.topLevelDomain[0]} +${country.topLevelDomain.length}`}</td>}
            {country.topLevelDomain.length <= 1 &&
                <td>{country.topLevelDomain}</td>}

            {country.currencies.length > 1 &&
                <td>{`${country.currencies[0]} +${country.currencies.length}`}</td>}
            {country.currencies.length <= 1 &&
                <td>{country.currencies}</td>}

            {country.languages.length > 1 &&
                <td>{`${country.languages[0]} +${country.languages.length}`}</td>}
            {country.languages.length <= 1 &&
                <td>{country.languages}</td>}
        </tr>
    )

    return (
        <tbody>
            {mappedCountries}
        </tbody>
    )
}

export default CountryTable;