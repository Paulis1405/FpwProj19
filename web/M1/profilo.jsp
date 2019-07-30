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
                    <h2 class="col-8 col-s-8" id="profilo">PROFILO</h2>
                    
                    <form>
                        <label class="col-4 col-s-4" for="name">Nome </label>
                        <input class="col-8 col-s-8" type="text" name="name" id="name"/>
                        <br><br>
                        <label class="col-4 col-s-4" for="name">Cognome </label>
                        <input class="col-8 col-s-8" type="text" name="cognome" id="cognome"/>
                        <br><br>
                        <div class="col-12 col-s-12">
                            <label class="col-4 col-s-4" for="foto">Foto </label>
                            <input class="col-8 col-s-8" type="url" name="foto" id="foto"/>
                            <br><br>
                        </div>
                        <div class="col-12 col-s-12">
                            <label class="col-4 col-s-4" for="email">Email </label>
                            <input class="col-8 col-s-8" type="email" name="email" id="email"/>
                            <br><br>
                        </div>
                        <div class="col-12 col-s-12">
                            <label class="col-4 col-s-4" for="psw">Password </label>
                            <input class="col-8 col-s-8" type="password" name="psw" id="psw"/>
                            <br><br>
                        </div>
                        <div class="col-12 col-s-12">
                            <label class="col-4 col-s-4" for="ente">Ente </label>
                            <input class="col-8 col-s-8" type="url" name="ente" id="ente"/>
                            <br><br>
                        </div>
                        <div class="art">
                            <input id="salva" type="submit" value="Salva"/>
                            <input id="cancellati" type="button" onclick="document.location.href ='login.html';" value="Cancellati">
                        </div>
                    </form>
                </main>
            </div>
        </div>
        </body>
</html>
