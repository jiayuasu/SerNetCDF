# SerNetCDF
## Main features
SerNetCDF is a NetCDF/HDF library for GeoSpark. It enables GeoSpark to process NetCDF/HDF data. However, any Hadoop MapReduce or Spark enthusiasts can take this library and process large scale NetCDF/HDF data (of course, it may take you some time).

SerNetCDF provides a serializable/deserializable interface for users to access HDF/NetCDF format data. It is a serializable wrapper for the original Unidata NetCDF-java library. 

## Acknowledgement
  

SerNetCDF is a Java Rewrite of SciSpark NetCDFUtils. But SerNetCDF provides some new functions:

1. getDataSym(): get an observation from a symmetric mapping. One observation maps one geo-location.
2. getDataAsym(): get an observation from a asymmetric mapping. One geolocation maps more than one observation. Or, one observation maps more than one geolocation.
3. SerNetCDF doesn't force user to do 2D->1D array transformation. Because observations array does not follow asymmetric mapping, many of the observations are actually not used at all. It is no need to convert them at the beginning. It will directly jump to the desired array cell with O(1) complexity.
4. SerNetCDF considers hdf increment and hdf offset. These two variables control the mapping between geolocations and observations.

## Contact
Jia Yu (jiayu2 at asu dot edu)

## License

SerNetCDF is under Apache License 2.0.


