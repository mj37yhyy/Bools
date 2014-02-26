package org.daisy.bools.core.engine.interfaces;

import java.util.Map;

import org.daisy.bools.core.engine.WorkMemory;

public abstract class AbstractFunctions {

	public boolean save(WorkMemory workMemory, Object... V) throws Exception {
		if (V.length == 2) {
			try {
				workMemory.getWorkMemory().put(V[0], V[1]);
			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new Exception("The args is wrong!");
		}
		return true;
	}

	public boolean update(WorkMemory workMemory, Object... V) throws Exception {
		if (V.length == 2) {
			try {
				Map wm = workMemory.getWorkMemory();
				if (wm.containsKey(V[0])) {
					wm.put(V[0], V[1]);
				} else {
					throw new Exception("The key is not exist!");
				}

			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new Exception("The args is wrong!");
		}
		return true;
	}

	public boolean delete(WorkMemory workMemory, Object... V) throws Exception {
		if (V.length == 1) {
			try {
				Map wm = workMemory.getWorkMemory();
				if (wm.containsKey(V[0])) {
					wm.remove(V[0]);
				} else {
					throw new Exception("The key is not exist!");
				}

			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new Exception("The args is wrong!");
		}
		return true;
	}

}
