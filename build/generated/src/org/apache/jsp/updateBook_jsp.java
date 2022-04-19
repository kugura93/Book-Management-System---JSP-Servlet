package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Book;
import model.Category;
import model.Author;
import java.util.ArrayList;

public final class updateBook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");

            ArrayList<Author> authors = (ArrayList<Author>) request.getAttribute("authors");
            ArrayList<Category> categorys = (ArrayList<Category>) request.getAttribute("categorys");
            Book b = (Book) request.getAttribute("b");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"POST\" action=\"updateBook\">\n");
      out.write("            Title:<input type=\"text\" name=\"bookTitle\" value=\"");
      out.print( b.getBookTitle() );
      out.write("\"/> <br/>\n");
      out.write("            Author:\n");
      out.write("            <select name=\"author_id\">\n");
      out.write("                ");
 for (Author a : authors) {
                
      out.write("\n");
      out.write("                <option ");
      out.print( a.getAuthorId() == b.getAuthorId() ? "selected=\"selected\"":"" );
      out.write("\n");
      out.write("                    value=\"");
      out.print(a.getAuthorId());
      out.write('"');
      out.write('>');
      out.print(a.getAuthorName());
      out.write("</option>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </select> <br/>\n");
      out.write("            Brief:<input type=\"text\" name=\"brief\" value=\"");
      out.print( b.getBrief() );
      out.write("\"/> <br/>\n");
      out.write("            Publisher:<input type=\"text\" name=\"publisher\" value=\"");
      out.print( b.getPublisher());
      out.write("\"/> <br/>\n");
      out.write("            Content:<input type=\"text\" name=\"content\" value=\"");
      out.print( b.getContent());
      out.write("\"/> <br/>\n");
      out.write("            Category:\n");
      out.write("            <select name=\"category_id\">\n");
      out.write("                ");
 for (Category c : categorys) {
                
      out.write("\n");
      out.write("                <option ");
      out.print( c.getCategoryId()== b.getCategoryId() ? "selected=\"selected\"":"" );
      out.write("\n");
      out.write("                    value=\"");
      out.print(c.getCategoryId());
      out.write('"');
      out.write('>');
      out.print(c.getCategoryName());
      out.write("</option>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </select><br/>\n");
      out.write("            Img: <input type=\"text\" name=\"img\" value=\"");
      out.print( b.getImage());
      out.write("\"/> <br/>\n");
      out.write("            <input type=\"submit\" value=\"Save\"/>\n");
      out.write("        </form>\n");
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
