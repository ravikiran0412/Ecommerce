package Ravikiran.seleniumframeworkDesign.Tests;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.testng.Assert;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="mmababctamantlslmag";
	    int distinct = 0 ;

	    for (int i = 0; i < s.length(); i++) {

	        for (int j = 0; j < s.length(); j++) {

	            if(s.charAt(i)==s.charAt(j))
	            {
	                distinct++;

	            }
	        }   
	        System.out.println(s.charAt(i)+"--"+distinct);
	        String d=String.valueOf(s.charAt(i));
	        System.out.println(d);
	        s=s.replaceAll(d,"");
	        distinct = 0;
	    }

		
	   }
	
	}