package core.feature.algo;

import java.util.Arrays;

public class AlgoTri {
	
	private int lenght;
	private int[] array;

	public AlgoTri( int[] array,int lenght) {
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

	@Override
	public String toString() {
		return "SortFeatures [lenght=" + lenght + ", array=" + Arrays.toString(array) + "]";
	}

	public int[] getArray() {
		return array;
	}



	public void setArray(int[] array) {
		this.array = array;
	}

	public void permutation(int pos1,int pos2) {
		int valueTemp = this.array[pos1];
		this.array[pos1] = this.array[pos2];
		this.array[pos2] = valueTemp;
	}

	public void triAbulles(AscDescTri type) {
		int i;
		int j;
		for(i=0;i<this.lenght;i++) {
			for(j=0;j<this.lenght-i-1;j++) {
				if(Check.verify(this.array[j],this.array[j+1],type)) {
					permutation(j,j+1);
				}
			}
		}
	}
	
	public void triSelection(AscDescTri type) {
		int index=0;
		int unsortedIndex;
		int min;
		int minimumPosition;
		
		while(index<this.lenght) {
			min = this.array[index];
			minimumPosition = index;
			unsortedIndex = index;
			while(unsortedIndex<this.lenght) {
				if(Check.verify(min,this.array[unsortedIndex],type)) {
					min = this.array[unsortedIndex];
					minimumPosition = unsortedIndex;
				}
				unsortedIndex++;
			}
			permutation(minimumPosition,index);
			index++;
		}
	}
	
	public void triInsertion(AscDescTri type) {
		int index=1;
		int indexInsert;
		int valueInsert;
		
		while(index<this.lenght) {
			valueInsert = this.array[index];
			indexInsert = index-1;
			while(indexInsert>=0 && (Check.verify(this.array[indexInsert],valueInsert,type) 
					|| this.array[indexInsert]==valueInsert) ) {
				this.array[indexInsert+1] = this.array[indexInsert];
				indexInsert--;
			}
			this.array[indexInsert+1]=valueInsert;
			index++;
		}
	}
	
	public void triTransposition(AscDescTri type) {
		int j;
		int i;
		for( i= 0;i<this.lenght-1;i++) {
			if(Check.verify(this.array[i],this.array[i+1],type)) {
				permutation(i,i+1);
				j=i-1;
				while(j>=0) {
					if(Check.verify(this.array[j],this.array[j+1],type)) {
						permutation(j,j+1);
						j--;
					}
					else {
						j=-1;
					}
				}
			}
		}
	}
}
