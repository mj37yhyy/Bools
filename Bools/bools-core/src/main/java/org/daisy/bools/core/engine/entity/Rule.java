package org.daisy.bools.core.engine.entity;

import java.util.List;

public class Rule {
	private long id;
	private String name;
	private List<Packages> packages;
	private List<Imports> imports;
	private List<Globals> globals;
	private List<Functions> functions;
	private List<SubRules> subRules;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Packages> getPackages() {
		return packages;
	}

	public void setPackages(List<Packages> packages) {
		this.packages = packages;
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

	public List<SubRules> getSubRules() {
		return subRules;
	}

	public void setSubRules(List<SubRules> subRules) {
		this.subRules = subRules;
	}

}
