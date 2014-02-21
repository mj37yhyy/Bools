package org.daisy.bools.core.build.entity;

public class Rule {
	private long id;
	private long rule_id;
	private String value;
	private long salience;
	private boolean noLoop;
	private When when;
	private Then then;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRule_id() {
		return rule_id;
	}

	public void setRule_id(long rule_id) {
		this.rule_id = rule_id;
	}

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
