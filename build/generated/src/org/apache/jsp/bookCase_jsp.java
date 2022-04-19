package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bookCase_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("        <meta name=\"title\" content=\"List Books\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/home.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <title>Book Case</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"nav-flex\">\n");
      out.write("            <nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("                <div class=\"nav-left\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"listBook\">\n");
      out.write("                        <img src=\"img/logo.jpg\" draggable=\"false\"/>\n");
      out.write("                    </a>\n");
      out.write("                    <a class=\"nav-link active\" href=\"listBook\">List Books</a>\n");
      out.write("                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.roleId == 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <a class=\"nav-link active\" href=\"admin\">Manage List Books</a>\n");
      out.write("                    </c:if>\n");
      out.write("                    <a class=\"nav-link active\" href=\"bookDetail\">My Bookcase</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"nav-fill\">\n");
      out.write("                    <form id=\"searchSubmit\" method=\"post\" accept-charset=\"utf-8\" action=\"searchBooks\">  \n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <select name=\"searchGroup\" class=\"form-select form-select-sm rounded\" aria-label=\".form-select-sm example\" form=\"searchSubmit\">\n");
      out.write("                                <option selected=\"selected\" value=\"title\">Book's Title</option>\n");
      out.write("                                <option value=\"category\">Book's Category</option>\n");
      out.write("                                <option value=\"author\">Author</option>\n");
      out.write("                            </select>\n");
      out.write("                            <input class=\"rounded\" type=\"search\" id=\"searchText\" name=\"searchText\" placeholder=\"Search here...\" style=\"width: 500px\">\n");
      out.write("                            <input type=\"submit\" id=\"submitBtn\" value=\"  \" class=\"searchbtn btn btn-default rounded\">\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"nav-right\">\n");
      out.write("                    <div class=\"justify-content-end\"\">\n");
      out.write("                        <ul class=\"navbar-nav m-auto\">\n");
      out.write("                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"#\">Hello ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"logout\">Logout</a>\n");
      out.write("                                </li> \n");
      out.write("                            </c:if>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("                                \n");
      out.write("        <div id=\"content\">\n");
      out.write("            <div id=\"listbook\" class=\"col-md-12\">\n");
      out.write("                <div class=\"items\">\n");
      out.write("                    <h1 class=\"page-title\">\n");
      out.write("                        My Bookcase : \n");
      out.write("                        <i class=\"fa fa-angle-right\"></i>\n");
      out.write("                    </h1>\n");
      out.write("                    <div class=\"row align-items-start\">\n");
      out.write("                        <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listBook}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"b\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <img src=\"img/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.bookTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" style=\"width:100%\">\n");
      out.write("                                <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.bookTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                                <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listAuthor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"a\">\n");
      out.write("                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.authorId == a.authorId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        <p>Author : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${a.authorName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                    </c:if>\n");
      out.write("                                </c:forEach>\n");
      out.write("                                <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listCat}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"c\">\n");
      out.write("                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.categoryId == c.categoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        <p>Category : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.categoryName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                    </c:if>\n");
      out.write("                                </c:forEach>\n");
      out.write("                                <p>\n");
      out.write("                                    <button onclick='window.location.href = \"bookDetail?bookId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.bookId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"'>View Details</button>\n");
      out.write("                                    <button onclick='window.location.href = \"bookDetail?bookId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.bookId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"'>Add to Bookcase</button>\n");
      out.write("                                </p>\n");
      out.write("                            </div>\n");
      out.write("                        </c:forEach>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
