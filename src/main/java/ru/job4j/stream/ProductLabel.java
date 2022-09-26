package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .flatMap(Stream::ofNullable)
                .filter(product -> Math.abs(product.getActual() - product.getStandard()) >= 0)
                .filter(product -> Math.abs(product.getActual() - product.getStandard()) <= 3)
                .map(product -> "Label{" + "name='" + product.getName()
                        + '\'' + ", price=" + product.getPrice() / 2 + '}')
                .collect(Collectors.toList());
    }
}
