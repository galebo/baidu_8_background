package com.galebo.web.common;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import freemarker.ext.beans.StringModel;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class FreemakerObject2Json implements TemplateMethodModelEx {

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List args) throws TemplateModelException {

		if (null != args && 0 < args.size()) {
			if(args.get(0) instanceof SimpleSequence){
				SimpleSequence object =(SimpleSequence) args.get(0);
				return JSONObject.toJSONString(object.toList());
			}
			if(args.get(0) instanceof StringModel){
				StringModel object =(StringModel) args.get(0);
				return JSONObject.toJSONString(object.getWrappedObject());
			}
		}
		return null;
	}
}
