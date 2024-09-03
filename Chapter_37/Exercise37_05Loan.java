1  public class Loan {
 2    private double annualInterestRate;
 3    private int numberOfYears;
 4    private double loanAmount;
 5    private java.util.Date loanDate;
 6
 7    /** Default constructor */
 8    public Loan() {
 9      this(2.5, 1, 1000);
10    }
11
12    /** Construct a loan with specified annual interest rate, 
13        number of years, and loan amount 
14      */ 
15    public Loan(double annualInterestRate, int numberOfYears, 
16        double loanAmount) {
17      this.annualInterestRate = annualInterestRate;
18      this.numberOfYears = numberOfYears;
19      this.loanAmount = loanAmount;
20      loanDate = new java.util.Date();
21    }
22
23    /** Return annualInterestRate */ 
24    public double getAnnualInterestRate() {
25      return annualInterestRate;
26    }
27
28    /** Set a new annualInterestRate */ 
29    public void setAnnualInterestRate(double annualInterestRate) {
30      this.annualInterestRate = annualInterestRate;
31    }
32
33    /** Return numberOfYears */ 
34    public int getNumberOfYears() {
35      return numberOfYears;
36    }
37
38    /** Set a new numberOfYears */ 
39    public void setNumberOfYears(int numberOfYears) {
40      this.numberOfYears = numberOfYears;
41    }
42
43    /** Return loanAmount */ 
44    public double getLoanAmount() {
45      return loanAmount;
46    }
47
48    /** Set a new loanAmount */ 
49    public void setLoanAmount(double loanAmount) {
50      this.loanAmount = loanAmount;
51    }
52
53    /** Find monthly payment */ 
54    public double getMonthlyPayment() {
55      double monthlyInterestRate = annualInterestRate / 1200;
56      double monthlyPayment = loanAmount * monthlyInterestRate / (1 –
57        (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
58      return monthlyPayment; 
59    }
60
61    /** Find total payment */ 
62    public double getTotalPayment() {
63      double totalPayment = getMonthlyPayment() * numberOfYears * 12;
64      return totalPayment;
65    }
66
67    /** Return loan date */ 
68    public java.util.Date getLoanDate() {
69      return loanDate;
70    }
71  }
