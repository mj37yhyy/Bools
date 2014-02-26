package org.daisy.bools.core.build;

import java.io.File;
import java.io.IOException;
import org.daisy.bools.core.build.entity.RuleSet;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BuildRule {
	
	public RuleSet createRuleSet(File rule) throws RuleFileException, IOException {
			try {
				return (new ObjectMapper()).readValue(rule,RuleSet.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuleFileException("RULE文件不能被正确解析并映射");
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuleFileException("RULE文件不能被正确解析并映射");
			}
	}
	
	public RuleSet createRuleSet(String ruleFileURL) throws RuleFileException, IOException {
		return this.createRuleSet(new File(ruleFileURL));
	}
}
