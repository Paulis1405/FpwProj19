
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="col-3 col-s-3">
    <aside>
        Bentornato ${autore.getNome()} ${autore.getCognome()}!

        <br>
        <input name="logout" id="new_art" type="button" onclick="document.location.href = 'logout.html?logout=true';" value="LOGOUT">
        <br><br>
        <h2>I miei articoli </h2>
        <ul>
            <c:forEach items="${articoli}" var="articolo">
                <li>
                    ${articolo.getTitolo()}
                </li>
            </c:forEach>
            
        </ul>
        <br><br>
        <h2>Articoli da valutare</h2>
        <ul>
            <c:forEach items="${articoliDaValutare}" var="articoloDaValutare">
                <li>
                    ${articoloDaValutare.getTitolo()}
                </li>
            </c:forEach>
            
        </ul>
    </aside>
</div>