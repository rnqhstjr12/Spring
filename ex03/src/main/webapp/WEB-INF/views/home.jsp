<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple Shopping Mall</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 1em;
        }

        main {
            padding: 20px;
        }

        section {
            margin-bottom: 20px;
        }

        .product {
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 20px;
            text-align: center;
            margin: 10px;
            transition: transform 0.3s ease-in-out;
        }

        .product:hover {
            transform: scale(1.05);
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 1em;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>

<body>

    <header>
        <h1>Simple Shopping Mall</h1>
    </header>

    <main>
        <section class="product">
            <h2>Product 1</h2>
            <p>Description of Product 1.</p>
            <p>Price: $19.99</p>
            <button>Add to Cart</button>
        </section>

        <section class="product">
            <h2>Product 2</h2>
            <p>Description of Product 2.</p>
            <p>Price: $29.99</p>
            <button>Add to Cart</button>
        </section>
    </main>

    <footer>
        &copy; 2023 Simple Shopping Mall
    </footer>

</body>

</html>