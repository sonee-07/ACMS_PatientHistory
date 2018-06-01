<%@ page contentType="text/html;charset=UTF-8" import = "java.io.*, java.util.*, javax.servlet.*" language="java" %>
<html lang="en">
<head>
  <title>Patient Medical History</title>
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

         <form action="PatientForm_HandlerServlet" method="POST">
              
        
        <fieldset>

          <div class="wrap-input100">
                        <span class="label-input100">Doctor ID</span>
                        <input class="input100" name="doctor_id"  id="doctor_id" value = "${doctor_id}">
                        <span class="focus-input100"></span>
            <span class="label-input100">Patient Id:</span>&nbsp;&nbsp;&nbsp;
               <input type="text" id ="patient_id" name="patient_id" style="background-color: #cccccc;" required> 
            <span class="focus-input100"></span>
      </div>

<div class="maxl">
<span class="span_class">Reason for visit </span><br>
<div class="justified">
<textarea id="reason" name = "reason" style="float:left;" style="background-color: #cccccc;" placeholder="Enter here">  </textarea>

</div>
  
</div>

	<span class="span_class"> Let's see what you've got!    </span><br>
<div class="sel sel--black-panther">
  <select  id="select_condition" name="select_condition" onchange="changeCondition()">
    <option value="" disabled>Select a Condition</option>
    <option value="Backpain">Backpain</option>
    <option value="Thyphoid">Thyphoid</option>
    <option value="Diabetes">Diabetes</option>
    <option value="Migrane">Migrane</option>
    <option value="General">General</option>
  </select>
  
 
</div>
<br> <br> 
 <span class="span_class">Symptoms</span> &nbsp;&nbsp;&nbsp;
			
<br>
    <div class="pretty p-default">
        <input type="checkbox" name="symp" value ="0" />
        <div class="state p-primary radio inline">
            <label id="symptom1" name ="symptom1">Symptom1</label>
        </div>
    </div>
	<br>
    <div class="pretty p-default">
        <input type="checkbox" name="symp" value ="1"/>
        <div class="state p-primary radio inline">
            <label id="symptom2" name="symptom2">Symptom2</label>
        </div>
    </div>
<br>
    <div class="pretty p-default">
        <input type="checkbox" name="symp" value ="2"/>
        <div class="state p-primary radio inline">
            <label id="symptom3" name="symptom3">Symptom3</label>
        </div>
    </div><br>
<div class="pretty p-default">
        <input type="checkbox" name="symp" value ="3"/>
        <div class="state p-primary radio inline">
            <label id="symptom4" name="symptom4">Symptom4</label>
        </div>
    </div>
<br>
    <div class="pretty p-default">
        <input type="checkbox" name="symp" value ="4"/>
        <div class="state p-primary radio inline">
            <label id="symptom5" name="symptom5">Symptom5</label>
        </div>
    </div>
	
    <br> <br> 

<div class="maxl">
<span class="span_class">Do you consume Tobacco? </span><br>
<span class="radio inline"> 
      <input type="radio" name="tobacco" value="Yes" id= "yes_tob" >
      <span> Yes </span> 
   </span>
  <span class="radio inline"> 
      <input type="radio" name="tobacco" value="No" id="no_tob" checked>
      <span>No </span> 
  </span>
</div>
<br>

<div class="maxl">
 
  <span class="span_class"> Are you taking any Medication </span> 
<br>
  <span class="radio inline" value="medicine"> 
      <input type="radio" name="Medication" value="Yes" id= "yes_med"  onclick="showMedication();" style="background-color: #cccccc;" >
      <span> Yes </span> 
   </span>
  <span class="radio inline"> 
      <input type="radio" name="Medication" value="No" id="no_med" checked onclick="closeMedication();" style="background-color: #cccccc;">
      <span>No </span> 
  </span>

</div>


<div class="justified">
<textarea id="medications" name = "text_medication" style="float:left;" style="background-color: #cccccc;" placeholder="Enter here">  </textarea>

</div>

<div class="maxl">
  <span class="span_class"> Do you have any alergies? </span> &nbsp;&nbsp;&nbsp;<br>

  <span class="radio inline"> 
      <input type="radio" name="alergies" value="Yes" id= "yes_alg"  onclick="showAlergies();" style="background-color: #cccccc;">
      <span> Yes </span> 
   </span>
  <span class="radio inline"> 
      <input type="radio" name="alergies" value="No" id="no_alg" checked onclick="closeAlergies();" style="background-color: #cccccc;">
      <span>No </span> 
  </span>

</div>


<div class="justified" >
  
<textarea id="alergies" name = "text_alergies"> </textarea>

</div>

 <div class="maxl">
  <span class="span_class">  Do you consume Alchohol? </span> &nbsp;&nbsp;&nbsp;<br>
  <span class="radio inline"> 
      <input type="radio" name="Alchohol" value="Frequently" id= "yes_alc"  style="background-color: #cccccc;">
      <span> Daily </span> 
   </span>
  <span class="radio inline"> 
      <input type="radio" name="Alchohol" value="Weekly" id="week_alc" style="background-color: #cccccc;">
      <span>Weekly</span> 
  </span>
  <span class="radio inline"> 
      <input type="radio" name="Alchohol" value="Monthly" id="month_alc" style="background-color: #cccccc;">
      <span>Monthly</span> 
  </span>
  <span class="radio inline"> 
      <input type="radio" name="Alchohol" value="No" id="no_alc" checked style="background-color: #cccccc;">
      <span>Never </span> 
  </span>

</div>
  
<br> 

  <span class="span_class"> Enter Person Sugar levels: </span> 
  <input type="text" name="sugarLevel" id="sugarLevel" style="background-color: #cccccc;" required="required">

<br> <br>
  <span class="span_class" > Enter Blood Pressure: </span>  
  <input type="text"  id="bpLevel" name="bpLevel" style="background-color: #cccccc;" required ="required">
  
<br> <br>
  <span class="span_class"> Enter Weight in Kilogram: </span>  
  <input type="text" id="weightLevel" name="weightLevel" style="background-color: #cccccc;" required="required">              
        

        
<br> <br> <br>
	
	<div>

		<input type="submit"  value="Submit form" class="button_class button1">
	</div>

        </fieldset>
</form></div>
    </div>
  </div>


          <script src="js/index.js"></script>

          <script>

              $('.sel__box__options').click(function() { // onchange attribute
                  var txt = $(this).text();
                  var index = $(this).index();

                  $(this).siblings('.sel__box__options').removeClass('selected');
                  $(this).addClass('selected');

                  var $currentSel = $(this).closest('.sel');
                  $currentSel.children('.sel__placeholder').text(txt);
                  $currentSel.children('select').prop('selectedIndex', index + 1);

                  var sel_ = $('#select_condition :selected').text();
                  //alert($sel_);

                  if(sel_ == "Backpain"){


                      document.getElementById('symptom1').innerHTML = 'Lower back pain';
                      document.getElementById('symptom2').innerHTML = 'Inability to stand';
                      document.getElementById('symptom3').innerHTML = 'Unable to bend';
                      document.getElementById('symptom4').innerHTML = 'Unable to walk';
                      document.getElementById('symptom5').innerHTML = 'Difficulty to sit';

                  }

                  if(sel_ == "Thyphoid"){
                      $(symptom1).html("Muscle pain");
                      $(symptom2).html("Rashes");
                      $(symptom3).html("Fever");
                      $(symptom4).html("Nausea");
                      $(symptom5).html("Loss of appetite");
                  }

                  if(sel_ == "Diabetes"){
                      $(symptom1).html("Sudden weightloss");
                      $(symptom2).html("Always thirsty");
                      $(symptom3).html("Heavy breathing");
                      $(symptom4).html("Slow healing cuts");
                      $(symptom5).html("Nausea");
                  }

                  if(sel_ == "Migrane"){
                      $(symptom1).html("TenderScalp");
                      $(symptom2).html("Mild Headache");
                      $(symptom3).html("Depressed?");
                      $(symptom4).html("Dizziness");
                      $(symptom5).html("Nasal congestion");
                  }


                  if(sel_ == "General"){
                      $(symptom1).html("Head ache");
                      $(symptom2).html("Fever");
                      $(symptom3).html("Cold");
                      $(symptom4).html("Cough");
                      $(symptom5).html("Body pains");
                  }

              });

          </script>

          <script type="text/javascript">
              function showMedication(){
                  document.getElementById('medications').style.display ='block';
              }

              function closeMedication(){
                  document.getElementById('medications').style.display ='none';
              }

              function showAlergies(){
                  document.getElementById('alergies').style.display ='block';
              }

              function closeAlergies(){
                  document.getElementById('alergies').style.display ='none';
              }
          </script>

</body>
</html>