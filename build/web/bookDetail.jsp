<%-- 
    Document   : bookDetail
    Created on : Mar 31, 2022, 10:51:54 PM
    Author     : HLC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/colors.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="css/home.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <title>Book Detail</title>
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
                        <a class="nav-link active" href="bookDetail">My Bookcase</a>
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
        <section class="section bt littlepad" >
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-5">
                        <div class="screen-normal wow slideInLeft">
                            <img src="img/${book.image}" alt="${book.bookTitle}" class="img-fluid">
                        </div>
                    </div>

                    <div class="col-md-7 mobmartop30">
                        <div class="tagline-v2 padleft30">
                            <h1>${book.bookTitle}</h1>                            
                            <p><b style="color: black;font-weight: 500">Tác giả: </b>${authorName}</p>
                            <p><b style="color: black;font-weight: 500">Thể loại: </b>${categoryName}</p>
                            <p><b style="color: black;font-weight: 500">NXB : </b>${book.publisher}</p>
                            <p><b style="color: black;font-weight: 500">Brief : </b></p>                            
                            <p>${book.brief}</p>
                            <p><b style="color: black;font-weight: 500">Content : </b></p>                            
                            <p>${book.content}</p>
                            <a href="listBook" class="btn btn-gradient grd4 withradius secbtn">HOME</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
