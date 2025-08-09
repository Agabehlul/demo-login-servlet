<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.07.2025
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="az">
<head>
  <meta charset="UTF-8" />
  <title>Şagird Dashboard</title>
  <link rel="stylesheet" href="css/dashboard.css" />
</head>
<body>
<%
  if (session == null || session.getAttribute("login") == null || !(Boolean)session.getAttribute("login")) {
    response.sendRedirect("index.jsp");
    return;
  }

  String name = (String) session.getAttribute("name");
  String surname = (String) session.getAttribute("surname");
  String username = (String) session.getAttribute("username");
%>
<header>
  <h1>Xoş gəlmisiniz, <%= name + " " + surname %>!</h1>
  <form action="LogoutServlet" method="POST" style="display:inline;">
    <button type="submit">Çıxış</button>
  </form>
</header>

<main>
  <section>
    <h2>Profil məlumatları</h2>
    <p><strong>İstifadəçi adı:</strong> <%= username %></p>
    <p><strong>Ad Soyad:</strong> <%= name + " " + surname %></p>
  </section>

  <section>
    <h2>Sınaqlarım</h2>
    <p>Burada şagirdin mövcud sınaqları görünəcək (hələ backend yazılmayıb).</p>
  </section>

  <section>
    <h2>Nəticələrim</h2>
    <p>Burada şagirdin test nəticələri göstəriləcək (hələ backend yazılmayıb).</p>
  </section>
</main>
</body>
</html>

