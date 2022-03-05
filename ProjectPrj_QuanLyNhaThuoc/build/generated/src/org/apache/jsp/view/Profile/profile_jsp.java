package org.apache.jsp.view.Profile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!DOCTYPE html>\n");
      out.write("    <html lang=\"en\">\n");
      out.write("\n");
      out.write("        <head>\n");
      out.write("            <meta charset=\"utf-8\">\n");
      out.write("            <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->\n");
      out.write("            <!--  All snippets are MIT license http://bootdey.com/license -->\n");
      out.write("            <title>profile with data and skills - Bootdey.com</title>\n");
      out.write("            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-1.10.2.min.js\"></script>\n");
      out.write("            <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("            <link href=\"css/Profile/ProfileStyle.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"main-body\">\n");
      out.write("\n");
      out.write("                    <!-- Breadcrumb -->\n");
      out.write("                    <nav aria-label=\"breadcrumb\" class=\"main-breadcrumb\">\n");
      out.write("                        <ol class=\"breadcrumb\">\n");
      out.write("                            <li class=\"breadcrumb-item\"><a href=\"index.html\">Home</a></li>\n");
      out.write("                            <li class=\"breadcrumb-item\"><a href=\"javascript:void(0)\">User</a></li>\n");
      out.write("                            <li class=\"breadcrumb-item active\" aria-current=\"page\">User Profile</li>\n");
      out.write("                        </ol>\n");
      out.write("                    </nav>\n");
      out.write("                    <!-- /Breadcrumb -->\n");
      out.write("\n");
      out.write("                    <div class=\"row gutters-sm\">\n");
      out.write("                        <div class=\"col-md-4 mb-3\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"d-flex flex-column align-items-center text-center\">\n");
      out.write("                                        <img src=\"https://bootdey.com/img/Content/avatar/avatar7.png\" alt=\"Admin\"\n");
      out.write("                                             class=\"rounded-circle\" width=\"150\">\n");
      out.write("                                        <div class=\"mt-3\">\n");
      out.write("                                            <h4>John Doe</h4>\n");
      out.write("                                            <p class=\"text-secondary mb-1\">Full Stack Developer</p>\n");
      out.write("                                            <p class=\"text-muted font-size-sm\">Bay Area, San Francisco, CA</p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-8\">\n");
      out.write("                            <div class=\"card mb-3\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Full Name</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            Kenneth Valdez\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Email</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            fip@jukmuh.al\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Phone</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            (239) 816-9029\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Address</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            Bay Area, San Francisco, CA\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-12\">\n");
      out.write("                                            <a class=\"btn btn-info \" target=\"__blank\"\n");
      out.write("                                               href=\"https://www.bootdey.com/snippets/view/profile-edit-data-and-skills\">Edit</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </body>\n");
      out.write("\n");
      out.write("    </html>\n");
      out.write("</body>\n");
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
