package org.daisy.bools.core.engine.interfaces;

import java.util.Map;

import org.daisy.bools.core.engine.WorkMemory;

public abstract class AbstractFunctions {

	private FunctionsHandle functionsHandle;

	/**
	 * 初始化时插入handle
	 * @param functionsHandle
	 */
	public void setFunctionsHandle(FunctionsHandle functionsHandle) {
		this.functionsHandle = functionsHandle;
	}

	/**
	 * 保存到工作内存
	 * 
	 * @param workMemory
	 * @param V
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * 更新到工作内存
	 * 
	 * @param workMemory
	 * @param V
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * 删除工作内存里的内容
	 * 
	 * @param workMemory
	 * @param V
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * 更新当前的salience,引擎要重新排序
	 * 
	 * @param ruleNanme
	 * @param salience
	 * @return
	 */
	public boolean updateSalience(String ruleNanme, int salience) {
		functionsHandle.updateSalience(ruleNanme, salience);
		return false;
	}

	/**
	 * 睡眠几个迭代次数，在睡眠中的rule，引擎执行时要跳过
	 * 
	 * @param ruleNanme
	 * @param numberOfiterations
	 *            要睡眠的迭代次数
	 * @return
	 */
	public boolean sleep(String ruleNanme, int numberOfiterations) {
		functionsHandle.sleep(ruleNanme, numberOfiterations);
		return false;
	}

	/**
	 * rule是否睡眠
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean isSleep(String ruleNanme) {
		functionsHandle.isSleep(ruleNanme);
		return false;
	}

	/**
	 * 停止rule，引擎执行时要跳过
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean stop(String ruleNanme) {
		functionsHandle.stop(ruleNanme);
		return false;
	}

	/**
	 * rule是否停止
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean isStop(String ruleNanme) {
		functionsHandle.isStop(ruleNanme);
		return false;
	}

	/**
	 * 启动rule
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean start(String ruleNanme) {
		if (!this.isStop(ruleNanme))
			return false;
		functionsHandle.start(ruleNanme);
		return false;
	}

	/**
	 * 插入到rule后,引擎要重新排序
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean before(String ruleNanme) {
		functionsHandle.before(ruleNanme);
		return false;
	}

	/**
	 * 插入到rule前,引擎要重新排序
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean after(String ruleNanme) {
		functionsHandle.after(ruleNanme);
		return false;
	}
}
