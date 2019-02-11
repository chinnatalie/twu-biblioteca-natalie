package com.twu.biblioteca;

abstract class BibliotecaResource {

    private String name;

    public BibliotecaResource(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
