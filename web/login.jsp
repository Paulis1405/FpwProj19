<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessio Paulis">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina di accesso">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id='SU'>
            <jsp:include page="header.jsp"></jsp:include>
            <jsp:include page="nav.jsp"></jsp:include>
        </div>
        <div id="GIU">
            <div class="col-3 col-s-3">
            <aside>
                    <h3>Peer Review:</h3>
                    <p>Nell'ambito della ricerca scientifica, la revisione paritaria è la procedura di valutazione e di selezione degli articoli
                      o dei progetti di ricerca effettuata da specialisti del settore per verificarne l'idoneità alla 
                      pubblicazione o al finanziamento, evitando errori, distorsioni, bias, plagi, falsità, o truffe scientifiche</p>
            </aside>
            </div>
                <div class="col-9 col-s-9">
                <main>
                <h2 id="login">LOGIN</h2>
                <form id="log" action="login.html" method="post">
                
                <label for="email">Email </label>
                <input type="email" name="email" id="email" />
                <br>
                <label for="password">Password </label>
                <input type="password" name="password" id="password" />
                <br>
                <input name="accesso" type="submit" value="Accedi"/>
                <br><br> 
                <a id="registrati">Non hai un profilo?  </a><a href="registrazione.html">Registrati</a>
                </form>
                </main>
                </div>
            </div>
    </body>
</html>
