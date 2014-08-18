<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
  <link rel="icon" href="favicon.ico" type="image/x-icon" />
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
  
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>算法题</title>

     <style type="text/css">
          body {
  padding-top: 50px;
  padding-bottom: 20px;
  background-color: #CCC;
          }
     </style>
    <!-- Bootstrap core CSS -->
    <link href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body onload="prettyPrint()">
    <!-- header部分 -->

     <%@include file="title.jsp" %>
     
    <!-- 结束header部分 -->
     
     <div class="container">
     
     <h2>${historyProblem.title}</h2>
     <p>
     ${historyProblem.content}
     </p>
     <h2>
             问题分析
     </h2>
     <p>
      <pre class="prettyprint">
      ${historyProblem.solution }
       </pre>
     </p>
        <!-- Site footer -->
        <div class="footer">
        <p>&copy; CodeForGod 2014</p>
        </div>
        <!-- end of footer -->
     </div>
       
   <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>resources/js/run_prettify.js"></script>
    
    <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1000401653'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "v1.cnzz.com/z_stat.php%3Fid%3D1000401653%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
  </body>