package entities;

import java.util.ArrayList;
import java.util.List;

public class Departament {

    private String name;
    private Integer payDay;

    private Address address;
    private List<Employee> employees = new ArrayList<>();

    public Departament(String name, Integer payDay, Address address) {
        this.name = name;
        this.payDay = payDay;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPayDay() {
        return payDay;
    }

    public void setPayDay(Integer payDay) {
        this.payDay = payDay;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public double payroll() {
        Double sum = 0.0;

        for(Employee e : employees) {
            sum += e.getSalary();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Employee e : employees) {
            sb.append(e.getName() + "\n");
        }
        return sb.toString();
    }
}
