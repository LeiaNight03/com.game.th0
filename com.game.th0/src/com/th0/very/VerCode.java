package com.th0.very;


public class VerCode {
        public String very(){
        	String codeArrey = "qwertyuiopasdfghjklzxcvbnm12345678900987654321QWERTYUIOPASDFGHJKLZXCVBNM";
        	String very ="";
        	for (int i =0;i<=5;i++){
        		int index = (int) (Math.random()*codeArrey.length());
        		char c= codeArrey.charAt(index);
        		very += c;
        	}
        	return very;
      
        }
}
