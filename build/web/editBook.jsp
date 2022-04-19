
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Crud</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
        <script>
            function doBack(){
                window.location.href = "listBook";
            }
        </script>
    <body>
        <div class="container">
            
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="edit" method="post">
                            <div class="modal-header">						
                                <h3 class="modal-title">Edit Book</h3>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="doBack()">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${book.getBookId()}" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Book Title</label>
                                    <input value="${book.getBookTitle()}" name="BookTitle" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Author</label>
                                    <select name="author_id" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${authors}" var="o">
                                            <option ${(book.getAuthorId() == o.getAuthorId())?"selected":""} value="${o.getAuthorId()}">${o.getAuthorName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Brief</label>
                                    <input value="${book.getBrief()}" name="brief" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Publisher</label>
                                    <input value="${book.getPublisher()}" name="publisher" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Content</label>
                                    <input value="${book.getContent()}" name="content" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <select name="category_id" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${categorys}" var="o">
                                            <option ${(book.getCategoryId() == o.getCategoryId())?"selected":""} value="${o.getCategoryId()}">${o.getCategoryName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Image</label>
                                    <input value="img/${book.getImage()}" name="img" type="file" class="form-control" required>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" onclick='window.location.href="admin"' value="Cancel">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>