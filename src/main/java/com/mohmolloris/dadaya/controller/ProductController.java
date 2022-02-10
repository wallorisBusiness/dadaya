package com.mohmolloris.dadaya.controller;

import com.mohmolloris.dadaya.dto.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ProductController {

    List<Product> listOfProduct = new ArrayList<>() {{
        add(new Product(1, "Перепелиное яйцо"));
        add(new Product(2, "Куриное яйцо"));
        add(new Product(3, "Майонез"));
        add(new Product(4, "Говядина"));
        add(new Product(5, "Свинина"));
        add(new Product(6, "Курица"));
    }};

    List<Product> basket = new ArrayList();

    @GetMapping("/basket")
    public List<Product> getBasket() {
        return basket;
    }

    /*Как сделать красиво через json*/

    @PostMapping("/basket/add")
    public List<Product> addProductToBasket(@RequestBody String nameOfProduct) {
        this.listOfProduct.forEach(o -> {
            if (o.getName().equals(nameOfProduct)) {
                this.basket.add(o);
            }
        });
        return this.basket;
    }


    @GetMapping("/basket/countOfProducts")
    public void getCountOfProductsInBasket() {
        throw new IllegalArgumentException("Egor pidor");
    }

    @DeleteMapping("/products/{name}")
    public void deleteProduct(@PathVariable String name) {
        basket.removeIf(o -> o.getName().equals(name));
    }

    @PostMapping("/basket/delete")
    public void deleteProductFromBasket(@RequestBody String nameOfProduct) {
        basket.remove(listOfProduct.stream().filter(o -> o.getName().contains(nameOfProduct)).toList().get(0));
    }

    @PostMapping(value = "/basket/addByList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> addListOfProductToBasket(@RequestBody List<Product> namesOfProductFromList) {
        namesOfProductFromList.forEach(o -> basket.add(listOfProduct.stream()
                .filter(j -> j.getName().equals(o.getName()))
                .findFirst().orElseThrow(IllegalArgumentException::new)));
        return this.basket;
    }

    @GetMapping("/basket/buyAll")
    public String buyAllFromBasket() {
        basket.clear();
        return "Ты все скупил, жирная блядина";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return listOfProduct;
    }

    @PostMapping("/products/filter")
    public List<Product> getProductsWithFilter(@RequestBody String str) {
        return listOfProduct.stream().filter(o -> o.getName().contains(str)).toList();
    }

}
