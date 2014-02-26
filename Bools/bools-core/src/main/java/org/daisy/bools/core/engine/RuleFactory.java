package org.daisy.bools.core.engine;

import java.util.ArrayList;
import java.util.List;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import org.daisy.bools.core.build.entity.RuleSet;

public class RuleFactory {
	
	public static List<Object> getRules(RuleSet ruleSet) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
		//建立一个List用来存放生成的Rule类
		List<Object> rules = new ArrayList<Object>(0);
		//获得源Rule List
		List<org.daisy.bools.core.build.entity.Rule> sources = ruleSet.getRules();
		ClassPool pool = ClassPool.getDefault();
		for(org.daisy.bools.core.build.entity.Rule s : sources) {
			//读取模板类
			CtClass rule = pool.get("interfaces.Rule");
			//将类名改成Rule名
			rule.setName(s.getValue());
			//用源Rule里的代码覆盖两个方法
			CtMethod when = rule.getDeclaredMethod("when"),
					then = rule.getDeclaredMethod("then");
			when.setBody(s.getThen().getValue());
			then.setBody(s.getThen().getValue());
			//生产List
			Class<?> c = rule.getClass();
			rules.add(c.newInstance());
		}
		return rules;
	}

}
