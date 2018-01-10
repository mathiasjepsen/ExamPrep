var toggledId;

var clickHandler = function(e) {
    var promise = fetch('http://restcountries.eu/rest/v1/alpha?codes=' + e.target.id);
    promise.then(function (response) {
        return response.json();
    }).then(function(country) {
        document.getElementById("country").innerText = country[0].name;
        document.getElementById("population").innerText = country[0].population;
        document.getElementById("area").innerText = country[0].area;
        document.getElementById("borders").innerText = country[0].borders.toString();
        document.getElementById(e.target.id).style.fill = "red";
        if (toggledId !== null) {
            document.getElementById(toggledId).style.fill = "#c0c0c0";
        }
        toggledId = e.target.id;
    });
};

document.getElementById("svg2").addEventListener("click", clickHandler);



