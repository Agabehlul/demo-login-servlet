<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="az">
<head>
    <meta charset="UTF-8">
    <title>Quiz Giriş</title>
    <link rel="stylesheet" href="css/indexStylee.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">
    <h1>BSP LMS APP</h1>
    <div class="role-buttons">
        <button onclick="showForm('student')">Şagird Girişi</button>
        <button onclick="showForm('teacher')">Müəllim Girişi</button>
    </div>

    <!-- Login Forms -->
    <div class="login-form" id="studentForm" style="display:none;">
        <h2>Şagird Girişi</h2>
        <form action="StudentLoginServlet" method="post">
            <input type="text" name="username" placeholder="İstifadəçi adı" required>
            <input type="password" name="password" placeholder="Şifrə" required>
            <button type="submit">Daxil ol</button>
            <p class="login-link"> <a href="register.jsp">Qeydiyyatdan keç</a></p>
        </form>
    </div>

    <div class="login-form" id="teacherForm" style="display:none;">
        <h2>Müəllim Girişi</h2>
        <form action="TeacherLoginServlet" method="post">
            <input type="text" name="username" placeholder="İstifadəçi adı" required>
            <input type="password" name="password" placeholder="Şifrə" required>
            <button type="submit">Daxil ol</button>
        </form>
    </div>
</div>

<script>
    function showForm(role) {
        document.getElementById('studentForm').style.display = (role === 'student') ? 'block' : 'none';
        document.getElementById('teacherForm').style.display = (role === 'teacher') ? 'block' : 'none';
    }
</script>
</body>
</html>
