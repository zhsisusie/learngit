package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>登录</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("@CHARSET \"UTF-8\";\r\n");
      out.write("/*全局控制*/\r\n");
      out.write("* {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tfont-family: \"宋体\";\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("\tcolor: #e3e3e3;\r\n");
      out.write("\tbackground-color: #606870;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul {\r\n");
      out.write("\tlist-style: none; /*list-style 简写属性在一个声明中设置所有的列表属性*/\r\n");
      out.write("\tmargin: 10px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li {\r\n");
      out.write("\tmargin: 3px 1px;\r\n");
      out.write("\tline-height: 24px;\r\n");
      out.write("\theight: 24px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li:hover {\r\n");
      out.write("\tbackground-color: #eee;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("\tline-height: 24px;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("fieldset {\r\n");
      out.write("\theight: 120px;\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\ttext-align:\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/static/js/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/static/js/login.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<fieldset>\r\n");
      out.write("\t\t<legend>登录</legend>\r\n");
      out.write("\t\t<!-- 在字段集包含的文本和其它元素外面画一个方框 -->\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><span>用户名:</span><input type=\"text\" id=\"txtName\" /></li>\r\n");
      out.write("\t\t\t<li><span>密码:</span><input type=\"password\" id=\"txtPassword\" /></li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<button id=\"btnLogin\">登录</button>\r\n");
      out.write("\t\t\t\t<button id=\"btnReset\" type=\"reset\">重置</button>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<span id=\"msg\"></span>\r\n");
      out.write("\t</fieldset>\r\n");
      out.write("\t<!-- legend域标题  在 fieldSet 对象绘制的方框内插入一个标题 -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
