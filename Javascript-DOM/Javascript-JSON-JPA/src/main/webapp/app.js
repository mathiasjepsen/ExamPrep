var fetchedPersons = [];

var submitHandler = function (e) {
    let amount = document.getElementById("amount").value;
    let region = "&region=" + document.getElementById("region").value;
    let gender = "&gender=" + document.getElementById("gender").value;

    if (gender === "&gender=both") {
        gender = "";
    }
    if (region === "&region=All") {
        region = "";
    }

    var promise = fetch("http://uinames.com/api/?amount=" + amount + region + gender);
    promise.then(function (response) {
        if (response.status >= 400) {
            document.getElementById("warning").className += "alert alert-danger";
            document.getElementById("warning").innerHTML = "<strong>Error!</strong> You need to enter less than 400 in the amount field!";
        }
        return response.json();
    }).then(function (persons) {
        let mappedPersons = persons.map(function (person) {
            fetchedPersons.unshift({name: person.name, surname: person.surname, gender: person.gender});
            return "<tr><td>" + person.name + "</td>" +
                    "<td>" + person.surname + "</td>" +
                    "<td>" + person.gender + "</td></tr>";
        });
        document.getElementById("tblbody").innerHTML = mappedPersons;
    });
};

var createSQL = function () {
    var mappedPersons = fetchedPersons.map(function (person) {
        return "INSERT INTO PERSON (name, surname, gender) VALUES ('" + person.name + "', '" + person.surname + "', '" + person.gender + "')";
    }).join(";\n");
    mappedPersons += ";";
    document.getElementById("sql").value = mappedPersons;
};

document.getElementById("btnsend").addEventListener("click", submitHandler);
document.getElementById("btnsql").addEventListener("click", createSQL);