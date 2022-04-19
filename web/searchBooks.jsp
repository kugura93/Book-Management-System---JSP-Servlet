<%-- 
    Document   : searchBooks
    Created on : Mar 31, 2022, 10:52:17 PM
    Author     : HLC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="title" content="List Books">
        <title>List Books</title>
        <link rel="stylesheet" href="css/home.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <header class="nav-flex">
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="nav-left">
                    <a class="navbar-brand" href="listBook">
                        <img src="img/logo.jpg" draggable="false"/>
                    </a>
                    <c:if test="${sessionScope.acc.roleId == 1}">
                        <a class="nav-link active" href="admin">Manage List Books</a>
                    </c:if>
                    <c:if test="${sessionScope.acc.roleId == 2}">
                        <a class="nav-link active" href="listBook">List Books</a>
                        <a class="nav-link active" href="bookCase">My Bookcase</a>
                    </c:if>
                </div>
                <div class="nav-fill">
                    <form id="searchSubmit" method="post" accept-charset="utf-8" action="searchBooks">  
                        <div class="input-group">
                            <select name="searchGroup" class="form-select form-select-sm rounded" aria-label=".form-select-sm example" form="searchSubmit">
                                <option selected="selected" value="title">Book's Title</option>
                                <option value="category">Book's Category</option>
                                <option value="author">Author</option>
                            </select>
                            <input class="rounded" type="search" id="searchText" name="searchText" placeholder="Search here..." style="width: 500px">
                            <input type="submit" id="submitBtn" value="  " class="searchbtn btn btn-default rounded">
                        </div>
                    </form>
                </div>
                </div>
                <div class="nav-right">
                    <div class="justify-content-end"">
                        <ul class="navbar-nav m-auto">
                            <c:if test="${sessionScope.acc != null}">
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Hello ${sessionScope.acc.userName}</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="logout">Logout</a>
                                </li> 
                            </c:if>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <div id="content">
            <div id="listbook" class="col-md-12">
                <div class="items">
                    <h1 class="page-title">
                        List Books
                        <i class="fa fa-angle-right"></i>
                    </h1>
                    <div class="row align-items-start">
                        <c:forEach items="${listBook}" var="b">
                            <div class="card">
                                <img src="img/${b.image}" alt="${b.bookTitle}" style="width:100%">
                                <h3>${b.bookTitle}</h3>
                                <c:forEach items="${listAuthor}" var="a">
                                    <c:if test="${b.authorId == a.authorId}">
                                        <p>Author : ${a.authorName}</p>
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${listCat}" var="c">
                                    <c:if test="${b.categoryId == c.categoryId}">
                                        <p>Category : ${c.categoryName}</p>
                                    </c:if>
                                </c:forEach>
                                <p>
                                    <button onclick='window.location.href = "bookDetail?bookId=${b.bookId}"'>View Details</button>
                                    <button onclick='window.location.href = "bookDetail?bookId=${b.bookId}"'>Add to Bookcase</button>
                                </p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
