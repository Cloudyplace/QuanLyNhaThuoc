package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AccessDenied_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Access Denied</title>\n");
      out.write("        <meta name=viewport content=\"width=device-width, initial-scale=1\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Merriweather:400,400i\" />\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            html { box-sizing: border-box; }\n");
      out.write("\n");
      out.write("            *,\n");
      out.write("            *::before,\n");
      out.write("            *::after { box-sizing: inherit; }\n");
      out.write("\n");
      out.write("            body * {\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("                font: normal 100%/1.15 \"Merriweather\", serif;\n");
      out.write("                background: #fff url(\"https://www.dropbox.com/s/0czxq7wr862we98/texture.jpg?raw=1\") repeat 0 0;\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* https://www.vecteezy.com/vector-art/87721-wood-fence-vectors */\n");
      out.write("            .wrapper {\n");
      out.write("                position: relative;\n");
      out.write("                max-width: 1298px;\n");
      out.write("                height: auto;\n");
      out.write("                margin: 2em auto 0 auto;\n");
      out.write("                background: transparent url(\"https://www.dropbox.com/s/qq5n8w99q40wtrg/wood-fence.png?raw=1\") no-repeat center top 24em;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* https://www.vecteezy.com/vector-art/237238-dog-family-colored-doodle-drawing */\n");
      out.write("            .box {\n");
      out.write("                max-width: 70%;\n");
      out.write("                min-height: 600px;\n");
      out.write("                margin: 0 auto;\n");
      out.write("                padding: 1em 1em;\n");
      out.write("                text-align: center;\n");
      out.write("                background: transparent url(\"https://www.dropbox.com/s/ft9vhk6720t1k86/dog-family-colored-doodle-drawing.jpg?raw=1\") no-repeat top 10em center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("                margin: 0 0 1rem 0;\n");
      out.write("                font-size: 8em;\n");
      out.write("                text-shadow: 0 0 6px #8b4d1a;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            p {\n");
      out.write("                margin-bottom: 0.5em;\n");
      out.write("                font-size: 1.75em;\n");
      out.write("                color: #ea8a1a;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            p:first-of-type {\n");
      out.write("                margin-top: 16em;\n");
      out.write("                text-shadow: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            p > a {\n");
      out.write("                border-bottom: 1px dashed #837256;\n");
      out.write("                font-style: italic;\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: #837256;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            p > a:hover { text-shadow: 0 0 3px #8b4d1a; }\n");
      out.write("\n");
      out.write("            p img { vertical-align: bottom; }\n");
      out.write("\n");
      out.write("            @media screen and (max-width: 600px) {\n");
      out.write("                .wrapper {\n");
      out.write("                    background-size: 300px 114px;\n");
      out.write("                    background-position: center top 22em;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .box {\n");
      out.write("                    max-width: 100%;\n");
      out.write("                    margin: 0 auto;\n");
      out.write("                    padding: 0;\n");
      out.write("                    background-size: 320px 185px;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                p:first-of-type { margin-top: 12em; }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <div class=\"box\">\n");
      out.write("                <h1>Lỗi</h1>\n");
      out.write("                <p>Bạn không có quyền truy cập</p>\n");
      out.write("                <p><a href=\"../home\">Xin mời quay về trang chủ</a></p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
