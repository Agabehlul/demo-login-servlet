<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');

        :root {
            --primary-color: #4CAF50; /* Yaşıl */
            --secondary-color: #FF9800; /* Narıncı */
            --background-color: #f4f4f4;
            --form-background: #ffffff;
            --text-color: #333;
            --error-color: #E74C3C;
            --input-border-color: #ddd;
            --input-focus-color: var(--primary-color);
        }

        body {
            font-family: 'Poppins', sans-serif;
            background-color: var(--background-color);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background-color: var(--form-background);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        h2 {
            color: var(--text-color);
            margin-bottom: 30px;
            font-weight: 600;
        }

        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }

        label {
            display: block;
            color: var(--text-color);
            margin-bottom: 8px;
            font-weight: 500;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 1px solid var(--input-border-color);
            border-radius: 5px;
            box-sizing: border-box; /* padding və border'ın enə təsir etməməsi üçün */
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            outline: none;
            border-color: var(--input-focus-color);
            box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
        }

        button[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: var(--primary-color);
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            font-weight: 600;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
            transform: translateY(-2px);
        }

        button[type="submit"]:active {
            transform: translateY(0);
        }

        .error-message {
            color: var(--error-color);
            margin-top: 20px;
            font-weight: 500;
            background-color: rgba(231, 76, 60, 0.1);
            padding: 10px;
            border-radius: 5px;
            border-left: 5px solid var(--error-color);
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Admin Login</h2>
    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label for="username">İstifadəçi adı:</label>
            <input type="text" id="username" name="username" required/>
        </div>
        <div class="form-group">
            <label for="password">Şifrə:</label>
            <input type="password" id="password" name="password" required/>
        </div>
        <button type="submit">Daxil Ol</button>
    </form>

    <% if(request.getParameter("error") != null){ %>
    <p class="error-message">İstifadəçi adı və ya şifrə səhvdir!</p>
    <% } %>
</div>

</body>
</html>