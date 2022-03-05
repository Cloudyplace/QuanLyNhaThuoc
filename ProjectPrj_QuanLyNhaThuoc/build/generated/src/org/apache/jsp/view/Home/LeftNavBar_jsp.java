package org.apache.jsp.view.Home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LeftNavBar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>W3.CSS</title>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<!-- Sidebar -->\n");
      out.write("<div class=\"w3-sidebar w3-bar-block w3-border-right\" style=\"display:none\" id=\"mySidebar\">\n");
      out.write("  <button onclick=\"w3_close()\" class=\"w3-bar-item w3-large\">Close &times;</button>\n");
      out.write("  <a href=\"#\" class=\"w3-bar-item w3-button\">Link 1</a>\n");
      out.write("  <a href=\"#\" class=\"w3-bar-item w3-button\">Link 2</a>\n");
      out.write("  <a href=\"#\" class=\"w3-bar-item w3-button\">Link 3</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Page Content -->\n");
      out.write("<div class=\"w3-teal\">\n");
      out.write("  <button class=\"w3-button w3-teal w3-xlarge\" onclick=\"w3_open()\">☰</button>\n");
      out.write("  <div class=\"w3-container\">\n");
      out.write("    <h1>My Page</h1>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<img src=\"img_car.jpg\" alt=\"Car\" style=\"width:100%\">\n");
      out.write("\n");
      out.write("<div class=\"w3-container\">\n");
      out.write("<p>This sidebar is hidden by default, (style=\"display:none\")</p>\n");
      out.write("<p>You must click on the \"hamburger\" icon (top left) to open it.</p>\n");
      out.write("<p>The sidebar will hide a part of the page content.</p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("function w3_open() {\n");
      out.write("  document.getElementById(\"mySidebar\").style.display = \"block\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("function w3_close() {\n");
      out.write("  document.getElementById(\"mySidebar\").style.display = \"none\";\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("     \n");
      out.write("</body>\n");
      out.write("</html> \n");
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
