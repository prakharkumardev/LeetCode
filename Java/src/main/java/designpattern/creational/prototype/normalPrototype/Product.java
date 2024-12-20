package designpattern.creational.prototype.normalPrototype;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Product implements Prototype, Cloneable {
    @Getter
    @Setter
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Prototype getClone() {
        return new Product(id, name, price);
    }
    //get shallow copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}

class main{
    public static void main(String[] args) throws CloneNotSupportedException {
        Product product = new Product(1, "Laptop", 1000);
        System.out.println(product);
        Product productDeepClone = (Product) product.getClone();
        Product productShallowClone = (Product) product.clone();
        productDeepClone.setId(2);
        productShallowClone.setId(3);

        System.out.println(product);
        System.out.println(productDeepClone);
        System.out.println(productShallowClone);


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> str =  executorService.submit(() -> {
            System.out.println("Thread 1");
            return "hello";
        });



    }
}
