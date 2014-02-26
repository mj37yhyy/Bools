package org.daisy.bools.core.build.entity;

public class Rule {
	private String value;
	private long salience;
	private boolean noLoop;
	private When when;
	private Then then;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getSalience() {
		return salience;
	}

	public void setSalience(long salience) {
		this.salience = salience;
	}

	public boolean isNoLoop() {
		return noLoop;
	}

	public void setNoLoop(boolean noLoop) {
		this.noLoop = noLoop;
	}

	public When getWhen() {
		return when;
	}

	public void setWhen(When when) {
		this.when = when;
	}

	public Then getThen() {
		return then;
	}

	public void setThen(Then then) {
		this.then = then;
	}
}
