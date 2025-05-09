<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Arial, sans-serif';
            background: linear-gradient(135deg, #ff0000, #ff7f00, #ffff00, #00ff00, #0000ff, #4b0082, #8b00ff);
            background-size: 400% 400%;
            animation: gradientBG 10s ease infinite;
            color: white;
            text-align: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        h1 {
            font-size: 3rem;
            margin: 0;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
			border-radius:2px black solid;
        }

        p {
            font-size: 1.5rem;
            margin: 10px 0;
        }

        .welcome-button {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 1.2rem;
            font-weight: bold;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            background: #ffffff;
            color: #333;
            transition: transform 0.3s, background-color 0.3s, color 0.3s;
        }

        .welcome-button:hover {
            transform: scale(1.1);
            background: #4b0082;
            color: white;
        }
    </style>
	<script>
				
		
		
	</script>	
	
</head>
<body onload="">
	
    <div>
        <h1><b name="h1">Welcome to My First Webpage...</b></h1>
        <p name="p1">Explore the beauty of colors and interactivity!</p>
        <a href="/html/userPage.html"><button class="welcome-button">Get Started</button></a>
    </div>

</body>
</html>
