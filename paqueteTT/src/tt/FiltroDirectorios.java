package tt;

import java.io.File;
import java.io.FileFilter;

public class FiltroDirectorios implements FileFilter {

	@Override
	public boolean accept(File arg0) {
		return arg0.isDirectory();
	}

}
