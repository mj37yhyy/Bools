package org.daisy.bools.core.engine.interfaces;

public interface Rule {
	
	public void setFunctionsAgent(FunctionsAgent functionsAgent);

	public boolean when();

	public boolean then();
}
