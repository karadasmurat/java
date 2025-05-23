package concurrency;

import java.util.concurrent.Executors;

public class Company {

    private int salesAgentsCount;
    private int totalSales;

    Company(int salesAgentsCount) {
        this.salesAgentsCount = salesAgentsCount;
        totalSales = 0;
    }

    public void addSale() {
        totalSales++; // Increment the total sales, NOT synchronized
    }

    public int getTotalSales() {
        return totalSales;
    }

    public int getSalesAgentsCount() {
        return salesAgentsCount;
    }

    public static void main(String[] args) {
        Company company = new Company(1000);
        // company.addSale();
        // company.addSale();
        // System.out.println("Total sales: " + company.getTotalSales());

        // Simulate multiple sales agents
        // using a thread pool
        // and submit 10 tasks to it
        // Note that the thread pool will be closed automatically
        // and the tasks will be executed in parallel
        try (var executor = Executors.newFixedThreadPool(8)) {
            for (int i = 0; i < company.getSalesAgentsCount(); i++) {
                executor.submit(() -> company.addSale());
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("Total sales: " + company.getTotalSales());
    }
}
