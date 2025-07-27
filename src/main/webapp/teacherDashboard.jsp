<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="az">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Müəllim Paneli</title>
    <link rel="stylesheet" href="css/teacher-dashboard.css">
</head>
<body>

<%
    if (session == null || session.getAttribute("login") == null || !(Boolean) session.getAttribute("login")
            || !"teacher".equals(session.getAttribute("role"))) {
        response.sendRedirect("index.jsp");
        return;
    }

    String fullName = (String) session.getAttribute("fullName");
%>

<div class="dashboard-container">
    <header class="dashboard-header">
        <h1>Xoş gəlmisiniz, <%= fullName %>!</h1>
        <form action="LogoutServlet" method="POST">
            <button type="submit" class="logout-button">Çıxış</button>
        </form>
    </header>

    <main class="dashboard-main">
        <section class="widget">
            <h2>İdarə Paneli</h2>
            <p>Bu sizin müəllim panelinizdir. Buradan şagirdləri, sınaqları və nəticələri idarə edə bilərsiniz.</p>
        </section>
        <section class="widget">
            <h2>Yeni Sınaq Yarat</h2>
            <p>Yeni sınaq imtahanları yaratmaq üçün buraya klikləyin (funksionallıq hazırlanacaq).</p>
            <a href="#" class="button-primary">Sınaq Yarat</a>
        </section>
        <section class="widget">
            <h2>Şagirdlərin Nəticələri</h2>
            <p>Mövcud şagirdlərin nəticələrini izləmək üçün bölmə (funksionallıq hazırlanacaq).</p>
            <a href="#" class="button-secondary">Nəticələrə Bax</a>
        </section>
    </main>
</div>

</body>
</html>