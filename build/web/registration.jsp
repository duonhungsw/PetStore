<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <link rel="icon" type="image/png" href="images/dog.png"">
    </head>
    <body>
        <div class="container">
            <div class="form-container">
                <div class="tab-control">
                    <h3 class="tab-control-btn register">Register</h3>

                </div>
                <h4 style="color: red">${error}</h4>

                <div class="register-form form active">
                    <form action="registration" enctype="multipart/form-data" method="POST">
                        <input type="text" class="txt-input border" placeholder="Username" name="user-name" >
                        <input type="text" class="txt-input border" placeholder="Email" name="user-email">
                        <h4 style="color: red">${email}</h4>

                        <input type="password" class="txt-input border" placeholder="Password" name="user-pass" > 
                        <input type="password" class="txt-input border" placeholder="Re Password" name="user-repeatpass" >
<!--                        <label for="image">
                            <img id="imagePreview" src="images/user-male.jpg" class="image-profile" alt="">
                            <select name="gender" class="txt-input border gender-select" id="">
                                <option value="true">Male</option>
                                <option value="false">Female</option>
                            </select>
                        </label> 
                        <input type="file"  name="avatar" id="image" class="image-file">-->
                        <button type="submit" class="btn btn-login border">Submit</button>

                        <a href="login" class="btn btn-login border" style="background-color: grey; text-align: center;">Go back</a>
                    </form>
                </div>
            </div>
        </div>
        <script>
            window.onload = function () {
                var imageFile = document.querySelector(".image-profile");

                document.querySelector(".image-file").addEventListener("change", function (e) {
                    imageFile.src = URL.createObjectURL(e.target.files[0]);
                });

                document.querySelector(".gender-select").addEventListener("change", function (e) {
                    if (e.target.value == "true") {
                        imagePreview.src = "images/user-male.jpg";
                    } else {
                        imagePreview.src = "images/user-female.jpg";
                    }
                });
            }
        </script>
    </body> 

</html>
