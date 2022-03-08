package org.apache.jsp.view.Home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <!-- <link rel=\"stylesheet\" href=\"/style.css\"> -->\n");
      out.write("        <title> E-COMMERCE WEBSITE BY EDYODA | CREATED BY PRIYANKA SHARMA </title>\n");
      out.write("        <!-- favicon -->\n");
      out.write("\n");
      out.write("        <link rel=\"icon\"\n");
      out.write("              href=\"https://yt3.ggpht.com/a/AGF-l78km1YyNXmF0r3-0CycCA0HLA_i6zYn_8NZEg=s900-c-k-c0xffffffff-no-rj-mo\"\n");
      out.write("              type=\"image/gif\" sizes=\"16x16\">\n");
      out.write("        <!-- header links -->\n");
      out.write("        <script src=\"https://kit.fontawesome.com/4a3b1f73a2.js\"></script>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Lato&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <!-- slider links -->\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-3.4.1.min.js\"\n");
      out.write("        integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/HomeStyle/headerStyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <header>\n");
      out.write("        <section>\n");
      out.write("            <!-- MAIN CONTAINER -->\n");
      out.write("            <div id=\"container\">\n");
      out.write("                <!-- SHOP NAME -->\n");
      out.write("                <div id=\"shopName\"><a href=\"index.html\"> <b>SHOP</b>LANE </a></div>\n");
      out.write("                <!-- COLLCETIONS ON WEBSITE -->\n");
      out.write("                <div id=\"collection\">\n");
      out.write("                    <div id=\"clothing\"><a href=\"clothing.html\"> CLOTHING </a></div>\n");
      out.write("                    <div id=\"accessories\"><a href=\"accessories.html\"> ACCESSORIES </a></div>\n");
      out.write("                </div>\n");
      out.write("                <!-- SEARCH SECTION -->\n");
      out.write("                <div id=\"search\">\n");
      out.write("                    <i class=\"fas fa-search search\"></i>\n");
      out.write("                    <input type=\"text\" id=\"input\" name=\"searchBox\" placeholder=\"Search for Clothing and Accessories\">\n");
      out.write("                </div>\n");
      out.write("                <!-- USER SECTION (CART AND USER ICON) -->\n");
      out.write("                <div id=\"user\">\n");
      out.write("                    <a href=\"cart.html\"> <i class=\"fas fa-shopping-cart addedToCart\">\n");
      out.write("                            <div id=\"badge\"> 0 </div>\n");
      out.write("                        </i></a>\n");
      out.write("                    <a href=\"#\"> <i class=\"fas fa-user-circle userIcon\"></i> </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
