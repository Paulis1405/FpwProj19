<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>

<json:array>
    <c:forEach var="autori" items="${autoriList}">
        <json:object>
            <json:property name="nome" value="${autori.getName()}"/> 
            <json:property name="cognome" value="${autori.getSurname()}"/>
            <json:property name="id" value="${autori.getId()}"/>
        </json:object>
    </c:forEach>
</json:array>