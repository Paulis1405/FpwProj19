<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
</form>
