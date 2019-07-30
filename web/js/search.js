/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function createElement(autori) {

    var new_author = $("<a id='choose' onclick='chooseAuthor()'>").html(autori.nome + ", " + autori.cognome + " (" + autori.id + ")");

    return $("<li>").append(new_author);

}

function chooseAuthor() {
    return document.getElementById('author').value = $('#choose').text();
}

function stateSuccess(data) { //Ho ricevuto una risposta HTTP con stato positivo
    //Quindi data è la risposta (array di json) che ho costruito nel JSP

    var autoriDiv = $("#add_autori");

    $(autoriDiv).empty();

    for (var instance in data) {
        $(autoriDiv).append(createElement(data[instance]));
    }

}

function stateFailure(data, state) {
    console.log(state);
}

$(document).ready(function () { //Quando è pronto il DOM

    $("#author").keyup(function (event) { //Quando viene scritto qualcosa nella textbox

        $.ajax({
            url: "suggest.json",
            data: {cmd: "author",
                toSearch: event.target.value
            },
            type: "POST",
            dataType: 'json',
            success: function (data, state) {
                stateSuccess(data);
            },
            error: function (data, state) {
                stateFailure(data, state);
            }
        });

    });

});

