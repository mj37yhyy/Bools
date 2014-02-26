package org.daisy.bools.core.build.entity;

import java.util.List;

public class RuleSet {
	private String name;
	private String namespace;
	private List<Imports> imports;
	private List<Globals> globals;
	private List<Functions> functions;
	private List<Rule> rules;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public List<Imports> getImports() {
		return imports;
	}

	public void setImports(List<Imports> imports) {
		this.imports = imports;
	}

	public List<Globals> getGlobals() {
		return globals;
	}

	public void setGlobals(List<Globals> globals) {
		this.globals = globals;
	}

	public List<Functions> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Functions> functions) {
		this.functions = functions;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

}
