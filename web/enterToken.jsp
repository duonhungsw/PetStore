<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Token Verification</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <style>
        .timer {
            font-size: 2em;
            color: #333;
        }
        .container {
            max-width: 500px;
            margin-top: 50px;
        }
        .card {
            padding: 20px;
        }
        .timer {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
    <body>
        <div class="container">
            <div class="card">
                <h2 class="text-center">Enter Token</h2>
                <div class="timer" id="countdown" style="color: red">120</div>
                <form action="validTokenControl" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="token">Token:</label>
                        <input type="text" class="form-control" id="token" name="token" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                </form>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <script>
            // JavaScript for Countdown Timer
            var timeLeft = 120;
            var timerId = setInterval(countdown, 1000);

            function countdown() {
                if (timeLeft == 0) {
                    clearTimeout(timerId);
                    document.getElementById("countdown").innerHTML = "Time's up!";
                } else {
                    document.getElementById("countdown").innerHTML = timeLeft;
                    timeLeft--;
                }
            }
        </script>
    </body>
</html>
