<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 24/5/18
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import = "java.io.*, java.util.*, javax.servlet.*" language="java" %>
<html>
<head>
    <title>Prescription form</title>
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
    <div class="container-login100">
        <div class="login100-more" style="background-image: url('images/3.jpg');"></div>

        <div class="wrap-login100 p-l-50 p-r-50 p-t-72 p-b-50">

            <form action="SendToS3Servlet" method="GET">


                <fieldset>

                    <div class="wrap-input100">


                        <span class="label-input100">Doctor ID</span>
                        <input class="input100" name="doctor_id"  id="doctor_id" value = "${DoctorId}" readonly>
                        <span class="focus-input100"></span>
                        <span class="label-input100">Patient ID</span>
                        <input class="input100" name="patient_id" placeholder="User Id" id="patient_id" value = "${PatientId}" readonly>
                        <span class="focus-input100"></span>
                    </div>
                    <span class="span_class">Reason for visit:</span> &nbsp;&nbsp;&nbsp;
                    <input type="text" id ="reason"  name="reason" style="background-color: #cccccc;" value = "${Reason}" readonly> <br>
                    <span class="span_class">Condition:</span> &nbsp;&nbsp;&nbsp;
                    <input type="text" id ="condition" name="condition"  style="background-color: #cccccc;" value = "${Condition}" readonly> <br>
                    <span class="span_class">Symptoms:</span> &nbsp;&nbsp;&nbsp;
                    <input type="text" id ="symptoms" name="symptoms" style="background-color: #cccccc;" value = "${Symptoms}" readonly> <br>
                     <br><br>

                    <div class="maxl">
                        <span class="span_class">Tobacco Comsumption: </span><br>
                        <input type="text" id ="tobacco"  name="tobacco" style="background-color: #cccccc;" value = "${Tobacco}" readonly>
                    </div>
                    <br>

                    <div class="maxl">

                        <span class="span_class"> Medication </span>
                        <br>
                        <input id="medication" name = "medication" style="background-color: #cccccc;"  value = "${Medication}" readonly>

                    </div>

                    <div class="maxl">
                        <span class="span_class"> Allergies </span> &nbsp;&nbsp;&nbsp;<br>

                        <input id="allergies" name = "allergies" style="background-color: #cccccc;" value = "${Allergies}" readonly>

                    </div>


                    <div class="justified" >



                    </div>

                    <div class="maxl">
                        <span class="span_class"> Alchohol Consumption </span> &nbsp;&nbsp;&nbsp;<br>
                        <input type="text" id ="alchohol" name="alchohol" style="background-color: #cccccc;" value = "${Alchohol}" readonly>

                    </div>

                    <br>

                    <span class="span_class">Sugar levels: </span>
                    <input type="text" id ="sugar" name="sugar" style="background-color: #cccccc;" value = "${Sugar}" readonly>
                    <br> <br>
                    <span class="span_class" >Blood Pressure: </span>
                    <input type="text" id ="bp" name="bp" style="background-color: #cccccc;" value = "${BP}" readonly>

                    <br> <br>
                    <span class="span_class">Weight in Kilograms: </span>
                    <input type="text" id ="weight" name="weight" style="background-color: #cccccc;" value = "${weight}" readonly>

                    <fieldset>
                        <br>
                        <span class="span_class5"> Prescription:</span><br>

                        <textarea rows="8" cols="100" id ="prescription" name="prescription" style="background-color: #cccccc;" style="color: #a04646; " placeholder="Enter text here:" required> </textarea>
                        <span class="focus-input100"></span>
                        <br> <br> <br>

                        <div>
                            <input type="submit"  value="Submit form" class="button_class button1">
                        </div>


                    </fieldset>

                    </fieldset>
            </form>
            <form action="FetchFromS3Servlet" method="GET">
                <input  type="hidden"  name="patient_id"  id="patient_id2" value = "${PatientId}" readonly>
                <input type="submit"  value="Previous History" class="button_class button1">
            </form>
        </div>
    </div>
</div>

<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->

<!--  <form action="Myservlet2">
	<input type="submit" value = "Send"  class="button_class button1">
</form>
-->
<script src="js/index.js"></script>


</body>
</html>
