package fr.istic.taa.jaxrs.domain;
import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class ColoredTagKB extends TagKB implements Serializable  {

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
