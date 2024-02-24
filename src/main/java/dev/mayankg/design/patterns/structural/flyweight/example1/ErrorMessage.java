package dev.mayankg.design.patterns.structural.flyweight.example1;

//Interface implemented by Flyweights
interface ErrorMessage {
	//Get an error message
	String getText(String code);
}