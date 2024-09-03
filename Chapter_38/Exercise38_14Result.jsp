<% 
    int correctAnswer = (Integer) session.getAttribute("answer");
    int userAnswer = Integer.parseInt(request.getParameter("userAnswer"));
    String message;
    if (correctAnswer == userAnswer) {
        message = "Correct! Well done.";
    } else {
        message = "Wrong. The correct answer is " + correctAnswer + ".";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
    <h2>Quiz Result</h2>
    <p><%= message %></p>
    <a href="quiz.jsp">Try another question</a>
</body>
</html>
