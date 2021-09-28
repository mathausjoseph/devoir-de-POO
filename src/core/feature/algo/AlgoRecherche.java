package core.feature.algo;

import java.util.Arrays;

public class AlgoRecherche {
	
	private int lenght;
	private int[] array;
	
	public AlgoRecherche(int lenght, int[] array) {
		super();
		this.lenght = lenght;
		this.array = array;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	@Override
	public String toString() {
		return "SearchFeatures [lenght=" + lenght + ", array=" + Arrays.toString(array) + "]";
	}
	
	public boolean linearSearch(int val) {
		for(int i = 0 ; i<this.lenght;i++) {
			if(this.array[i]==val) {
				return true;
			}
		}
		return false;
	}
	
	public boolean dichotoSearch(int val,AscDescTri type) {
		int left =0;
		int right = this.lenght-1;
		int medium;
		boolean find=false;
		
		while(left<=right && !find) {
			medium =(right+left)/2;
			find = this.array[medium]==val;
			
			if(Check.verify(val,this.array[medium], type)) {
				left=medium+1;
			}
			else {
				right=medium-1;
			}
		}
		
		return find;
	}
	
	public  boolean fibonnaciSearch(int val,AscDescTri type){
		int numberfibonnaci2 = 0; 
		int numberfibonnaci1 = 1;
		int numberfibonnaci = numberfibonnaci1 + numberfibonnaci2;
		
		while (numberfibonnaci < this.lenght) {
			numberfibonnaci2 = numberfibonnaci1;
			numberfibonnaci1 = numberfibonnaci;
			numberfibonnaci = numberfibonnaci1 + numberfibonnaci2;
		}
		
		int number = -1;
		int i;
		
		while (numberfibonnaci > 1) {
			i = Math.min(number + numberfibonnaci1, this.lenght - 1);
			
			if (Check.verify(val,this.array[i],type)) {
				numberfibonnaci = numberfibonnaci1;
				numberfibonnaci1 = numberfibonnaci2;
				numberfibonnaci2 = numberfibonnaci - numberfibonnaci2;
				number = i;
			}
			
			else if (!Check.verify(val,this.array[i],type) && val!=this.array[i]) {
				numberfibonnaci = numberfibonnaci2;
				numberfibonnaci1 = numberfibonnaci1 - numberfibonnaci2;
				numberfibonnaci2 = numberfibonnaci - numberfibonnaci1;
			}
		
			else {
				return true;
			}
			
		}
		
		if(numberfibonnaci==1 && this.array[this.lenght-1]==val) {
			return true;
		}
		
		return false;
	}
	
	public boolean searchByJump(int val,AscDescTri type) {
		
        int jump = (int) Math.sqrt(this.lenght);
        
        int p = 0;
        
        while (Check.verify(val,this.array[Math.min(jump, this.lenght)-1] ,type))
        {
            p = jump;
            jump += (int) Math.sqrt(this.lenght);
            if (p >= this.lenght)
                return false;
        }
 
        while (this.array[p] < val)
        {
            p++;
            if (p == Math.min(jump, this.lenght))
                return false;
        }

        if (this.array[p] == val)
            return true;

		return false;
	}

}
