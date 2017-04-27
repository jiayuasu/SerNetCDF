import static org.junit.Assert.*;

import java.util.List;

import org.datasyslab.sernetcdf.SerNetCDFUtils;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;


import ucar.ma2.Array;
import ucar.nc2.Variable;
import ucar.nc2.dataset.NetcdfDataset;

public class testSerNetCDF {

	static String filename = "";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		filename = System.getProperty("user.dir")+"/src/test/resources/" + "MYD11_L2.A2017091.0155.006.2017094143610.hdf";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		NetcdfDataset ncfile = null;		
		int offset = 2;
		int increment = 5;
		double scaleFactor = 0.02;
		
		String swathName = "MOD_Swath_LST";
		String geolocationFieldName = "Geolocation_Fields";
		String dataFieldName = "Data_Fields";
		String dataVariableName = "LST";
		ncfile =  SerNetCDFUtils.loadNetCDFDataSet(filename);
		
		List<Variable> variables = ncfile.getVariables();
		Array longitude = SerNetCDFUtils.getNetCDF2DArray(ncfile, swathName+"/"+geolocationFieldName+"/Longitude");
		Array latitude = SerNetCDFUtils.getNetCDF2DArray(ncfile, swathName+"/"+geolocationFieldName+"/Latitude");
		Array dataVariable = SerNetCDFUtils.getNetCDF2DArray(ncfile, swathName+"/"+dataFieldName+"/"+dataVariableName);
		int[] geolocationShape = longitude.getShape();
		
		for (int j = 0; j < geolocationShape[0]; j++) {
			for (int i = 0; i < geolocationShape[1]; i++) {
				// We probably need to switch longitude and latitude if needed.
				double lng = SerNetCDFUtils.getDataSym(longitude, j, i);
				double lat = SerNetCDFUtils.getDataSym(latitude, j, i);
				String userData = String.valueOf(SerNetCDFUtils.getDataAsym(dataVariable, j, i, offset, increment));
			}
		}
		    
	}

}
