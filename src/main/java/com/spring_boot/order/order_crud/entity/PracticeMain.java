package com.spring_boot.order.order_crud.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeMain {

    public static void main(String[] args) {
        List<Practice> list = new ArrayList<>();
        list.add(new Practice("mess1", new Date(2024,5,25)));
        list.add(new Practice("mess1", new Date(2024,5,5)));
        list.add(new Practice("mess1", new Date(2024,5,02)));
        list.add(new Practice("mess1", new Date(2024,5,11)));
        list.add(new Practice("mess1", new Date(2024,5,3)));

        list = list.stream().sorted(Practice::compareTo).collect(Collectors.toList());

        System.out.println(list);

        List<String> str = new ArrayList<>();
        str.add("abc");
        str.add("def");
        str.add("ghi");
        str.add("jkl");
        str.add("mno");
        str.add("pqr");

        str = str.stream().map(s-> new StringBuilder(s).reverse().toString()).collect(Collectors.toList());

        System.out.println(str);

    }


}
