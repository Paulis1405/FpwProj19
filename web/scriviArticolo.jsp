<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <script src="js/jquery.js"></script>
    </head>
    <body>
        <script src="js/search.js"></script>
        <div id="SU">
            <jsp:include page="header.jsp"></jsp:include>
            <jsp:include page="nav.jsp"></jsp:include>
            </div>
            <div id="GIU">
            <jsp:include page="aside.jsp"></jsp:include>
                <div class='col-9 col-s-9'>
                    <main>
                        <h2 id="write_art">SCRIVI ARTICOLO</h2>
                        <form action="scriviArticolo.html?pid=${pid}" method="post">
                        <label class="col-4 col-s-4" for="tit">Titolo </label>
                        <input class="col-8 col-s-8" type="text" name="tit" id="tit" value="${articolo.getTitolo()}"/>
                        <br>
                        <br>
                        <label class="col-4 col-s-4" for='autori'>Autori</label>
                        <div class="col-8 col-s-8">        
                            <ul>
                               
                                    <c:forEach items="${articolo.getAutore()}" var="autori" >
                                        <li>${autori.getNome()}, ${autori.getCognome()} (${autori.getId()}) </li>
                                        </c:forEach>                               
           
                               
                                <li><label for='author'></label><input type="text" name="author" id="author" value="">
                                    <input type="submit" name="addAuthor" id="addAuthor" value="+" onclick="scriviArticolo.html?addAuthor=true"/></li>
                                
                            </ul>
                            <ul id="add_autori">
                                
                        
                            </ul>
                            
                            <br>
                        </div>
                        <label class="col-4 col-s-4" for="categorie">Categorie</label>
                        <p class="col-4 col-s-4">
                            <input type="checkbox" name="categorie" value="HTML">
                            HTML
                            <br>
                            <input type="checkbox" name="categorie" value="CSS">
                            CSS
                            <br>
                            <input type="checkbox" name="categorie" value="Servlet">
                            Servlet
                            <br><br>

                        </p>
                        <p class="col-4 col-s-4">
                            <input type="checkbox" name="categorie" value="JSP">
                            JSP
                            <br>
                            <input type="checkbox" name="categorie" value="JavaScript">
                            JavaScript
                            <br>
                            <input type="checkbox" name="categorie" value="AJAX">
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
                            <input class="col-8 col-s-8" type="date" name="data" id="data" value="${articolo.getDataString()}" />
                            <br><br>
                        </div>
                        <label class="col-4 col-s-4" for="testo">Testo </label>
                        <textarea class="col-8 col-s-8" rows="4" cols="20" name="testo" id="testo">
                            ${articolo.getTesto()}
                        </textarea>
                        <div class="art">
                            <input type="submit" id="salva" name="salvataggio"  value="Salva"/>
                        </div>
                    </form>
                </main>
            </div>
        </div>
    </body>
</html>
