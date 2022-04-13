<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="title" content="List Books">
        <title>List Books</title>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <header class="nav-flex">
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="nav-left">
                    <a class="navbar-brand" href="listBook.jsp">
                        <img src="img/logo.jpg" draggable="false"/>
                    </a>
                    <a class="nav-link active" href="listBook.jsp">List Books</a>
                    <a class="nav-link active" href="bookDetail.jsp">My Bookcase</a>
                </div>
                <div class="nav-fill">
                    <form method="get" accept-charset="utf-8" action="searchBooks.jsp">  
                        <div class="input-group dropdown">
                            <button type="button" class="btn btn-primary dropdown-toggle rounded" data-toggle="dropdown" role="button">All</button>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">All</a>
                                <a class="dropdown-item" href="#">Title</a>
                                <a class="dropdown-item" href="#">Author</a>
                                <a class="dropdown-item" href="#">Category</a>
                            </div>
                            <input class="rounded" type="search" id="searchText" name="searchText" placeholder="Search here..." style="width: 500px">
                            <input type="submit" id="submitBtn" value="  " class="searchbtn btn btn-default rounded">
                        </div>
                    </form>

                </div>
                </div>
                <div class="nav-right">

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
                        <div class="card inline">
                            <img src="img/1.jpg" alt="Denim Jeans" style="width:100%">
                            <h1>Twilight</h1>
                            <p class="author">Author : Stephen Meyer</p>
                            <p>Category : Fantasy</p>
                            <p>
                                <button onclick='window.location.href="bookDetail.jsp"'>View Details</button>
                                <button onclick='window.location.href="bookDetail.jsp"'>Add to Bookcase</button>
                            </p>
                        </div>
                        <div class="card">
                            <img src="img/1.jpg" alt="Denim Jeans" style="width:100%">
                            <h1>Tailored Jeans</h1>
                            <p class="price">$19.99</p>
                            <p>Some text about the jeans..</p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="img/1.jpg" alt="Denim Jeans" style="width:100%">
                            <h1>Tailored Jeans</h1>
                            <p class="price">$19.99</p>
                            <p>Some text about the jeans..</p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="img/1.jpg" alt="Denim Jeans" style="width:100%">
                            <h1>Tailored Jeans</h1>
                            <p class="price">$19.99</p>
                            <p>Some text about the jeans..</p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="img/1.jpg" alt="Denim Jeans" style="width:100%">
                            <h1>Tailored Jeans</h1>
                            <p class="price">$19.99</p>
                            <p>Some text about the jeans..</p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="img/1.jpg" alt="Denim Jeans" style="width:100%">
                            <h1>Tailored Jeans</h1>
                            <p class="price">$19.99</p>
                            <p>Some text about the jeans..</p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="img/1.jpg" alt="Denim Jeans" style="width:100%">
                            <h1>Tailored Jeans</h1>
                            <p class="price">$19.99</p>
                            <p>Some text about the jeans..</p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="img/1.jpg" alt="Denim Jeans" style="width:100%">
                            <h1>Tailored Jeans</h1>
                            <p class="price">$19.99</p>
                            <p>Some text about the jeans..</p>
                            <p><button>Add to Cart</button></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
