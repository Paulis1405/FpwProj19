<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Profilo</title>
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
                    <main>
                        <div class="col-4 col-s-4 profilo"><img title='profilo' alt="Foto Profilo" src="img/profilo.jpg" ></div>
                        <c:if test="${autore != null}">
                        <h2 class="col-8 col-s-8" id="profilo">PROFILO</h2>
                    </c:if>
                    <c:if test="${autore == null}">
                        <h2 class="col-8 col-s-8" id="profilo">REGISTRAZIONE</h2>
                    </c:if>
                    <form>
                        <label class="col-4 col-s-4" for="name">Nome </label>
                        <input class="col-8 col-s-8" type="text" name="name" id="name" value="${autore.getNome()}"/>
                        <br><br>
                        <label class="col-4 col-s-4" for="name">Cognome </label>
                        <input class="col-8 col-s-8" type="text" name="cognome" id="cognome" value="${autore.getCognome()}"/>
                        <br><br>
                        <div class="col-12 col-s-12">
                            <label class="col-4 col-s-4" for="foto">Foto </label>
                            <input class="col-8 col-s-8" type="url" name="foto" id="foto" value="${autore.getFoto()}"/>
                            <br><br>
                        </div>
                        <div class="col-12 col-s-12">
                            <label class="col-4 col-s-4" for="email">Email </label>
                            <input class="col-8 col-s-8" type="email" name="email" id="email" value="${autore.getEmail()}"/>
                            <br><br>
                        </div>
                        <div class="col-12 col-s-12">
                            <label class="col-4 col-s-4" for="psw">Password </label>
                            <input class="col-8 col-s-8" type="password" name="psw" id="psw" value="${autore.getPassword()}"/>
                            <br><br>
                        </div>
                        <div class="col-12 col-s-12">
                            <label class="col-4 col-s-4" for="ente">Ente </label>
                            <input class="col-8 col-s-8" type="url" name="ente" id="ente"/>
                            <br><br>
                        </div>

                        <div class="art">
                            <c:if test="${autore == null}">
                                <input id="salva" type="submit" onclick="document.location.href = 'registrazione.html';" value="Registrazione"/>
                            </c:if>
                            <c:if test="${autore != null}">
                                <input id="salva" type="submit" onclick="document.location.href = 'registrazione.html';" value="Salva"/>
                            </c:if>
                            <script>
                                function cancella() {
                                    var domanda = confirm("Sei sicuro di voler continuare?");
                                    if (domanda === true) {
                                        location.href = 'registrazione.html?cancellati=true' ;
                                    } else {
                                        alert('Operazione annullata');
                                    }
                                }
                            </script>
                            <input id="cancellati" name="cancellati" type="button" onclick="cancella()" value="Cancellati"><!--"document.location.href = 'login.html';" --> 
                        </div>
                    </form>
                </main>
            </div>
        </div>
    </body>
</html>
