<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="az">
<head>
    <meta charset="UTF-8">
    <title>Şagird Qeydiyyatı</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
<div class="signup-container">
    <form class="signup-form" action="${pageContext.request.contextPath}/RegisterServlet" method="POST">
        <h2>Qeydiyyat</h2>

        <div class="form-group">
            <label for="name">Ad</label>
            <input type="text" id="name" name="name" required>
        </div>

        <div class="form-group">
            <label for="surname">Soyad</label>
            <input type="text" id="surname" name="surname" required>
        </div>

        <div class="form-group">
            <label for="fatherName">Ata adı</label>
            <input type="text" id="fatherName" name="fatherName" required>
        </div>

        <div class="form-group">
            <label for="grade">Sinif</label>
            <select id="grade" name="grade" required>
                <option value="">Sinif seçin</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
            </select>
        </div>

        <div class="form-group">
            <label for="username">İstifadəçi adı</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="password">Şifrə</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div class="form-group">
            <label for="confirm-password">Şifrənin təkrarı</label>
            <input type="password" id="confirm-password" name="confirmPassword" required>
        </div>


        <button type="submit">Qeydiyyatdan keç</button>

        <p class="login-link">Hesabın var? <a href="index.jsp">Daxil ol</a></p>
    </form>
</div>
</body>
</html>
