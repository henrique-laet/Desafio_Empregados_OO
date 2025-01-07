package application;

import entities.Address;
import entities.Departament;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String nameDep = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        Integer payDay = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        Address address = new Address(email, telefone);

        Departament dept = new Departament(nameDep, payDay, address);

        System.out.print("Quantos funcionários tem o departamento? ");
        int quant = sc.nextInt();

        for (int i = 1; i <= quant; i++) {
            System.out.println("Dados do funcionário " + i + ": ");
            sc.nextLine();
            System.out.print("Nome: ");
            String nomeFunc = sc.nextLine();

            System.out.print("Salario: ");
            Double salario = sc.nextDouble();
            Employee emp = new Employee(nomeFunc, salario);
            dept.addEmployee(emp);

        }
        System.out.println();
        System.out.println("FOLHA DE PAGAMENTO:");
        showReport(dept);
        sc.close();

    }

    public static void showReport(Departament dept) {

        System.out.printf("Departamento Vendas = R$ %.2f%n", dept.payroll());
        System.out.println("Pagamento realizado no dia " + dept.getPayDay());

        System.out.println("Funcionários: ");
        System.out.println(dept);
        System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
    }

}
