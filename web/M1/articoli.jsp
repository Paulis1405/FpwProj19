<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Articoli</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessio Paulis">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Lista articoli">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="SU">
            <jsp:include page="header.jsp"></jsp:include>
            <jsp:include page="nav.jsp"></jsp:include>
        </div>
        <div id="GIU">
        <jsp:include page="aside.jsp"></jsp:include>
            <div class="col-9 col-s-9">
                <main class="art">
                    <h2>I MIEI ARTICOLI</h2>
                    <br>
                        <table class="col-8 col-s-8">
                            <tr>
                                <th>Data</th>
                                <th>Titolo</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <tr>
                                <td>04/04/2019  </td>
                                <td>L'espressività del css  </td>
                                <td>Aperto  </td>
                                <td><input id="canc" type="image" src="img/elimina.png"/>
                                    <input id="mod" type="image" src="img/modifica.png" /></td>
                            </tr>
                            <tr>
                                <td>27/03/2019  </td>
                                <td>Il posizionamento degli elementi    </td>
                                <td>Valutazione </td>
                                <td><input id="canc" type="image" src="img/elimina.png"/></td>
                            </tr>
                            <tr>
                                <td>25/03/2019  </td>
                                <td>Il layout fisso </td>
                                <td>Accettato </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>19/03/2019  </td>
                                <td>Le proprietà di una table </td>
                                <td>Rifiutato </td>
                                <td></td>
                            </tr>
                        </table>
                    <br>
                    <input id="new_art" type="button" onclick="document.location.href='scriviArticolo.html';" value="NUOVO ARTICOLO">
                </main>
            </div>
        </div>
    </body>
</html>
