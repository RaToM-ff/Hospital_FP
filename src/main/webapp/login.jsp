<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Sing in</title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<div class="content_div">
<h2>Sing in</h2>
<form method="POST" action="/Hospital_FP/controller">
    <input type="hidden" name="command" value="login">
    <p>Login:</p>
	<input type="text" name="login" value="${oldLogin}" placeholder="Login"><div class="error_field">Error message!</div>
	<p>Password:</p>
	<input type="password" name="password" placeholder="Password"><div class="error_field">Error message!</div>
    <br>
    <input class="functional_but blue_but" type="submit" value="Sign In">
    <p>
    <div class="error_field">${errorMessage}</div>
    </p>
</form>
</div>
</div>
</body>
</html>
