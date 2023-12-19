<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome to Winzbanking</title>
    <link rel="stylesheet" href="index.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <!-- NAVBAR CREATION -->
   <header class="header">
    <nav class="navbar">
        <a href="#">Home</a>
        <a href="#">Portfolio</a>
          <a href="#">About</a>
          <a href="#">Contact</a>
          <a href="#">Help</a>
    </nav>
    <form action="" class="search-bar">
       <input type="text" placeholder="Search...">
       <button><i class='bx bx-search'></i></button>
    </form>
   </header>
    <div class="background"></div>
    <div class="container">
        <div class="item">
            <h2 class="logo"><i class='bx bxl-xing'></i>Winz Banking</h2>
            <div class="text-item">
                <h2>Welcome! <br><span>

                </span></h2>
                <p>Open a bank account</p>
                <p>Open a bank account and payment card in just 1 minute of online registration</p>
                <br>
                <b>Connect with Winzbank more here</b>
                <div class="social-icon">
                    <a href="#"><i class='bx bxl-facebook'></i></a>
                    <a href="#"><i class='bx bxl-twitter'></i></a>
                    <a href="#"><i class='bx bxl-youtube'></i></a>
                    <a href="#"><i class='bx bxl-instagram'></i></a>
                    <a href="#"><i class='bx bxl-linkedin'></i></a>
                    <p> Copyright © 2023 belongs to Vietnam Technological and Commercial Joint Stock Bank</p>
                </div>
            </div>
        </div>
        <div class="login-section">
            <div class="form-box login">
                <form action="/login" method="post">
                    <h2>Sign In</h2>
                    <div class="input-box">
                        <span class="icon"><i class='bx bxs-envelope'></i></span>
                        <input type="tel" name="phoneNumber" placeholder="Phone Number" required>
                    </div>
                    <div class="input-box">
                        <span class="icon"><i class='bx bxs-lock-alt'></i></span>
                        <input type="password" name="password" placeholder="Password" required>
                    </div>
                    <div class="remember-password">
                        <label for="remember"><input type="checkbox" id="remember" name="rememberMe">Remember Me</label>
                        <a href="#">Forget Password</a>
                    </div>
                    <button class="btn" type="submit">Login In</button>
                    <div class="create-account">
                        <p>Create A New Account? <a href="#" class="register-link">Sign Up</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="index.js"></script>
</body>

</html>