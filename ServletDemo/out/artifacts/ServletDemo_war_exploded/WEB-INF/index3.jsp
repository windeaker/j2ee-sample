<%--
  Created by IntelliJ IDEA.
  User: windeaker
  Date: 2019/2/15
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <div>
    <button onclick="afterOnClick('ServletWRSDemo?testParam=hhh')"><img src="./static/img/heiheihei.jpg"></button>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
    <script type="text/javascript">
      function afterOnClick(url){
        $.ajax({
          url: url,
          type: "GET",
          success: function (result) {
            alert(result);
            window.location.href='#';
          }
        })
      }

    </script>
  </div>
  </body>
</html>
