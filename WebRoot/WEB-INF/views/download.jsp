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
  </head>
  
  <body>
   <!-- header部分 -->

     <%@include file="title.jsp" %>
     
   <!-- 结束header部分 -->
   
   <div class="container">
      <h3>下载</h3>    
      <div class="table-responsive">
         <table class="table table-hover">
            <tr>
             <th class="success">题目</th>
             <th class="success">Java文件</th>
             <th class="success">Cpp文件</th>
            </tr>
            <c:forEach var="file" items="${files }">
                  <tr>
                    <td class="active">${file.title }</td>
                    <td class="warning">
                      <c:choose>
                         <c:when test="${file.j_file != '' }">
                             <a href="${file.j_file }">
                          <img src="http://bcs.duapp.com/czpresource/download_j.png">
                            </a>
                         </c:when>
                         <c:otherwise>
                            <img src="http://bcs.duapp.com/czpresource/download.png">
                         </c:otherwise>
                      </c:choose>
                    </td>
                    <td class="warning">
                    <c:choose>
                         <c:when test="${file.c_file != '' }">
                             <a href="${file.c_file}">
                          <img src="http://bcs.duapp.com/czpresource/download_c.png">
                            </a>
                         </c:when>
                         <c:otherwise>
                            <img src="http://bcs.duapp.com/czpresource/download.png">
                         </c:otherwise>
                      </c:choose>
                    </td>
                  </tr>
            
            </c:forEach>
       </table>
       </div>
   <ul class="pagination">
       <c:choose>
          <c:when test="${currentPage == 1 }">
             <li class="disabled"><a href="#">&laquo;</a></li>
          </c:when>
          <c:otherwise>
             <li><a href="/download/${currentPage -1}">&laquo;</a></li>
          </c:otherwise>
       </c:choose>
     <c:forEach var="x" begin="1" end="${pages }" step="1">
         <c:choose>
            <c:when test="${x == currentPage }">
              <li class="active">
              <a href="/download/${x }">${x }<span class="sr-only">(current)</span></a>
              </li>      
            </c:when>
            <c:otherwise>
                <li><a href="/download/${x }">${x }</a></li>
            </c:otherwise>
         </c:choose>       
     </c:forEach>
     
     <c:choose>
        <c:when test="${currentPage == pages }">
             <li class="disabled"><a href="#">&raquo;</a></li>
        </c:when>
        <c:otherwise>
             <li><a href="/download/${currentPage + 1}">&raquo;</a></li>
        </c:otherwise>
     </c:choose>
  </ul>
  
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