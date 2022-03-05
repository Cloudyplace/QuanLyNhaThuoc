package org.apache.jsp.view.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--Author: W3layouts\n");
      out.write("Author URL: http://w3layouts.com\n");
      out.write("License: Creative Commons Attribution 3.0 Unported\n");
      out.write("License URL: http://creativecommons.org/licenses/by/3.0/\n");
      out.write("-->\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <title>Online Login Form Responsive Widget Template :: w3layouts</title>\n");
      out.write("        <!-- Meta tag Keywords -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Online Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements\" />\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false);\n");
      out.write("            function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <!-- Meta tag Keywords -->\n");
      out.write("        <!-- css files -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"all\" /> <!-- Style-CSS --> \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.css\"> <!-- Font-Awesome-Icons-CSS -->\n");
      out.write("        <!-- //css files -->\n");
      out.write("        <!-- online-fonts -->\n");
      out.write("        <link href=\"//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"//fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800&amp;subset=latin-ext\" rel=\"stylesheet\">\n");
      out.write("        <!-- //online-fonts -->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- main -->\n");
      out.write("        <img style=\"position: absolute;width: 100%;top: 0;right: 0;z-index: -1; opacity: 0.85\" src=\"image/anh-nen-login.jpg\" alt=\"\">\n");
      out.write("\n");
      out.write("        <div class=\"center-container\"s>\n");
      out.write("            <!--header-->\n");
      out.write("            <div class=\"header-w3l\">\n");
      out.write("                <h1>Đăng nhập</h1>\n");
      out.write("            </div>\n");
      out.write("            <!--//header-->\n");
      out.write("            <div class=\"main-content-agile\">\n");
      out.write("\n");
      out.write("                <div class=\"sub-main-w3\">\t\n");
      out.write("\n");
      out.write("                    <form class=\"formLogin\" action=\"login\" method=\"post\">\n");
      out.write("                        <div class=\"pom-agile\">\n");
      out.write("                            <input placeholder=\"Tài khoản\" name=\"username\" class=\"user\" type=\"text\" required=\"\">\n");
      out.write("                            <span class=\"icon1\"><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"pom-agile\">\n");
      out.write("                            <input  placeholder=\"Mật khẩu\" name=\"password\" class=\"pass\" type=\"password\" required=\"\">\n");
      out.write("                            <span class=\"icon2\"><i class=\"fa fa-unlock\" aria-hidden=\"true\"></i></span>\n");
      out.write("                        </div>\n");
      out.write("                        <h3 class=\"errorLogin\"\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ErrorLogin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                        <div class=\"sub-w3l\">\n");
      out.write("                            <div class=\"right-w3l\">\n");
      out.write("                                <input type=\"submit\" value=\"Đăng nhập\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--//main-->\n");
      out.write("            <!--footer-->\n");
      out.write("            <div class=\"footer\">\n");
      out.write("                <p>Design by Minh Dep Trai</p>\n");
      out.write("            </div>\n");
      out.write("            <!--//footer-->\n");
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
