<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="title" content="List Books">
        <title>List Books</title>
        <link rel="stylesheet" href="css/styleAdmin.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <script>


            function doEdit(id)
            {

                window.location.href = 'load?bid=' + id;
            }
            function doDelete(id)
            {
                var c = confirm('Are you sure?');
                if (c)
                {
                    window.location.href = 'delete?id=' + id;
                }
            }
        </script>
    </head>
    <body>
        <header class="nav-flex">
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="nav-left">
                    <a class="navbar-brand" href="admin">
                        <img src="img/logo.jpg" draggable="false"/>
                    </a>
                    <a class="nav-link active" href="admin">Manage List Books</a>
                </div>
                <div class="nav-fill">
                    <form id="searchSubmit" method="post" action="searchBooks">  
                        <div class="input-group dropdown">
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
                                    <a class="nav-link active" href="#">Hello ${sessionScope.acc.userName}</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link active" href="logout">Logout</a>
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
                    <div class="col-sm-6">
                        <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Book</span></a>

                    </div>
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
                                    <button onclick="doEdit(${b.bookId})">Edit</button>
                                    <button onclick="doDelete(${b.bookId})" >Delete</button>

                                </p>
                            </div>
                        </c:forEach>


                    </div>
                </div>
            </div>
        </div>
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="create" method="POST">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Book</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Book title:</label>
                                <input name="book_title" type="text" class="form-control" required >
                            </div>
                            <div class="form-group">
                                <label>Author:</label>
                                <select name="author_id" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listAuthor}" var="o">
                                        <option value="${o.getAuthorId()}">${o.getAuthorName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Brief:</label>
                                <input name="brief" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Publisher:</label>
                                <input name="publisher" type="text" class="form-control" required >

                            </div>
                            <div class="form-group">
                                <label>Content:</label>
                                <input name="content" type="text" class="form-control" required >

                            </div>
                            <div class="form-group">
                                <label>Category:</label>
                                <select name="category_id" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listCat}" var="o">
                                        <option value="${o.getCategoryId()}">${o.getCategoryName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Image:</label>
                                <input name="img" type="file" class="form-control" required >

                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="../Js/list.js" type="text/javascript"></script>
    </body>
</html>