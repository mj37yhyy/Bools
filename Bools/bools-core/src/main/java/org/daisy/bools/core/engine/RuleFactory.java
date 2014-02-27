package org.daisy.bools.core.engine;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import org.daisy.bools.core.build.entity.RuleSet;
import org.daisy.bools.core.build.entity.Then;
import org.daisy.bools.core.build.entity.When;

public class RuleFactory {
	
	public static Map<String,String> getRules(RuleSet ruleSet) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
		//建立一个Map用来存放生成的Rule类
		Map<String,String> rules = new HashMap<String,String>(0);
		//获得源Rule List
		List<org.daisy.bools.core.build.entity.Rule> sources = ruleSet.getRules();

		System.out.println("Size = " + sources.size());
		ClassPool pool = ClassPool.getDefault();
		for(org.daisy.bools.core.build.entity.Rule s : sources) {
			//直接利用源Rule类并添加接口，省很多事
			CtClass rule = pool.get("org.daisy.bools.core.build.entity.Rule");
			rule.setName(s.getValue());
			CtClass ri = pool.makeInterface("interfaces.Rule");
			rule.addInterface(ri);
			//用源Rule里的代码覆盖when和then方法并添加其他变量和方法
            rule.addMethod(CtNewMethod.make("public boolean when() " + s.getWhen().getValue(),rule));  
            rule.addMethod(CtNewMethod.make("public void then() " + s.getThen().getValue(),rule));  
			CtMethod getSalience = rule.getDeclaredMethod("getSalience"),
				isNoLoop = rule.getDeclaredMethod("isNoLoop");				
			//第一次读取salience和noLoop时是空值，所以这里使用了个小技巧将源Rule里的值当作初始值
			getSalience.setBody("return (this.salience == 0)?" + s.getSalience() +":salience;");
			isNoLoop.setBody("return (!this.noLoop)?" + s.isNoLoop() + ":noLoop;");
			//充填Map
			Class<?> c = rule.getClass();
			rules.put(s.getValue(),c.toString());
		}
		return rules;
	}
	
	// ====== 以下是排序算法初步MODE =====
	
	//省事起见，需要用到的数据直接写成类变量
	private static Map<String,Long> m;
	private static String[] key;
	
	private static void run(long[][] i) {
		for(long v = 0;v < i.length;v++) {
			String k = key[(int)i[(int)v][0]];
			System.out.println("@" + v + ": Key = " + k + " | Value = " + m.get(k));
		}
	}
	
	//HashMap不维护顺序，所以我不得不写了这个函数用Key的值反推Index，跟核心算法无关，理解就行
	private static int getKeyIndex(String k) {
		for(int v = 0;v < key.length;v++) {
			if(key[v].endsWith(k)) {
				return v;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		//Map m 模拟Rule Map
		m = new HashMap<String,Long> ();
		m.put("M1",Long.valueOf(0));
		m.put("M2",Long.valueOf(300));
		m.put("M3",Long.valueOf(200));
		m.put("M4",Long.valueOf(0));
		m.put("M5",Long.valueOf(100));
		m.put("M6",Long.valueOf(0));
		m.put("M7",Long.valueOf(0));
		m.put("M8",Long.valueOf(300));
		m.put("M9",Long.valueOf(400));
		
		key = m.keySet().toArray(new String[m.size()]);
		long[][] i = new long[m.size()][2];
		
		for(int v = 0;v < m.size();v++) {
			i[v][0] = getKeyIndex(key[v]);
			i[v][1] = m.get(key[v]);
		}
		
		System.out.println(" ===== 未排序时的调用结果 ===== (HashMap不保证元素顺序，所以结果是混乱的)");
		run(i);
		
		//排序，用最简单的冒泡法
		
		for(int v = 0; v < i.length;v++) {
			for(int v2 = v; v2 < i.length;v2++) {
				if(i[v2][1] > i[v][1] || i[v2][1] == i[v][1]){
					long[] v3 = i[v];
					i[v] = i[v2];
					i[v2] = v3;
				}
			}
		}
		System.out.println(" ===== 排序后的调用结果 ===== ");
		run(i);
	}
	
}



















