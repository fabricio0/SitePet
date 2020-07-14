package br.com.projetoPet.templateImg;

public class PngImg extends TemplateImg{

	@Override
	public String typeUpload(String type) {
		String img = "data:" +type+";base64,";
		return img;
	}
}
