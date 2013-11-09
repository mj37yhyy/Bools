package org.daisy.bools.core.tools.javassist;

import java.io.IOException;
import java.lang.reflect.Method;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

public class JavassistClassUtils {

	/**
	 * 使用javassist创建一个类
	 * @param classInfo
	 * @param writeFilePath
	 * @throws NotFoundException
	 * @throws CannotCompileException
	 * @throws IOException
	 */
	public void createNewClassUseJavassist(JavassistClassInfo classInfo, String writeFilePath)
			throws NotFoundException, CannotCompileException, IOException {
		ClassPool cp = ClassPool.getDefault();
		CtClass cc = null;
		cp.insertClassPath(new ClassClassPath(this.getClass()));// 把额外的搜索路径注册到ClassPool上去
		
		// 把import加入到类上
		if (classInfo.getImportPackages() != null
				&& classInfo.getImportPackages().length > 0) {
			for (String _importPackage : classInfo.getImportPackages()) {
				cp.importPackage(_importPackage);
			}
		}
		
		// 生成一个类
		if (classInfo.getClazz() != null && !classInfo.getClazz().equals("")) {
			cc = cp.makeClass(classInfo.getClazz());
		}
		
		// 插入一个超类
		if (classInfo.getSuperclass() != null
				&& !classInfo.getSuperclass().equals("")) {
			cc.setSuperclass(cp.makeClass(classInfo.getSuperclass()));
		}
		
		// 生成一个接口
		if (classInfo.getInterfaces() != null
				&& classInfo.getInterfaces().length > 0) {
			for (String _interface : classInfo.getInterfaces()) {
				CtClass cci = cp.makeInterface(_interface);
				cc.addInterface(cci);
			}
		}
		
		// 生成构造函数
		if (classInfo.getConstructor() != null
				&& !classInfo.getConstructor().equals("")) {
			CtConstructor ctConstructor = new CtConstructor(
					new CtClass[] { cp.get(Method.class.getName()) }, cc);
			ctConstructor.setBody(classInfo.getConstructor());
			cc.addConstructor(ctConstructor);
		}
		
		// 生成变量
		if (classInfo.getFields() != null && classInfo.getFields().length > 0) {
			for (String _fields : classInfo.getFields()) {
				CtField cf = CtField.make(_fields, cc);
				cc.addField(cf);
			}
		}
		
		// 生成方法
		if (classInfo.getMethods() != null && classInfo.getMethods().length > 0) {
			for (String _fields : classInfo.getMethods()) {
				CtMethod cm = CtMethod.make(_fields, cc);
				cm.getMethodInfo();
				cc.addMethod(cm);
			}
		}
		
		cc.toClass();//类写入到虚拟机
		
		//将新类写入到文件路径
		if (writeFilePath != null && !writeFilePath.equals("")) {
			cc.writeFile(writeFilePath);
		}

	}

}
