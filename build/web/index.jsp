<%-- 
    Document   : index
    Created on : Aug 18, 2013, 2:38:46 AM
    Author     : hdr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Heng's Identicon Demo</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <div>
            <h1 class="mainheader">Identicon</h1>
            <p class="description">One simple solution for you to recognize people online</p>
        </div>
        <div class="operatingArea">
            <div class="input">
                <form name="index.jsp" action="index.jsp" method="POST">
                    <p class="explainText">code to be converted</p>
                    <input type="text" name="c"/>
                    <input type="hidden" name="s" value="64"/>
                    <input class="sendButton" type="submit" value="submit"/>
                </form>
            </div>
            <div class="output">
                <c:choose>
                    <c:when test="${param.c!=null}">
                        <p class="explainText">Don's identicon of int input:<c:out value="${param.c}"/></p>
                        <img src="IdenticonServlet?c=${param.c}&s=${param.s}" alt="identicon image" width="128"/>
                    </c:when>
                    <c:otherwise>
                        <p class="explainText">Don's Park's identicon of int input:123456</p>
                        <img src="IdenticonServlet?c=123456&s=64" alt="identicon image" width="128"/>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="output">
                <c:choose>
                    <c:when test="${param.c!=null}">
                        <p class="explainText">My identicon of text input:<c:out value="${param.c}"/></p>
                        <img src="MyIdenticonServlet?c=${param.c}&s=${param.s}" alt="identicon image" width="128"/>
                    </c:when>
                    <c:otherwise>
                        <p class="explainText">My identicon of text input:123456</p>
                        <img src="MyIdenticonServlet?c=123456&s=64" alt="identicon image" width="128"/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>  
        <div class="intro">
            <div class="pic">
                <img src="http://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Identicon.svg/200px-Identicon.svg.png" alt="image of identicon from wikipedia"/>
            </div>
            <div class="introtext">
                <h2>What is identicon?</h2>
                <p>An Identicon is a visual representation of a hash value, usually of an IP address, that serves to identify a user of a computer system as a form of avatar while protecting the users' privacy. The original Identicon was a 9-block graphic, and the representation has been extended to other graphic forms by third parties.</p><p>*Both image and introduction are from <a href="http://en.wikipedia.org/wiki/Identicon">Wikipedia</a>.</p>
            </div>
        </div>
        <div class="intro">
            <div class="introtext">
                <h2>What's the difference?</h2>
                <p>Park's identicon generator can only process int value. My identicon generator is using MD5 of any text input as code to generate images so it can process text input. It's a prototype with promising potential improvements and huge possibilities.</p>
            </div>
        </div>
        <div class="intro">
            <div class="introtext">
                <h2>How to use this web application?</h2>
                <p>Simply put text into the input box and hit the button, you will see the identicon images showing on the right side.</p>
            </div>
        </div>
    </body>
</html>
