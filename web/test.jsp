ksjdfkjhsdk

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            .styled-url {
                display: inline-block;
                padding: 10px 20px;
                background-color: #007bff;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                font-size: 16px;
                font-weight: bold;
                transition: background-color 0.3s ease;
            }

            .styled-url:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <p style="text-align: center; margin-top: 20px;">
            <a href="http://localhost:9999/PetStore/confirmResetPassword?token=${token}" class="styled-url">Confirm Reset Password</a>
        </p>
    </body>
</html>
