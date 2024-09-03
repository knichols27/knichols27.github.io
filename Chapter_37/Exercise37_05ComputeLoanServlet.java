import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ComputeLoanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        // Parse form data
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("interestRate"));
        int numberOfYears = Integer.parseInt(request.getParameter("numberOfYears"));
        
        // Use the Loan class to compute
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
        
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();
        
        // Return the result as a simple HTML
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Loan Payment Computed</title></head>");
        out.println("<body>");
        out.println("<p>Monthly Payment: " + monthlyPayment + "</p>");
        out.println("<p>Total Payment: " + totalPayment + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
