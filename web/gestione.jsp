<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gestione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessio Paulis">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina riservata organizzatori">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="SU">
            <jsp:include page="header.jsp"></jsp:include>
                <div class="col-9 col-s-9">
                    <nav>
                        <ul>
                            <li><a href="gestione.html">Gestione</a></li>
                            <li></li>
                            <li></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div id="GIU">
                <div class="col-3 col-s-3">
                    <aside>
                        Bentornato ${organizzatore.getNome()} ${organizzatore.getCognome()}!

                        <br>
                        <input name="logout" id="new_art" type="button" onclick="document.location.href = 'logout.html?logout=true';" value="LOGOUT">
                        <br><br>
                    </aside>
                </div>
                <div class="col-9 col-s-9">
                <main class="art">
                    <h2>I MIEI ARTICOLI</h2>
                    <br>
                        <table class="col-8 col-s-8">
                            <tr>
                                <th>Data</th>
                                <th>Titolo</th>
                                <th>#Valutazioni</th>
                                <th>Decisione</th>
                            </tr>
                            <c:forEach items="${articoli}" var="articolo">
                                <tr>
                                    <td> ${articolo.getDataString()} </td>
                                    <td> ${articolo.getTitolo()}</td>
                                    <td> 
                                        <c:if test="${articolo.getStato()== 'Accettato'}" >
                                            3/3
                                        </c:if>
                                        <c:if test="${articolo.getStato()== 'Rifiutato'}" >
                                            3/3
                                        </c:if>
                                        <c:if test="${articolo.getStato()== 'Da Valutare'}" >
                                            <a>Scegli Valutatori</a>
                                        </c:if>
                                        <c:if test="${articolo.getStato()== 'Aperto'}" >
                                            <a>Scegli Valutatori</a>
                                        </c:if>
                                    </td>
                                    <td> <c:if test="${articolo.getStato()== 'Aperto'}" >
                                            Attesa Valutazioni
                                        </c:if>
                                        <c:if test="${articolo.getStato()== 'Da Valutare'}" >
                                            <a href="valutazioni.jsp">Decidi</a>
                                        </c:if>
                                        <c:if test="${articolo.getStato()== 'Rifiutato'}" >
                                            Respinto
                                        </c:if>
                                        <c:if test="${articolo.getStato()== 'Accettato'}" >
                                            Accettato
                                        </c:if>
                                </tr>
                            </c:forEach>
                        </table>
                    <br>
                    <input id="new_art" type="button" onclick="document.location.href='scriviArticolo.html';" value="NUOVO ARTICOLO">
                </main>
            </div>
            </div>
    </body>
</html>
