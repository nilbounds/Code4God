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
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

     <!-- header部分 -->

     <%@include file="title.jsp" %>
     
     <!-- 结束header部分 -->
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>欢迎你</h1>
        <p>本网站由CodeForGod团队维护，是个免费公益的平台，旨在给热爱编程的朋友带来便利。
        请关注微信公共账号 一天一道算法题 (微信号：code4god)。
        <img src="http://bcs.duapp.com/czpresource/bug.png" class="img-responsive">
        </p>
        

        
        <a class="btn btn-primary btn-lg" role="button" href="/more">更多介绍 &raquo;</a>
             <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">欢迎捐赠 &raquo;</button>
     
     <!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">谢谢你的捐赠</h4>
      </div>
      <div class="modal-body">
    <p>请使用支付宝钱包扫一扫：</p>  
      <img alt="捐赠" src="http://bcs.duapp.com/czpresource/zhifu.png" class="img-responsive">
        <!--   我们是个公益的平台，希望有更多的热心人士对本站进行捐赠，以为大家提供更优质的服务。
         <a href="https://me.alipay.com/codeforgod" class="btn btn-info btn-lg" 
         role="button" target="_blank" onclick="$('#myModal').modal('hide');">同意捐赠</a>  -->
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

         <c:if test="${admin !=null }">
         <form class="navbar-form" style="display:inline" role="form" method="post" action="manage">
           <button type="submit" class="btn btn-success btn-lg">管理工程 &raquo;</button>
        </form>
        </c:if>
<p>
<c:if test="${validLogin !=null && validLogin == false }">
<div class="row">
<div class="alert alert-info alert-dismissable col-md-3 col-md-offset-4">
用户名或密码错误！
  <a class="close" data-dismiss="alert" href="#" aria-hidden="true">&times;</a>
</div>
</div>
</c:if>
</p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>问题 <span class="glyphicon glyphicon-eye-open"></span></h2>
          <p>今日问题:${TodayTitle }</p>
          <p><a class="btn btn-default" href="/detail" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>讨论 <span class="glyphicon glyphicon-globe"></span></h2>
          <p>讨论区暂不开放。</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>下载 <span class="glyphicon glyphicon-download-alt"></span></h2>
          <p>提供.cpp和.java解决方案。    
        </p>
          <p><a class="btn btn-default" href="/download/1" role="button">View details &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; CodeForGod 2014</p>
      </footer>
    </div> <!-- /container -->
    




    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1000401653'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "v1.cnzz.com/z_stat.php%3Fid%3D1000401653%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
  </body>
</html>

