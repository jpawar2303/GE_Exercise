package com.ge.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil {
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

    char[][] data;

    public ArrayQuadrantUtil(char[][] data) {
        this.data = data;
    }
    
	public char[] getValueLeftToRight(int row) {
			
			char[] array= new char[4];
			try {
				for(int col=0; col <4; col++) {
					array[col]= data[row][col];
					}
			}catch (Exception e) {
				// TODO: handle exception
				System.err.println(e);
			}
			
			
			return array;
			
		}

		public char[] getValueTopToBottom(int col) {
				
				char[] array = new char[4];
				try {
					for(int row=0; row <4; row++) { 
						array[row]= data[row][col]; 
					}
				}catch (Exception e) {
					// TODO: handle exception
					
					System.err.println(e);
				}
				
				return array;
				
				
			}

	    public char[] getQuadrantValues(int row, int column) {
	    	String ch;
	    	int i,j,k=0;
	    	char[] array = new char[4];
	    	
	    	
	    	if(row == 0 && column ==0) {
	    		ch="q1";
	    	}else if (row == 0 && column ==1) {
				ch="q2";
			}else if (row == 1 && column ==0) {
				ch="q3";
			}else  {
				ch="q4";
			}
	    	switch (ch) {
				case "q1":
					for(i=0; i<2;i++) {
						for(j=0; j<2 & k<4;j++,k++) {
							array[k]=data[i][j];
						}
					}
					
					break;
					
				case "q2":
					for(i=0; i<2;i++) {
						for(j=2; j<4 & k<4;j++,k++) {
							array[k]=data[i][j];
						}
					}
					
					break;
					
				case "q3":
					for(i=2; i<4;i++) {
						for(j=0; j<2 & k<4;j++,k++) {
							array[k]=data[i][j];
						}
					}
					
					break;
					
				case "q4":
					for(i=2; i<4;i++) {
						for(j=2; j<4 & k<4;j++,k++) {
							array[k]=data[i][j];
						}
					}
					
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + ch);
				}
	        return array;
	    }
 
}
