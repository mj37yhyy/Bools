package org.daisy.bools.core.build;

import java.io.File;
import java.io.IOException;
import org.daisy.bools.core.build.entity.RuleSet;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BuildRule {
	
	public RuleSet createRuleSet(String rule) throws RuleFileException, IOException {
			try {
				RuleSet ruleSet = (new ObjectMapper()).readValue(rule,RuleSet.class);
				return ruleSet;
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
}
