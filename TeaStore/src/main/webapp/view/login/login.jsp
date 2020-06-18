<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Loding font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,700" rel="stylesheet">

    <!-- Custom Styles -->
    <link rel="stylesheet" type="text/css" href="./styles.css">

    <%--CSS样式--%>
    <%--<%@ include file="/include/link_css.jsp" %>--%>
    <%--CSS样式--%>

    <title>Login</title>
  </head>
  <body>

    <!-- Backgrounds -->

    <div id="login-bg" class="container-fluid">

      <div class="bg-img"></div>
      <div class="bg-color"></div>
    </div>

    <!-- End Backgrounds -->

    <div class="container" id="login">
        <div class="row justify-content-center">
        <div class="col-lg-8">
          <div class="login">

            <h1>Login</h1>

            <!-- Loging form -->
                  <form action="${pageContext.request.contextPath }/User?method=login" method="post" id="loginForm">
                    <div class="form-group">
                      <input type="text" name="accountnumber" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="AccountNumber">

                    </div>
                    <div class="form-group">
                      <input type="password" name="pwd" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>

                    <br>
                    <button type="submit" class="btn btn-lg btn-block btn-success">登录</button>

                    <div class="register-link m-t-15 text-center">
                      <p>没有账号? <a href="${pageContext.request.contextPath }/view/register.jsp"> 在此注册</a></p>
                    </div>
                  </form>
             <!-- End Loging form -->

          </div>
        </div>
        </div>
    </div>


  </body>
</html>