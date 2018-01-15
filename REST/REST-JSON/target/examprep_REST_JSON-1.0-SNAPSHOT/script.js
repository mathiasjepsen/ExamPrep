var createTable = function() {
    var promise = fetch('http://localhost:8080/examprep_REST_JSON/api/person/' + document.getElementById("n1").value + "/" + document.getElementById("n2").value);
    promise.then(function (response) {
        return response.json();
    }).then(function(persons) {
        var mappedPersons = persons.map(function(person) {
            return "<tr><td>" + person.id + "</td><td>" 
                              + person.fname + "</td><td>" 
                              + person.lname + "</td><td>" 
                              + person.age + "</td><td>" +
                   "</td></tr>";
        }).join("");
        document.getElementById("tblbody").innerHTML = mappedPersons;
    });
};

document.getElementById("btn").addEventListener("click", createTable);

