
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Valutazione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessio Paulis">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Lista autori e valutazioni articoli">
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
                <main>
                    <div id="main_val">
                        <h1>IL TAG BR</h1>
                        <br>
                        <div id="autori_val">
                            <h2>Autori</h2>
                            <br>
                            <ul>
                                <li>Autore 1</li>
                                <li>Autore 2</li>
                                <li>Autore 3</li>
                            </ul>
                        </div>
                        <br>
                        <img title="main image" alt="Il tag br" src="img/html-br-tag.webp"/>
                        <br>
                        <div id="autori_val">
                        Categorie: HTML, CSS, Servlet, JSP, Java Script, AJAX
                        <br>
                        Data: 5 Marzo 2019
                        </div>
                        <br>
                        <p>Il tag br sta per break line e serve per andare a capo nel bel mezzo di un testo. 
                            Come è facile notare infatti, anche se andiamo a capo all’interno dell’editor,
                            il testo nel browser non va a capo se non alla fine dello spazio disponibile per il suo contenitore.</p>
                        <br>
                    </div>
                    <div id="val">
                        <form>
                            <p class="voto">Voto :  
                                <label for="uno">1</label>
                                <input type="radio" name="voto" id="uno" value="uno">
                                <label for="due">2</label>
                                <input type="radio" name="voto" id="due" value="due">
                                <label for="tre">3</label>
                                <input type="radio" name="voto" id="tre" value="tre">
                                <label for="quattro">4</label>
                                <input type="radio" name="voto" id="quattro" value="quattro">
                                <label for="cinque">5</label>
                                <input type="radio" name="voto" id="cinque" value="cinque">
                            </p>
                            <br>
                            <label for="c_aut">Commento degli autori</label>
                            <br>
                            <textarea rows="1" cols="40" name="c_aut" id="c_aut"></textarea>
                            <br>
                            <label for="c_org">Commento degli organizzatori</label>
                            <br>
                            <textarea rows="1" cols="40" name="c_org" id="c_org"></textarea>
                            <br>
                            <input type="submit" value="Invia"/>
                        </form>
                    </div>
                </main>
            </div>
        </div>
    </body>
</html>
