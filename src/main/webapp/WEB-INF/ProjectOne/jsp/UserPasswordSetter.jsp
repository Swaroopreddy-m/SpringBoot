<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Set Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h2 {
            color: #28a745;
            text-align: center;
            margin-bottom: 20px;
        }

        h3 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }

        .form-container {
            background: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            padding: 20px 30px;
            width: 100%;
            max-width: 500px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 20px;
        }

        label {
            font-size: 1rem;
            margin-bottom: 8px;
            color: #555;
        }

        input {
            padding: 10px;
            font-size: 1rem;
            border: 1px solid #ccc;
            border-radius: 4px;
            transition: border-color 0.3s ease;
        }

        input:focus {
            border-color: #28a745;
            outline: none;
        }

        .button-group {
            display: flex;
            justify-content: space-between;
        }

        button {
            padding: 10px 20px;
            font-size: 1rem;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button.cancel {
            background-color: #dc3545;
            color: #fff;
        }

        button.cancel:hover {
            background-color: #c82333;
        }

        button.done {
            background-color: #28a745;
            color: #fff;
        }

        button.done:hover {
            background-color: #218838;
        }
    </style>
    
    
</head>
<body><form action="/passwordupdate" method="post">
    <!--  <h2>Password Changed Successfully</h2> -->
    <h3>Please Set User ID & Password</h3>
    <div class="form-container">
        <div class="form-group">
            <label for="userid">User ID:</label>
            <input type="text" id="userid" name="userid">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
        </div>
        <div class="button-group">
            <a href="userPage.html"><button class="cancel">Cancel</button></a>
            <input type="submit" value="Done" class="done">
        </div>
    </div></form>
</body>
</html>