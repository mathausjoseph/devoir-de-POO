package core.feature.algo;

public abstract class Check {
	
	public static boolean verify(int integer1,int integer2,AscDescTri type) {
		if(type==AscDescTri.ASCENDANT) {
			return integer1>integer2;
		}
		
		return integer1<integer2;
	}
	
}
