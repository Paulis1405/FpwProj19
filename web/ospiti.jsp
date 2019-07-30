<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ospiti</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessio Paulis">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina per utenti non autenticati">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="SU">
            <jsp:include page="header.jsp"></jsp:include>
            <div class="col-9 col-s-9">
                <nav>
                    <ul>
                        <li></li>
                        <li><a href="login.html">Login</a></li>
                        <li></li>
                    </ul>
                </nav>
            </div>
        </div>
        <div id="GIU">
            <div class="col-3 col-s-3">
                <aside>
                    Per poter visualizzare i contenuti, devi accedere!
                </aside>
            </div>
            <div class="col-9 col-s-9">
                <main>
                </main>
            </div>
        </div>
    </body>
</html>
