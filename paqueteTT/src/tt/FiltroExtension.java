package tt;

import java.io.*;

public class FiltroExtension implements FileFilter {
	String extension;
	
	public FiltroExtension(String ext){
		extension=ext;
	}
	
	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub
		if(f.isFile()&&f.getName().endsWith("."+extension))
			return true;
		else
			return false;
	}

}
