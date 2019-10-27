package com.travel.util;

import java.io.File;
import java.io.IOException;
//import java.nio.file.Files;

import org.springframework.web.multipart.MultipartFile;


public class UpLoad {
	//上传图片
	public static String upLoad(MultipartFile file) {
		String image=null;
		if(!file.isEmpty()) {
			try {
				image=System.nanoTime()+(Math.random()+"").substring(2, 6);
				File dest=new File("D:/TravelPhoto/"+image);
			//	File src=new File("D:/eclipse-workspace/Travel/WebContent/files/"+folder+image);
				file.transferTo(dest);
			//	Files.copy(dest.toPath(), src.toPath());
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return image;
	}
	
}
