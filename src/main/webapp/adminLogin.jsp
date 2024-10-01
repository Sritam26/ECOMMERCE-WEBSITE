<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet"/>
</head>
<body>

    <div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/admin_login.jpg" alt="sing up image">
						</figure>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Admin Login</h2>
						<form method="post" action="login" class="register-form"
							>
							<div class="form-group">
								<label for="username"><i class="ri-user-3-fill"></i></label> <input
									type="email" name="email" id="username"
									placeholder="Your email" />
							</div>
							<div class="form-group">
								<label for="password"><i class="ri-lock-2-fill"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<div class="form-group form-button">
								<input type="submit"  
									class="form-submit" value="login" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>

	</div>

</body>
</html>
