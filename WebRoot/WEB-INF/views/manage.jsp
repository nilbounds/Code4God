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
  <link href="<%=basePath %>resources/css/nav.css" rel="stylesheet">
  <script type="text/javascript" src="<%=basePath %>ckeditor/ckeditor.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>算法题</title>

     <style type="text/css">
          body {
  background-color: #CCC;
          }
     </style>
<!--          <style type="text/css">
a:link {color: #CCC}
a:hover{color: #000}
</style> -->
    <!-- Bootstrap core CSS -->
    <link href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">

    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  
  
  <body>
   <%@include file="title.jsp" %>
    <br/><br/><br/>
     <div class="container">

      <div class="masthead">
        <ul class="nav nav-tabs nav-justified navbar-collapse collapse">
          <li><a href="#addProblem" data-toggle="tab">添加题目</a></li>
          <li><a href="#manageSolution" data-toggle="tab">管理题目</a></li>
          <li><a href="#statistic" data-toggle="tab">分析统计</a></li>
          <li><a href="#cleanup" data-toggle="tab">清除数据</a></li>
        </ul>
      </div>

      <!-- Jumbotron -->
      <div class="jumbotron">
       <div class="tab-content">
          <div class="tab-pane" id="addProblem">
             <!-- 添加题目 -->
             <form action="add" method="post"  role="form" id="problem">
             <input class="form-control" type="text" id="title" name="title" placeholder="标题" required></input>
             <textarea class="form-control" name="content" id="content" rows="10" rows="8"
              >题目:</textarea>
            
             <textarea class="form-control" name="solution" id="solution" rows="10" rows="8"
              >分析:</textarea>
             <script type="text/javascript">CKEDITOR.replace('content'); CKEDITOR.replace('solution');</script>
             <button type="submit" class="btn btn-success">添加</button>
             </form>
             <!-- 添加题目结束 -->
          </div>
            <div class="tab-pane active" id="manageSolution">
            <form>
              <div class="row">
                <div class="col-md-6 col-md-offset-3">
                 <div class="input-group">
                    <input type="text" class="form-control" x-webkit-speech placeholder="题目id">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Search</button>
                     </span>
                 </div><!-- /input-group -->
                
                </div>
              
              </div>
               
            </form>
                
            2222222222222222222
          </div>
            <div class="tab-pane" id="statistic">
         333333333333333333
          </div>
            <div class="tab-pane" id="cleanup">
         44444444444444444
          </div>
       </div>
       
      </div>
      <!-- Site footer -->
      <div class="footer">
        <p>&copy; CodeForGod 2014</p>
      </div>

    </div> <!-- /container -->
   
    
   <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
   
    
  </body>
  
  </html>