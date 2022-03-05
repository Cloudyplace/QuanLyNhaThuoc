package org.apache.jsp.view.Home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TopNavBar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/TopNavbar.css\" type=\"text/css\">\n");
      out.write("        <style>\n");
      out.write("            .div-login{\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("            .navbardiv{\n");
      out.write("                padding: 10px 0;\n");
      out.write("                display: flex;\n");
      out.write("            }\n");
      out.write("            .navdiv{\n");
      out.write("                width: 70%;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("            .container-icon{\n");
      out.write("                text-align: center;\n");
      out.write("                width: 9%;\n");
      out.write("                align-items: center;\n");
      out.write("                margin-top: 8px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropbtn {\n");
      out.write("                color: white;\n");
      out.write("                display: inline-block;\n");
      out.write("                border-radius: 30px;\n");
      out.write("                background-color: #112c39;\n");
      out.write("                opacity: 1;\n");
      out.write("                padding: 8px 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown {\n");
      out.write("                margin-top: 6px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                position: relative;\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content {\n");
      out.write("                box-shadow: 0 2px 3px 0 rgba(0, 0, 0, .1);\n");
      out.write("                width: 100%;\n");
      out.write("                display: none;\n");
      out.write("                position: absolute;\n");
      out.write("                background-color: #f1f1f1;\n");
      out.write("                z-index: 1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a {\n");
      out.write("                color: black;\n");
      out.write("                padding: 12px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a:hover {background-color: #ddd;}\n");
      out.write("\n");
      out.write("            .dropdown:hover .dropdown-content {display: block;}\n");
      out.write("\n");
      out.write("            .dropdown:hover .dropbtn {background-color: #134c68;}\n");
      out.write("\n");
      out.write("            .square {\n");
      out.write("                width: 20px;\n");
      out.write("                height: 20px;\n");
      out.write("                -moz-transform: rotate(45deg);\n");
      out.write("                -o-transform: rotate(45deg);\n");
      out.write("                -ms-transform: rotate(45deg);\n");
      out.write("                -webkit-transform: rotate(\n");
      out.write("                    45deg\n");
      out.write("                    );\n");
      out.write("                transform: rotate(\n");
      out.write("                    45deg\n");
      out.write("                    );\n");
      out.write("                border-radius: 4px;\n");
      out.write("                -moz-border-radius: 4px;\n");
      out.write("                -o-border-radius: 4px;\n");
      out.write("                -webkit-border-radius: 4px;\n");
      out.write("                -ms-webkit-radius: 4px;\n");
      out.write("                zoom: 1;\n");
      out.write("                position: absolute;\n");
      out.write("                top: -7px;\n");
      out.write("                left: calc(50% - 9px);\n");
      out.write("                background: #fff;\n");
      out.write("            }\n");
      out.write("            .icon-cart{\n");
      out.write("                color: white;\n");
      out.write("                font-size: xx-large;\n");
      out.write("            }\n");
      out.write("            .header__cart {\n");
      out.write("                display: inline-block;\n");
      out.write("                margin-top: 6px;\n");
      out.write("                margin-right: 10px;\n");
      out.write("                /* position: relative; */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header__cart-warp {\n");
      out.write("                position: relative;\n");
      out.write("                display: inline-block;\n");
      out.write("                padding: 0 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header__cart-warp:hover .cart__list {\n");
      out.write("                margin: 8px;\n");
      out.write("                display: block;\n");
      out.write("                /* cursor: pointer; */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header__cart-icon {\n");
      out.write("                font-size: 2.4rem;\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .cart__list {\n");
      out.write("                position: absolute;\n");
      out.write("                display: none;\n");
      out.write("                top: 34px;\n");
      out.write("                right: -10px;\n");
      out.write("                background-color: #fff;\n");
      out.write("                box-shadow: 0 2px 10px #ccc;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                animation: fadeIn ease-in 0.2s;\n");
      out.write("                /* cursor: default; */\n");
      out.write("                z-index: 1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header__cart-warp:hover .cart__list {\n");
      out.write("                display: block;\n");
      out.write("                /* cursor: pointer; */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .cart__list::after {\n");
      out.write("                content: \"\";\n");
      out.write("                cursor: pointer;\n");
      out.write("                /* display: none; */\n");
      out.write("                position: absolute;\n");
      out.write("                right: 4px;\n");
      out.write("                top: -32px;\n");
      out.write("                border-width: 23px 32px;\n");
      out.write("                border-style: solid;\n");
      out.write("                border-color: transparent transparent #fff transparent;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .cart__list img {\n");
      out.write("                width: 400px;\n");
      out.write("                height: 150px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .no-cart-msg {\n");
      out.write("                text-align: center;\n");
      out.write("                color: rgb(61, 61, 61);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .no-cart {\n");
      out.write("                padding: 24px 0px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header__cart-notice{\n");
      out.write("                position: absolute;\n");
      out.write("                padding: 0px 11px;\n");
      out.write("                background-color: white;\n");
      out.write("                border-radius: 11px;\n");
      out.write("                color: black;\n");
      out.write("                font-size: smaller;\n");
      out.write("                top: 0;\n");
      out.write("                right: 5px;\n");
      out.write("                border: 1px solid;\n");
      out.write("                transform: scale(0.9);\n");
      out.write("            }\n");
      out.write("            .navbardiv{\n");
      out.write("                box-shadow: 3px 3px 10px 1px #423631;\n");
      out.write("                background: #11101d;\n");
      out.write("                position: relative;\n");
      out.write("                z-index: 10;\n");
      out.write("                padding: 10px 0;\n");
      out.write("                display: flex;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <div class=\"navbardiv\">\n");
      out.write("            <div class=\"navdiv\">\n");
      out.write("                <div class=\"navdiv2\">\n");
      out.write("                    <nav>\n");
      out.write("                        <a href=\"home\">Trang chủ</a>\n");
      out.write("                        <a href=\"#\">Quản lý</a>\n");
      out.write("                        <a href=\"#\">Hóa đơn</a>\n");
      out.write("                        <a href=\"#\">Thống kê</a>\n");
      out.write("                        <div class=\"animation start-home\"></div>\n");
      out.write("                        <div id='nav1-animation' ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${displayBlock1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("></div>\n");
      out.write("                        <div id='nav2-animation' ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${displayBlock2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("></div>\n");
      out.write("                        <div id='nav3-animation' ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${displayBlock3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("></div>\n");
      out.write("                        <div id='nav4-animation' ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${displayBlock4}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("></div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"../js/topnavbar.js\"></script>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <div class=\"dropdown\" >\n");
        out.write("                    <div>   \n");
        out.write("                        <div class=\"dropbtn\"><img class=\"img-avatar\" src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.avatar}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" alt=\"\"><span style=\"margin-left: 5px;\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></div>\n");
        out.write("                    </div>\n");
        out.write("                    <div class=\"dropdown-content\">\n");
        out.write("                        <span class=\"square\"></span>\n");
        out.write("                        <a href=\"profile\"><span><img class=\"img-cart\" src=\"https://img.icons8.com/ios-glyphs/30/000000/user--v1.png\" style=\"margin-bottom: -9px;\">Profile</span></a>\n");
        out.write("                        <a href=\"logout\"><span><img src=\"https://img.icons8.com/external-dreamstale-lineal-dreamstale/32/000000/external-logout-ui-dreamstale-lineal-dreamstale.png\" style=\"margin-bottom: -9px;\"/>Logout</span></a>\n");
        out.write("                    </div>\n");
        out.write("\n");
        out.write("                </div>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
