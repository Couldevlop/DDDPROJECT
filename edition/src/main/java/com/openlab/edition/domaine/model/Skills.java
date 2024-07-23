package com.openlab.edition.domaine.model;

public class Skills {
    private final  int id;
    private final String name;
    private final String nbrExp;


    public Skills(int id, String name, String nbrExp) {
        this.id = id;
        this.name = name;
        this.nbrExp = nbrExp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNbrExp() {
        return nbrExp;
    }
}
