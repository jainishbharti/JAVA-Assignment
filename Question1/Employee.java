package com.assignment.java.question1;

public class Employee {
    private Integer employeeId;
    private String employeeName;
    private Integer salary;
    private Double taxGenerated;

    public Double getIncomeTax() {
        return taxGenerated;
    }

    public void setIncomeTax(Double incomeTax) {
        this.taxGenerated = incomeTax;
    }

    Employee(Integer employeeId, String employeeName, Integer salary){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.taxGenerated = IncomeTax.calculateIncomeTax(this.salary);
    }

    @Override
    public String toString() {
        return "com.assignment.java.question1.Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", taxGenerated=" + taxGenerated +
                '}';
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Integer getSalary() {
        return salary;
    }



}
