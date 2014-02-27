package org.daisy.bools.core.engine.interfaces;

/**
 * 该接口是引擎调用rule的一个handle，当rule的事件触发时，会调用这些方法，这些方法就可以通知引擎进行下一步的操作
 * @author jia.miao
 *
 */
public interface FunctionsHandle {

	/**
	 * 更新当前的salience,引擎要重新排序
	 * 
	 * @param ruleNanme
	 * @param salience
	 * @return
	 */
	public boolean updateSalience(String ruleNanme, int salience);

	/**
	 * 睡眠几个迭代次数，在睡眠中的rule，引擎执行时要跳过
	 * 
	 * @param ruleNanme
	 * @param numberOfiterations
	 *            要睡眠的迭代次数
	 * @return
	 */
	public boolean sleep(String ruleNanme, int numberOfiterations);

	/**
	 * rule是否睡眠
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean isSleep(String ruleNanme);

	/**
	 * 停止rule，引擎执行时要跳过
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean stop(String ruleNanme);

	/**
	 * rule是否停止
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean isStop(String ruleNanme);

	/**
	 * 启动rule
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean start(String ruleNanme);

	/**
	 * 插入到rule后,引擎要重新排序
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean before(String ruleNanme);

	/**
	 * 插入到rule前,引擎要重新排序
	 * 
	 * @param ruleNanme
	 * @return
	 */
	public boolean after(String ruleNanme);
}
