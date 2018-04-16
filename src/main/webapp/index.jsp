<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript">
      function exprotsap(){
        $("#saptype").val("sap");
        $("#sap").submit();

      }
    </script>
  </head>
  <body>
  <div>
    <form id="sap" action="{pageContext.request.contextPath }/sapexprot/exce/sapData">
      <input type="hidden" id="saptype" name="saptypename" value="<s:property value="saptayevalue" />" />

    </form>
    <span><button onclick="exprotsap()"  />daochu</span>
  </div>



  </body>
</html>
