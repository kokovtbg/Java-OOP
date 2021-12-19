package TestDrivenDevelopment.lab;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.contains(product);
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        boolean productExist = false;
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getLabel().equals(product)) {
                this.products.get(i).setQuantity(quantity);
                productExist = true;
                break;
            }
        }
        if (!productExist || quantity < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
        if (index < 0 || index >= this.products.size()) {
            throw new IndexOutOfBoundsException();
        }
        return this.products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        boolean productExists = false;
        int index = 0;
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getLabel().equals(label)) {
                productExists = true;
                index = i;
                break;
            }
        }
        if (!productExists) {
            throw new IllegalArgumentException();
        }
        return this.products.get(index);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count < 0 || count > this.products.size()) {
            return new ArrayList<>();
        }
        List<Product> firstByAlphabeticOrder = this.products.stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count).collect(Collectors.toList());
        Collections.sort(this.products);
        return firstByAlphabeticOrder;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> products = new ArrayList<>();
        this.products.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .forEach(products::add);
        return products;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> products = new ArrayList<>();
        this.products.forEach(p -> {
            if (p.getPrice() == price) {
                products.add(p);
            }
        });
        return products;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        List<Product> products = new ArrayList<>();
        this.products.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .limit(count)
                .forEach(products::add);
        if (products.size() < count) {
            throw new IllegalArgumentException("Less than count products exist");
        }
        return products;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        List<Product> products = new ArrayList<>();
        this.products.forEach(p -> {
            if (p.getQuantity() == quantity) {
                products.add(p);
            }
        });
        return products;
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.iterator();
    }
}
