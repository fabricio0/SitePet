package br.com.projetoPet.templateImg;

public abstract  class TemplateImg {
	public String upload(String file, String type) {
		String fileType = typeUpload(type);
		String img = fileType + file;
		return img;
	}

	public abstract String typeUpload(String type);
}
