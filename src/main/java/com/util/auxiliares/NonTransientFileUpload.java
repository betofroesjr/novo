package com.util.auxiliares;

public class NonTransientFileUpload extends org.primefaces.component.fileupload.FileUpload{
	@Override
	public boolean isTransient() {
		return false;
	}
}