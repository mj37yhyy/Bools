package org.daisy.bools.core.engine;

import java.util.HashMap;
import java.util.Map;

public class WorkMemory {
	
	private Map workMemory = new HashMap();

	public Map getWorkMemory() {
		return workMemory;
	}

	//这个地方要实现深克隆
	public void setWorkMemory(Map workMemory) {
		this.workMemory = workMemory;
	}
	
	

}
