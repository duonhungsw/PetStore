<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="stylesheet" href="CSS/style.css">
        <style>
            body, html {
                height: 100%;
            }
            .container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100%;
            }
            #logreg-forms {
                width: 100%;
                max-width: 400px;
                padding: 15px;
                margin: auto;
            }
            .form-reset {
                margin-bottom: 15px;
            }
            .form-control {
                margin-bottom: 10px;
            }
            .btn-block {
                margin-bottom: 10px;
            }
            #cancel_reset {
                display: block;
                text-align: center;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div id="logreg-forms">
                <form action="forgotPassword" class="form-reset" method="post">
                    <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Enter your email</h1>
                    <h4 style="color: red">${errorEmail}</h4>
                    <h4 id="message" style="color: chocolate">${message}</h4>
                    <input type="email" name="email" id="resetEmail" class="form-control" placeholder="Email address" required="" autofocus="">
                    <button id="confirmButton" class="btn btn-primary btn-block" type="submit">Confirm</button>
                    <a href="login" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
                </form>
            </div>
        </div>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var message = document.getElementById('message').textContent.trim();
                if (message) {
                    document.getElementById('confirmButton').style.display = 'none';
                    document.getElementById('cancel_reset').style.display = 'none';
                    document.getElementById('resetEmail').style.display = 'none';
                }
            });
        </script>
    </body>
</html>