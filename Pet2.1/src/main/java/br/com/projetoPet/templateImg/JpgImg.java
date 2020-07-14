package br.com.projetoPet.templateImg;

public final class JpgImg extends TemplateImg{

	@Override
	public String typeUpload(String type) {
		String img = "data:" +type+";base64,";
		return img;
	}
//image/jpeg
}
