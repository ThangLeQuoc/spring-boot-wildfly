package com.thanglequoc.employees;

public enum Gender {
    M("Male"),
    F("Female");
    
    private String literal;
    
    Gender(String literal){
	this.literal = literal;
    }
    
    public String getLiteral() {
	return this.literal;
    }
}
