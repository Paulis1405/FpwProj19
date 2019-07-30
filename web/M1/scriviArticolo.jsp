<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ScriviArticolo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessio Paulis">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Scrivi un nuovo articolo">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="SU">
            <jsp:include page="header.jsp"></jsp:include>
            <jsp:include page="nav.jsp"></jsp:include>
        </div>
        <div id="GIU">
            <jsp:include page="aside.jsp"></jsp:include>
            <div class='col-9 col-s-9'>
                <main>
                    <h2 id="write_art">SCRIVI ARTICOLO</h2>
                    <form>
                        <label class="col-4 col-s-4" for="tit">Titolo </label>
                        <input class="col-8 col-s-8" type="text" name="tit" id="tit"/>
                        <br>
                        <br>
                        <label class="col-4 col-s-4" for='autori'>Autori</label>
                        <div class="col-8 col-s-8">        
                            <ul>
                                <li>Alessio Paulis</li>
                                <li>Mario Verdi</li>
                                <li><label for='autori'></label><input type="text" name="autori" id="autori"></li>
                            </ul>
                            <br>
                        </div>
                        <label class="col-4 col-s-4" for="categorie">Categorie</label>
                        <p class="col-4 col-s-4">
                            <input type="checkbox" name="categorie">
                            HTML
                            <br>
                            <input type="checkbox" name="categorie">
                            CSS
                            <br>
                            <input type="checkbox" name="categorie">
                            Servlet
                            <br><br>

                        </p>
                        <p class="col-4 col-s-4">
                            <input type="checkbox" name="categorie">
                            JSP
                            <br>
                            <input type="checkbox" name="categorie">
                            JavaScript
                            <br>
                            <input type="checkbox" name="categorie">
                            AJAX
                            <br><br>
                        </p>
                        <div class="col-12 col-s-12">
                            <label class="col-4 col-s-4" for="immagine">Immagine </label>
                            <input class="col-8 col-s-8" type="url" name="immagine" id="immagine"/>
                            <br><br>
                        </div>
                        <div class="col-12 col-s-12">
                            <label class="col-4 col-s-4" for="data">Data </label>
                            <input class="col-8 col-s-8" type="date" name="data" id="data" />
                            <br><br>
                        </div>
                        <label class="col-4 col-s-4" for="testo">Testo </label>
                        <textarea class="col-8 col-s-8" rows="4" cols="20" name="testo" id="testo"></textarea>
                        <div class="art">
                            <input id="salva" type="submit" value="Salva"/>
                        </div>
                    </form>
                </main>
            </div>
        </div>
    </body>
</html>
