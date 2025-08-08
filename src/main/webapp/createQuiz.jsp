<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Yeni Quiz Yarat</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: #f1f1f1;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background: #fff;
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.15);
            width: 400px;
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #444;
        }

        input, select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #218838;
        }

        .back-link {
            display: block;
            margin-top: 15px;
            text-align: center;
            color: #007bff;
            text-decoration: none;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Yeni Test Yarat</h2>
    <form action="createQuiz" method="post">
        <div class="form-group">
            <label for="title">Test Başlığı:</label>
            <input type="text" id="title" name="title" required />
        </div>

        <div class="form-group">
            <label for="grade">Sinif:</label>
            <select id="grade" name="grade" required>
                <option value="">Sinif seçin</option>
                <option value="9">9-cu sinif</option>
                <option value="10">10-cu sinif</option>
                <option value="11">11-ci sinif</option>
            </select>
        </div>

        <div class="form-group">
            <label for="questionCount">Sual sayı:</label>
            <input type="number" id="questionCount" name="questionCount" min="1" required />
        </div>

        <button type="submit">Yarat və Davam et</button>
    </form>

    <a href="teacherDashboard.jsp" class="back-link">← Geri Dashboarda</a>
</div>
</body>
</html>
