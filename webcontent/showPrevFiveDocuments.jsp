<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 25/5/18
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Past Records</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" href="css/jquery_ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="js/jquery_1.12.4.js"></script>

    <script src="js/jqueryui.js"></script>

    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Lato|Quicksand'>
    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/checkbox.css">

    <link data-require="jqueryui@*" data-semver="1.10.0" rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.0/css/smoothness/jquery-ui-1.10.0.custom.min.css" />
    <script data-require="jqueryui@*" data-semver="1.10.0" src="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.0/jquery-ui.js"></script>
    <script data-require="jquery@*" data-semver="2.1.1" src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.0/css/smoothness/jquery-ui-1.10.0.custom.min.css" />

    <script src="http://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.0/jquery-ui.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.0/jquery.min.js"></script>
    <style>
        div.justified {
            display: flex;
            justify-content: center;
        }
    </style>

</head>
<body style="background-color: #999999;">

<div class="limiter">
    <div class="container-login100"style="text-align:center">
        <div class="login100-more" style="background-image: url('images/3.jpg');"></div>

        <div class="wrap-login100 p-l-50 p-r-50 p-t-72 p-b-50" style="text-align:center">

            <form action="ServletPDF_HTML_PAGE" method="GET" style="text-align:center">

                    <b>
                        <table style="width:50%" style="text-align:center" class="input100">
                            <tr>
                                <th> Date &nbsp </th>
                                <th> Reason for visit </th>
                                <th> Form </th>
                            </tr>
                            <tr>
                                <td>${date1}</td>
                                <td>${reason1}</td>
                                <td><a href= "${link1}" >document1</a></td>
                            </tr>
                            <tr>
                                <td>${date2}</td>
                                <td>${reason2}</td>
                                <td><a href= "${link2}" >document2</a></td>
                            </tr>
                            <tr>
                                <td>${date3}</td>
                                <td>${reason3}</td>
                                <td><a href= "${link3}" >document3</a></td>
                            </tr>
                            <tr>
                                <td>${date4}</td>
                                <td>${reason4}</td>
                                <td><a href= "${link4}" >document4</a></td>
                            </tr>
                            <tr>
                            <td>${date5}</td>
                            <td>${reason5}</td>
                            <td><a href= "${link5}" >document5</a></td>
                        </tr>
                        </table>
                    </b>
            </form>>
        </div>

    </div>

</div>

</body>
</html>

</head>
<body>

</body>
</html>
