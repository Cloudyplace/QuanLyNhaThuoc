package org.apache.jsp.view.Manage.OutputInvoiceManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class OutInvoiceDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("        <link rel=\"stylesheet\" href=\"css/Manage/OutputInvoice/OutInvoiceDetail.css\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-1.10.2.min.js\"></script>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../Home/Header.jsp", out, false);
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("\n");
      out.write("            <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container px-0\">\n");
      out.write("                <div class=\"row mt-4\">\n");
      out.write("                    <div class=\"col-12 col-lg-12\">\n");
      out.write("                        <!-- Breadcrumb -->\n");
      out.write("                        <nav aria-label=\"breadcrumb\" class=\"main-breadcrumb\">\n");
      out.write("                            <ol class=\"breadcrumb\">\n");
      out.write("                                <li class=\"breadcrumb-item\"><a href=\"outputInvoiceManage\">Quản lý hóa đơn bán</a></li>\n");
      out.write("                                <li class=\"breadcrumb-item active\" aria-current=\"page\">Chi tiết hóa đơn bán</li>\n");
      out.write("                            </ol>\n");
      out.write("                        </nav>\n");
      out.write("                        <div class=\"page-content container\">\n");
      out.write("                            <div class=\"page-header text-blue-d2\">\n");
      out.write("                                <h1 class=\"page-title text-secondary-d1\">\n");
      out.write("                                    Hóa đơn\n");
      out.write("                                    <small class=\"page-info\">\n");
      out.write("                                        <i class=\"fa fa-angle-double-right text-80\"></i>\n");
      out.write("                                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${OutInvoiceAndAccount.outInvoiceId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                </small>\n");
      out.write("                            </h1>\n");
      out.write("\n");
      out.write("                            <div class=\"page-tools\">\n");
      out.write("                                <div class=\"action-buttons\">\n");
      out.write("                                    <a class=\"btn bg-white btn-light mx-1px text-95\" href=\"#\" data-title=\"Print\">\n");
      out.write("                                        <i class=\"mr-1 fa fa-print text-proutary-m1 text-120 w-2\"></i>\n");
      out.write("                                        In\n");
      out.write("                                    </a>\n");
      out.write("                                    <a class=\"btn bg-white btn-light mx-1px text-95\" href=\"#\" data-title=\"PDF\">\n");
      out.write("                                        <i class=\"mr-1 fa fa-file-pdf-o text-danger-m1 text-120 w-2\"></i>\n");
      out.write("                                        Export\n");
      out.write("                                    </a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <hr class=\"row brc-default-l1 mx-n1 mb-4\" />\n");
      out.write("\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("                                <div>\n");
      out.write("                                    <span class=\"text-sm text-grey-m2 align-middle\">Nhân viên: </span>\n");
      out.write("                                    <span class=\"text-600 text-90 text-blue align-middle\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${OutInvoiceAndAccount.account.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.col -->\n");
      out.write("\n");
      out.write("                            <div class=\"text-95 col-sm-6 align-self-start d-sm-flex justify-content-end\">\n");
      out.write("                                <hr class=\"d-sm-none\" />\n");
      out.write("                                <div class=\"text-grey-m2\">\n");
      out.write("                                    <div class=\"mt-1 mb-2 text-secondary-m1 text-600 text-125\">\n");
      out.write("                                        Hóa đơn\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"my-2\"><i class=\"fa fa-circle text-blue-m2 text-xs mr-1\"></i> <span class=\"text-600 text-90\">ID: </span> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${OutInvoiceAndAccount.outInvoiceId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                                    <div class=\"my-2\"><i class=\"fa fa-circle text-blue-m2 text-xs mr-1\"></i> <span class=\"text-600 text-90\">Tên khách hàng: </span> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${OutInvoiceAndAccount.customerName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                                    <div class=\"my-2\"><i class=\"fa fa-circle text-blue-m2 text-xs mr-1\"></i> <span class=\"text-600 text-90\">Số điện thoại KH: </span> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${OutInvoiceAndAccount.customerPhone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("\n");
      out.write("                                    <div class=\"my-2\"><i class=\"fa fa-circle text-blue-m2 text-xs mr-1\"></i> <span class=\"text-600 text-90\">Ngày phát hành: </span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${OutInvoiceAndAccount.saleDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.col -->\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"mt-4\">\n");
      out.write("                            <div class=\"row text-600 text-white bgc-default-tp1 py-25\">\n");
      out.write("                                <div class=\"d-none d-sm-block col-1\">STT</div>\n");
      out.write("                                <div class=\"col-9 col-sm-3\">Tên sản phẩm</div>\n");
      out.write("                                <div class=\"d-none d-sm-block col-4 col-sm-2\">Đơn vị</div>\n");
      out.write("                                <div class=\"d-none d-sm-block col-4 col-sm-2\">Số lượng</div>\n");
      out.write("                                <div class=\"d-none d-sm-block col-sm-2\">Đơn giá</div>\n");
      out.write("                                <div class=\"col-2\">Tiền</div>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                                int i = 1;
                                request.setAttribute("i", i);
                            
      out.write("\n");
      out.write("                            ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ListOutInvoiceDetail}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_c_forEach_0.setVar("o");
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("                                <div class=\"text-95 text-secondary-d3\">\n");
            out.write("                                    <div class=\"row mb-2 mb-sm-0 py-25\">\n");
            out.write("                                        <div class=\"d-none d-sm-block col-1\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</div>\n");
            out.write("                                        <div class=\"col-9 col-sm-3\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.medicine.medicineName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</div>\n");
            out.write("                                        <div class=\"d-none d-sm-block col-2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.medicine.unit}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</div>\n");
            out.write("                                        <div class=\"d-none d-sm-block col-2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</div>\n");
            out.write("                                        <div class=\"d-none d-sm-block col-2 text-95\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.medicine.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</div>\n");
            out.write("                                        <div class=\"col-2 text-secondary-d2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.quantity*o.medicine.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</div>\n");
            out.write("                                    </div>\n");
            out.write("                                </div>\n");
            out.write("                                <hr/>\n");
            out.write("                                ");

                                    i = i + 1;
                                    request.setAttribute("i", i);
                                
            out.write("\n");
            out.write("                            ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"row border-b-2 brc-default-l2\"></div>\n");
      out.write("\n");
      out.write("                            <div class=\"row mt-3\">\n");
      out.write("                                <div class=\"col-12 col-sm-7 text-grey-d2 text-95 mt-2 mt-lg-0\">\n");
      out.write("                                    Ghi chú khi thanh toán: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${OutInvoiceAndAccount.note}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-12 col-sm-5 text-grey text-90 order-first order-sm-last\">\n");
      out.write("                                    <div class=\"row my-2\">\n");
      out.write("                                        <div class=\"col-7 text-right\">\n");
      out.write("                                            Tổng\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-5\">\n");
      out.write("                                            <span class=\"text-120 text-secondary-d1\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${OutInvoiceAndAccount.totalMoney}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" VND</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row my-2\">\n");
      out.write("                                        <div class=\"col-7 text-right\">\n");
      out.write("                                            Thuế (0%)\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-5\">\n");
      out.write("                                            <span class=\"text-110 text-secondary-d1\">0</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row my-2 align-items-center bgc-proutary-l3 p-2\">\n");
      out.write("                                        <div class=\"col-7 text-right\">\n");
      out.write("                                            Tổng số tiền\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-5\">\n");
      out.write("                                            <span class=\"text-150 text-success-d3 opacity-2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${OutInvoiceAndAccount.totalMoney}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" VND</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <hr />\n");
      out.write("\n");
      out.write("                            <div>\n");
      out.write("                                <a href=\"outputInvoiceEdit?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${OutInvoiceAndAccount.outInvoiceId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"btn btn-info btn-bold px-4 float-right mt-3 mt-lg-0\">Edit</a>\n");
      out.write("                                <br/>\n");
      out.write("                                <br/>\n");
      out.write("                                <br/>\n");
      out.write("                                <br/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
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
