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
        <link rel="icon" type="image/png" href="images/dog.png">

    </head>
    <body>
        <div class="container">
            <div class="form-container">
                <div class="tab-control">
                    <h3 class="tab-control-btn register">Update profile</h3>
                </div>
                <h4 style="color: red">${error}</h4>
                <div class="register-form form active">
                    <form action="updateProfileControl" enctype="multipart/form-data" method="POST">
                        <input type="text" class="txt-input border" readOnly  name="username" value="${requestScope.account.username}">
                        <input type="text" class="txt-input border" readOnly name="email" value="${requestScope.account.email}">
                        <input type="password" class="txt-input border"  name="pass" value="${requestScope.account.pass}">
                        <input type="text" class="txt-input border" placeholder="Your Name" name="name" value="${requestScope.account.name}">
                        <input type="text" class="txt-input border" placeholder="Your Phone" name="phone" value="${requestScope.account.phone}">
                        <label for="image">
                            <img id="imagePreview" src="${requestScope.account.image}" class="image-profile" alt="Profile Image">
                        </label>
                        <input type="file" name="avatar" id="image" class="image-file">
                        <button type="submit" class="btn btn-login border">Submit</button>
                        <a href="home" class="btn btn-login border" style="background-color: grey; text-align: center;">Go back</a>
                    </form>
                </div>
            </div>
        </div>
        <script>
            window.onload = function () {
                var imagePreview = document.getElementById("imagePreview");

                document.querySelector(".image-file").addEventListener("change", function (e) {
                    if (e.target.files && e.target.files[0]) {
                        imagePreview.src = URL.createObjectURL(e.target.files[0]);
                    }
                });

                document.querySelector(".gender-select").addEventListener("change", function (e) {
                    if (e.target.value === "true") {
                        imagePreview.src = "images/user-male.jpg";
                    } else {
                        imagePreview.src = "images/user-female.jpg";
                    }
                });
            }
        </script>
    </body>
</html>
