<%@ page import="java.util.Random" %>

<% 
    Random random = new Random();
    int number1 = random.nextInt(100);
    int number2 = random.nextInt(100);

    session.setAttribute("answer", number1 + number2);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Addition Quiz</title>
</head>
<body>
    <h2>Addition Quiz</h2>
    <form action="result.jsp" method="post">
        <%= number1 %> + <%= number2 %> = <input type="text" name="userAnswer">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
