package org.apache.jsp.view.Manage.MedicineManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MedicineDetailAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-1.10.2.min.js\"></script>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <link href=\"css/Manage/MedicineManage/MedicineDetailAdmin.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../Home/Header.jsp", out, false);
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                    <div class=\"main-body\">\n");
      out.write("\n");
      out.write("                        <!-- Breadcrumb -->\n");
      out.write("                        <nav aria-label=\"breadcrumb\" class=\"main-breadcrumb\">\n");
      out.write("                            <ol class=\"breadcrumb\">\n");
      out.write("                                <li class=\"breadcrumb-item\"><a href=\"medicinemanage\">Quản lý thuốc</a></li>\n");
      out.write("                                <li class=\"breadcrumb-item active\" aria-current=\"page\">Chi tiết thuốc</li>\n");
      out.write("                            </ol>\n");
      out.write("                        </nav>\n");
      out.write("                        <!-- /Breadcrumb -->\n");
      out.write("                        <div class=\"row gutters-sm\">\n");
      out.write("                            <div class=\"col-md-4 mb-3\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <div class=\"d-flex flex-column align-items-center text-center\">\n");
      out.write("                                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MedicineDetail.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"Ảnh\"\n");
      out.write("                                                  width=\"300\">\n");
      out.write("                                            <div class=\"mt-3\">\n");
      out.write("                                                <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${profileUser.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
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
      out.write("                                            <h6 class=\"mb-0\">Tên thuốc</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MedicineDetail.medicineName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Loại thuốc</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${typeName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Nhà phân phối</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${distributorName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Ngày sản xuất</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MedicineDetail.manufactureDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">  \n");
      out.write("                                            <h6 class=\"mb-0\">Hạn sử dụng</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MedicineDetail.outOfDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Giá nhập</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MedicineDetail.inputPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" VND\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Giá bán</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MedicineDetail.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" VND\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Đơn vị</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MedicineDetail.unit}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Vị trí</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${boxName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Số lượng</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MedicineDetail.quantityInStock}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3\">\n");
      out.write("                                            <h6 class=\"mb-0\">Chú ý</h6>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-9 text-secondary\">\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MedicineDetail.note}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-12\">\n");
      out.write("                                            <a class=\"btn btn-info \" target=\"__blank\"\n");
      out.write("                                               href=\"medicineedit?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MedicineDetail.medicineId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Edit</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
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
