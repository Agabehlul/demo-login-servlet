<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Müəllim Paneli</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f4f4;
        }
        .sidebar {
            width: 250px;
            height: 100vh;
            background: #1976d2;
            color: white;
            position: fixed;
            top: 0;
            left: 0;
        }
        .sidebar h2 {
            padding: 20px;
            margin: 0;
            background: #1565c0;
            font-size: 22px;
        }
        .sidebar a {
            display: block;
            padding: 15px 20px;
            color: white;
            text-decoration: none;
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
        }
        .sidebar a:hover {
            background: #0d47a1;
        }
        .main {
            margin-left: 250px;
            padding: 20px;
        }
        .card-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }
        .card {
            background: white;
            width: 300px;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }
        .card img {
            width: 100%;
            height: 150px;
            object-fit: contain;
        }
        .card h3 {
            margin: 15px 0 5px;
        }
        .card p {
            color: #555;
        }
    </style>
</head>
<body>

<div class="sidebar">
    <h2>BSP LearnUp | Müəllim</h2>
    <a href="#">Hesabatlar</a>
    <a href="#">Sual bankı</a>
    <a href="#">İmtahan toplusu</a>
    <a href="#">İmtahan yoxlanması</a>
</div>

<div class="main">
    <h1>Panelə xoş gəlmisiniz</h1>
    <div class="card-container">
        <div class="card">
            <img src="img/report.png" alt="Hesabatlar">
            <h3>Hesabatlar</h3>
            <p>Qurumunuzla əlaqədar bütün məlumatları bu bölmədən əldə edə bilərsiniz. İmtahanlar, suallar və digər statistikalar burada toplanır.</p>
        </div>
        <div class="card">
            <img src="img/question-bank.png" alt="Sual bankı">
            <h3>Sual bankı</h3>
            <p>İmtahanlarda istifadə olunan bütün suallar burada saxlanılır. Redaktə və qovluq sistemləri mövcuddur.</p>
        </div>
        <div class="card">
            <img src="img/exam-collection.png" alt="İmtahan toplusu">
            <h3>İmtahan toplusu</h3>
            <p>Yaradılmış bütün imtahanlar buradan tənzimlənir və idarə olunur.</p>
        </div>
        <div class="card">
            <img src="img/exam-check.png" alt="İmtahan yoxlanması">
            <h3>İmtahan yoxlanması</h3>
            <p>Yazılı sualların müəllim tərəfindən yoxlanması və qiymətləndirilməsi üçün nəzərdə tutulmuşdur.</p>
        </div>
    </div>
</div>

</body>
</html>
