 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Testing</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/home">算法一道</a>
        </div>
        
        <c:choose>
          <c:when test="${admin!=null}">  
          <!-- 显示人名的div开始 -->
          <div class="navbar-collapse collapse navbar-right">
          <div class="navbar-brand  glyphicon glyphicon-user">
           ${admin.name }
          </div>   
           </div>
            <!-- 显示人名的div结束 -->
          </c:when>
         
         <c:otherwise>
                <div class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" role="form" method="post" action="login">
            <div class="form-group">
              <input type="email" placeholder="Email" class="form-control" name="email" required>
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control" name="pwd" required>
            </div>
            <button type="submit" class="btn btn-success">登录</button>
          </form>
        </div><!--/.navbar-collapse -->
         </c:otherwise>
        </c:choose>
    
   
      </div>
    </div>