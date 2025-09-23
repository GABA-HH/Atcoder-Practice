package paiza;

import java.util.Scanner;

public class Hakuchumu {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		String d1 = "dream";
		String d2 = "dreamer";
		String e1 = "erase";
		String e2 = "eraser";
		
		String t = "";
		
////		int pd1 = s.indexOf(d1);
//		int pd2 = s.indexOf(d2);
//		int pe1 = s.indexOf(e1);
//		int pe2 = s.indexOf(e2);
		
		System.out.println("変換前:"+s);
		
		s = s.replaceAll(e2, "-");
		s = s.replaceAll(e1, "-");
		s = s.replaceAll(d1, "-");
		s = s.replaceAll(d2, "-");
		s = s.replaceAll("-", "");
		
		if (s.equals("")) {
			System.out.println("OK");
		} else {
			System.out.println("NO");
		}
		System.out.println("変換後:"+s);
		sc.close();
	}
	
	}

