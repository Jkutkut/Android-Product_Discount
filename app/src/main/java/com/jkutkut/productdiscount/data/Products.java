package com.jkutkut.productdiscount.data;

import com.jkutkut.productdiscount.javabean.Product;

import java.util.ArrayList;

public class Products {
    private final ArrayList<Product> products;

    public Products() {
        this.products = new ArrayList<>();

        loadTestData();
    }

    public Product getProduct(String id) {
        for (Product p : products)
            if (p.getId().equals(id))
                return p;
        return null;
    }

    public Product getRandomProduct() {
        return products.get((int) (Math.random() * products.size()));
    }

    private void loadTestData() {
        products.add(
            new Product(
                "2096/289",
                "ABRIGO CUELLO SUBIDO CON LANA",
                "ABRIGO CONFECCIONADO CON TEJIDO EN MEZCLA DE LANA.\n" +
                "CUELLO SUBIDO Y MANGA LARGA CON HOMBRERAS. BOLSILLOS\n" +
                "DELANTEROS CON SOLAPA. CIERRE FRONTAL CRUZADO CON\n" +
                "BOTONES METÁLICOS CON RELIEVE.",
                69.95f
            )
        );
        products.add(
            new Product(
                "3046/229",
                "CAZADORA ACOLCHADA EFECTO PIEL",
                "CAZADORA DE CUELLO SUBIDO CON CAPUCHA AJUSTABLE CON\n" +
                "CORDÓN. BOLSILLOS DELANTEROS DE VIVO CON CREMALLERA Y\n" +
                "FORRO INTERIOR. CIERRE FRONTAL CON CREMALLERA METÁLICA.",
                49.95f
            )
        );
        products.add(
            new Product(
                "4387/430",
                "PANTALON FULL LENGTH",
                "PANTALÓN DE TIRO MEDIO Y BOLSILLOS LATERALES Y FALSOS\n" +
                "BOLSILLOS DE VIVO EN ESPALDA. DETALLE DE PINZAS MARCADAS\n" +
                "EN DELANTERO. CIERRE FRONTAL CON CREMALLERA, BOTÓN\n" +
                "INTERIOR Y GANCHOS METÁLICOS.",
                25.95f
            )
        );
        products.add(
            new Product(
                "4387/430",
                "PANTALÓN CINTURÓN FORRADO",
                "PANTALÓN DE TIRO ALTO CON CINTURÓN FORRADO A TONO.\n" +
                "BOLSILLOS DELANTEROS Y FALSOS BOLSILLOS DE VIVO EN\n" +
                "ESPALDA. CIERRE FRONTAL CON CREMALLERA, BOTÓN INTERIOR Y\n" +
                "GANCHO METÁLICO.",
                29.95f
            )
        );
        products.add(
            new Product(
                "3519/136",
                "JERSEY PUNTO RAYAS",
                "JERSEY DE CUELLO REDONDO Y MANGA LARGA.",
                29.95f
            )
        );
        products.add(
            new Product(
                "5802/002",
                "JERSEY LARGO JACQUARD",
                "JERSEY DE PUNTO CON CUELLO REDONDO Y MANGA LARGA.",
                39.95f
            )
        );
        products.add(
            new Product(
                "4174/835",
                "CAMISETA CROP",
                "CAMISETA CORTA DE CUELLO REDONDO Y MANGA LARGA.",
                9.95f
            )
        );
        products.add(
            new Product(
                "4174/025",
                "CAMISETA BÁSICA",
                "CAMISETA DE CUELLO REDONDO Y MANGA CORTA. BAJO\n" +
                "ASIMÉTRICO.",
                5.95f
            )
        );
        products.add(
            new Product(
                "2298/453",
                "CAMISETA VOLANTE HOMBRO",
                "CAMISETA DE CUELLO REDONDO Y MANGA LARGA. DETALLE DE\n" +
                "VOLANTE EN HOMBRO EN MISMO TEJIDO.",
                15.95f
            )
        );
    }
}
