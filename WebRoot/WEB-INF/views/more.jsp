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
  background-color: #f1f1f1;
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
  
   <body>

     <!-- header部分 -->

     <%@include file="title.jsp" %>
     
     <!-- 结束header部分 -->
     
     <div class="container">
     <div class="row">
     <div class="col-md-8 col-md-offset-2">
     <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="http://bcs.duapp.com/czpresource/Img/bg/6.jpg" alt="pig1">
      <div class="carousel-caption">
                   编程
      </div>
    </div>
    <div class="item">
      <img src="http://bcs.duapp.com/czpresource/Img/bg/4.png" alt="pig1">
      <div class="carousel-caption">
      共享
      </div>
    </div>
    <div class="item">
      <img src="http://bcs.duapp.com/czpresource/Img/bg/2.png" alt="pig1">
      <div class="carousel-caption">
     有你更精彩
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div>
     </div>
     
     <div class="col-md-2">
     <img alt="二维码" src="http://bcs.duapp.com/czpresource/code.jpg" class="img-responsive">
     扫一扫，关注我们的微信平台
     
     </div>
     
    
    </div> 
    
    <br/>
    <div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">我们是谁<span class="glyphicon glyphicon-info-sign"></span></h3>
  </div>
  <div class="panel-body">
    我们是西北工业大学软件工程专业的CodeForGod团队
  </div>
   <div class="panel-heading">
    <h3 class="panel-title">投稿说明<span class="glyphicon glyphicon-import"></span></h3>
  </div>
  <div class="panel-body">
   本站欢迎大家投稿，原创，修改等都可以。联系邮箱：chenloveit@gmail.com
  </div>
  <div class="panel-heading">
    <h3 class="panel-title">免责声明<span class="glyphicon glyphicon-warning-sign"></span></h3>
  </div>
  <div class="panel-body">
   本站及依托的微信平台是完全公益的，涉及的图片、题目均来自网络
  </div>
</div>
       <footer>
        <p>&copy; CodeForGod 2014</p>
      </footer>
     </div>
     
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1000401653'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "v1.cnzz.com/z_stat.php%3Fid%3D1000401653%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
     </body>
    </html>