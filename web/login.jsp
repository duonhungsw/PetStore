<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="icon" type="image/png" href="images/dog.png"">

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
            .form-signin, .form-reset {
                margin-bottom: 15px;
            }
            .social-login {
                text-align: center;
                margin-bottom: 15px;
            }
            .facebook-btn {
                background-color: #3b5998;
                color: white;
                margin-bottom: 10px;
            }
            .google-btn {
                background-color: #db4437;
                color: white;
                margin-bottom: 10px;
            }
            .social-btn {
                width: 100%;
                margin: 10px 0;
            }
            .form-control {
                margin-bottom: 10px;
            }
            .btn-block {
                margin-bottom: 10px;
            }
            .btn-signup {
                margin-top: 10px;
            }
            #forgot_pswd, #cancel_reset {
                display: block;
                text-align: center;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div id="logreg-forms">
                <form class="form-signin" action="login" method="post">
                    <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Sign in</h1>
                    <div class="social-login">
                        <button class="btn social-btn facebook-btn" type="button"><span><i class="fab fa-facebook-f"></i> Sign in with Facebook</span></button>
                        <button class="btn social-btn google-btn" type="button" onclick="window.location.href = 'https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:9999/PetStore/loginGoogleControl&response_type=code&client_id=821996352898-56ok23j4hbfntl1jotknqno7qubtol1b.apps.googleusercontent.com&approval_prompt=force'">
                            <span><i class="fab fa-google-plus-g"></i> Sign in with Google+</span>
                        </button>
                    </div>
                    <p style="text-align:center">OR</p>
                    <input type="text" name="email" id="inputEmail" class="form-control" placeholder="Email/Username" required="" autofocus="">
                    <input type="password" name="pass" id="inputPassword" class="form-control" placeholder="Password" required="">
                    <h4 style="color: red">${accounterror}</h4>
                    <h4 style="color: red">${exist}</h4> 
                    <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
                    <a href="forgotPassword" id="forgot_pswd">Forgot password?</a>
                    <hr>
                    <button class="btn btn-primary btn-block btn-signup" type="button" onclick="window.location.href = 'signup'"><i class="fas fa-user-plus"></i> Sign up New Account</button>
                </form>
            </div>
        </div>

    </body>
</html>