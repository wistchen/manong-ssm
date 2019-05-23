/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-05-22 05:11:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import pojo.EasyUITree;
import java.util.List;

public final class product_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<title>商品添加</title>\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"ueditor/ueditor.config.js\"></script>\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"ueditor/ueditor.all.min.js\"> </script>\n");
      out.write("<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->\n");
      out.write("<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"ueditor/lang/zh-cn/zh-cn.js\"></script>\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/js/product_add.js\"></script>\n");
      out.write("\n");
      out.write("\n");

    List<EasyUITree> list =  (List<EasyUITree>) session.getAttribute("categories");

      out.write("\n");
      out.write("\n");
      out.write("<div style=\"padding: 10px 10px 10px 10px;\">\n");
      out.write("    <form id=\"productAddForm\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"categoryId\">\n");
      out.write("        <input type=\"hidden\" name=\"image\">\n");
      out.write("        <input type=\"hidden\" name=\"description\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        <table cellpadding=\"10px\">\n");
      out.write("            <tr>\n");
      out.write("                <td>商品名称</td>\n");
      out.write("                <td><input class=\"easyui-textbox\" name=\"name\" data-options=\"required:true\" style=\"width:800px\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>商品分类</td>\n");
      out.write("                <td>\n");
      out.write("                    <select id=\"cc\" class=\"easyui-combobox\" name=\"cid\" style=\"width: 200px;\">\n");
      out.write("                        <option value=\"0\">请选择</option>\n");
      out.write("                        ");

                            for(int i=0;i<list.size();i++){
                                EasyUITree item = list.get(i);
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(item.getId());
      out.write('"');
      out.write('>');
      out.print(item.getText());
      out.write("</option>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("\n");
      out.write("                    <p id=\"cbox\" style=\"display: none\"></p>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>市场价格</td>\n");
      out.write("                <td>\n");
      out.write("                    <input class=\"easyui-numberbox\" value=\"100\"\n");
      out.write("                           data-options=\"min:1,max:99999999,precision:2,required:true\"\n");
      out.write("                           style=\"width:800px\" name=\"maketPricePreview\">\n");
      out.write("                    <input type=\"hidden\" name=\"maketPrice\">\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>商品价格</td>\n");
      out.write("                <td>\n");
      out.write("                    <input class=\"easyui-numberbox\" value=\"100\"\n");
      out.write("                           data-options=\"min:1,max:99999999,precision:2,required:true\"\n");
      out.write("                           style=\"width:800px\" name=\"pricePreview\">\n");
      out.write("                    <input type=\"hidden\" name=\"price\">\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>商品编号</td>\n");
      out.write("                <td>\n");
      out.write("                    <input class=\"easyui-numberbox\" data-options=\"required:true\"\n");
      out.write("                           style=\"width:800px\" name=\"productNumber\">\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>商品主图</td>\n");
      out.write("                <td>\n");
      out.write("                    <input id=\"fileName\" name=\"uploadfile\"/>\n");
      out.write("                    <a  href=\"#\" class=\"easyui-linkbutton uploadPic\">上传图片</a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>主图预览</td>\n");
      out.write("                <td>\n");
      out.write("                    <img src=\"\" id=\"img\" width=\"376\" height=\"190\">\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>商品描述</td>\n");
      out.write("                <td>\n");
      out.write("                    <script id=\"editor\" type=\"text/plain\" style=\"width:800px;height:500px;\"></script>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </form>\n");
      out.write("    <div align=\"center\">\n");
      out.write("         <a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" onclick=\"submitForm()\")>提交</a>\n");
      out.write("         <a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" >重置</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("    $(function () {\n");
      out.write("        MANONG.init();\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    function submitForm() {\n");
      out.write("        $(\"#productAddForm\").find(\"input[name='description']\").val(UE.getEditor('editor').getContent());\n");
      out.write("        $(\"#productAddForm\").find(\"input[name='price']\").val(eval($(\"#productAddForm\").find(\"input[name='pricePreview']\").val())*100);\n");
      out.write("        $(\"#productAddForm\").find(\"input[name='maketPrice']\").val(eval($(\"#productAddForm\").find(\"input[name='maketPricePreview']\").val())*100);\n");
      out.write("        console.log($(\"#productAddForm\").serialize());\n");
      out.write("        $.post(\"/product_save\",$(\"#productAddForm\").serialize(),function (data) {\n");
      out.write("            if(data.status == 200){\n");
      out.write("               $.messager.alert('提示','成功添加商品');\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
