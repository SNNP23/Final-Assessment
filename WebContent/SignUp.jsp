<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
<style>
body {
  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ckxLOooJJb4tZi_AGFflKx6PFw2evGgsWw&usqp=CAU');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
fieldset {
  background-color: #eeeeee;
  width:400px;
  align:centre;  
  line-height:1.8;"
}
legend {
  background-color: gray;
  color: white;
  padding: 10px 20px;
}
input {
  margin: 10px;
}
</style>
</head>
<body>
<div class="container">
<form action="SignUp" method="get">
<fieldset color="white">
<legend>SignUp Details</legend>
<pre>    
User Name:    <input type="text" name="username" id="username" placeholder="UserName"  required> <label id="username"for="username" style="color:red; visibility: hidden;">Invalid Username</label>
Password:     <input type="password" name="password" id="password" placeholder="Password" title="Must contain at least one number and one uppercase and lowercase letter, and at least 5 or more characters" required><label id="password"for="password" style="color:red; visibility: hidden;">Invalid password</label>
Employee ID:  <input type="number" name="id" id="id" placeholder="Employee No." pattern="/^\d{3}$/" required"><label id="id"for="id" style="color:red; visibility: hidden;">Invalid Employee ID</label>
First Name:   <input type="text" name="fname" id="fname" placeholder="First Name" required>
Last Name:    <input type="text" name="lname" id="lname" placeholder="Last Name" required>
Phone Number: <input type="number" name="phone" id="phone"placeholder="Ex:1234567890" pattern="[-+]?[0-9]" type="tel" maxlength="10" required><label id="phone"for="phone" style="color:red; visibility: hidden;">Invalid phone number</label>
Email-Id:     <input type="email" name="email" id="email" placeholder="Ex:Employee@Supreme.com"  required><label id="email"for="email" style="color:red; visibility: hidden;">Invalid E-mail ID</label>
Designation:  <input type="text" name="designation" id="designation" placeholder="Ex:Programmer Analyst" required>
Address:      <input type="text area" name="address" id="address" placeholder="Enter Postal Address with pin code" rows="3" cols="20" required>
Gender:       <input type="radio" id="male" name="gender"  value="male"><label for="male">Male</label>
              <input type="radio" id="female" name="gender" value="female"><label for="female">Female</label>
              <input type="radio" id="other" name="gender" value="other"><label for="other">Other</label>
Skill Set:    <input type="radio" id="skill1" name="skill" value="C Programming"><label for="skill"> C Programming</label>
              <input type="radio" id="skill2" name="skill" value="JAVA"><label for="skill">JAVA</label>
              <input type="radio" id="skill3" name="skill" value="C#"><label for="skill">C#</label>
              <input type="radio" id="skill4" name="skill" value=".Net"><label for="skill">.Net</label>
              <input type="radio" id="skill5" name="skill" value="SalesForce"><label for="skill">SalesForce</label>
Salary:       <input type="number" name="salary" id="salary" placeholder="Salary" required>
<input type ="reset" value="Reset"><input type="submit" Value="SignUp">
</pre>
</fieldset>
</form>
</div>
</body>
<!-- pattern="/^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]$/"
 pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,}"
 pattern="/[a-zA-Z0-9]+@Supreme\.com/"-->
<script>
         function validate(){
            var var1=document.getElementById("username");
            var var2=document.getElementById("email");
            var var3=document.getElementById("password");
            var var4=document.getElementById("phone");
            var var5=document.getElementById("id");
            var exp=/^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$/;
            var exp1=/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
            var exp2=/[a-zA-Z0-9]+@Supreme\.com/;
            var exp3 = /^\d{10}$/;
            var exp4 = /^\d{3}$/;
            if(var1.value.trim()==""){
                alert("Enter Username");
                document.getElementById("name").style.visibility="visible";             
                return false;
            }else if(var2.value.trim()==""){
                alert("Enter E-mail id");
                document.getElementById("email").style.visibility="visible";
                return false;
            }else if(var3.value.trim()==""){
                alert("Enter Password");
                document.getElementById("pass").style.visibility="visible";
                return false;
            }
            else if(var3.value.trim().length<6){
                alert("password length must be equal to or more than 6");
                return false;
            }
            /*else if((var4.value.length)=!10){
                alert("Invalid Phone number");
                return false;
            }
            else if((var5.value.trim().length)=!3){
                alert("Invalid Employee ID");
                return false;
            } */
           else{
                if((exp.test(var1.value))&&(exp1.test(var3.value))&&(exp4.test(var5.value))&&(exp3.test(var4.value))&&(exp2.test(var2.value))){
                    alert("valid");
                    return true;
                }else{
                    alert("invalid");
                    return false;
                }
           }
         }
           
           
</script>

</html>