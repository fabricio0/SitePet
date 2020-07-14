package br.com.projetoPet.factory;

import java.util.HashMap;

import br.com.projetoPet.templateImg.JpgImg;
import br.com.projetoPet.templateImg.TemplateImg;

public class InstanceImg {
	HashMap<String, TemplateImg> hashMap2 = new HashMap<String, TemplateImg>();
	
	public TemplateImg buscarInstance(String type) {
		hashMap2.put("image/jpeg", new JpgImg());
		hashMap2.put("image/jpg", new JpgImg());
		return hashMap2.get(type);
	}

}
