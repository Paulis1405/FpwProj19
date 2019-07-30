
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            <c:forEach items="${articoli}" var="articolo">
                                <tr>
                                    <td> ${articolo.getDataString()} </td>
                                    <td> ${articolo.getTitolo()}</td>
                                    <td> ${articolo.getStato()}</td>
                                    <td> <c:if test="${articolo.getStato()== 'Aperto'}" >
                                         <input id="canc" type="image" src="img/elimina.png"/>
                                         <input id="mod" type="image" src="img/modifica.png" onclick="location.href='scriviArticolo.html?pid=${articolo.getId()}'" />
                                        </c:if>
                                        <c:if test="${articolo.getStato()== 'Da Valutare'}" >
                                            <input id="canc" type="image" src="img/elimina.png"/>
                                        </c:if>
                                </tr>
                            </c:forEach>
                        </table>
                    <br>
                    <input id="new_art" name="new_art" type="button" value="NUOVO ARTICOLO" onclick="document.location.href='scriviArticolo.html?new_art=true'">
                </main>
            </div>
        </div>
    </body>
</html>
