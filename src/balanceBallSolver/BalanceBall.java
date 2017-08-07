package balanceBallSolver;

import java.util.ArrayList;
import java.util.List;

public class BalanceBall {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,0,0,0,1,0,0,0,0,0,0,0};
		balanceSolver(arr);
	}
	
	public static void balanceSolver(int[] arr) {
		
		int i,j,ind;
		int left = 0;
		int right = 0;

		List<Integer> a= new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		List<Integer> heavy = new ArrayList<>();
		List<Integer> light = new ArrayList<>();

		
		ind=0;
		for(i=0;i<12;i++){
			System.out.print(arr[i]);
		}
		System.out.println();
		System.out.println("---weigh1: A1,A2,A3,A4 vs B1,B2,B3,B4---");
		for(i=0;i<4;i++) {
			a.add(arr[ind]);
			ind++;
		}
		for(i=0;i<4;i++) {
			b.add(arr[ind]);
			ind++;
		}
		for(i=0;i<4;i++) {
			c.add(arr[ind]);
			ind++;
		}
		
		for(i=0;i<a.size();i++) {
			left += a.get(i);
			
		}
		for(i=0;i<b.size();i++) {
			right += b.get(i);
		}
		
		if(left==right) {
			System.out.println("A1,A2,A3,A4 == B1,B2,B3,B4");
			for(i=0;i<3;i++) {
				left += c.get(i);
			}
			for(i=0;i<3;i++) {
				right += a.get(i);
			}
			System.out.println("---weigh2: C1C2C3 vs A1A2A3---");
			if(left==right) {
				System.out.println("C1C2C3 == A1A2A3");
				System.out.println("---weigh3: C4 vs A4---");
				if(c.get(3) > a.get(3)) {
					System.out.println("Heavy Ball: C4");
				}
				else {
					System.out.println("Light Ball: C4");
				}
			}
			else if (left>right) {
				System.out.println("C1C2C3 > A1A2A3");
				System.out.println("---weigh3: C1 vs C2---");
				if(c.get(0)==c.get(1)) System.out.println("Heavy Ball: C3");
				else if(c.get(0)>c.get(1)) System.out.println("Heavy Ball: C1");
				else if(c.get(0)<c.get(1)) System.out.println("Heavy Ball: C2");
			}
			else if (left<right) {
				System.out.println("C1C2C3 > A1A2A3");
				System.out.println("---weigh3: C1 vs C2---");
				if(c.get(0)==c.get(1)) System.out.println("Light Ball: C3");
				else if(c.get(0)>c.get(1)) System.out.println("Light Ball: C2");
				else if(c.get(0)<c.get(1)) System.out.println("Light Ball: C1");
			}
		
		}// compare a==b
		else if (left>right) {
			//a is heavier
			System.out.println("A1A2A3A4 > B1B2B3B4");
			for(int counter:a) {
				heavy.add(counter);
			}
			for(int counter:b) {
				light.add(counter);
			}
			
			System.out.println("---weigh2: A1A2B1 vs A3A4B2---");
			left = heavy.get(0)+heavy.get(1)+light.get(0);
			right = heavy.get(2)+heavy.get(3)+light.get(1);
			
			if(left>right) {
				System.out.println("A1A2B1 > A3A4B2");
				System.out.println("---weigh3: A1 vs A2---");
				if(heavy.get(0)==heavy.get(1)) System.out.println("Light Ball: B2");
				else if(heavy.get(0)>heavy.get(1)) System.out.println("Heavy Ball: A1");
				else if(heavy.get(0)<heavy.get(1)) System.out.println("Heavy Ball: A2");
			}
			else if(left<right) {
				System.out.println("A1A2B1 > A3A4B2");
				System.out.println("---weigh3: A3 vs A4---");
				if(heavy.get(2)==heavy.get(3)) System.out.println("Light Ball: B1");
				else if(heavy.get(2)>heavy.get(3)) System.out.println("Heavy Ball: A3");
				else if(heavy.get(2)<heavy.get(3)) System.out.println("Heavy Ball: A4");
			}
			else if(left==right) {
				System.out.println("A1A2B1 == A3A4B2");
				System.out.println("---weigh3: B3 vs B4---");
				if(light.get(2) > light.get(3)) {
					System.out.println("Light Ball: B4");
				}
				else {
					System.out.println("Light Ball: B3");
				}
			}
			
			
		}
		else if (left<right) {
			//b is heavier
			System.out.println("A1A2A3A4 < B1B2B3B4");
			for(int counter:b) {
				heavy.add(counter);
			}
			for(int counter:a) {
				light.add(counter);
			}
			System.out.println("---weigh2: B1B2A1 vs B3B4A2---");
			left = heavy.get(0)+heavy.get(1)+light.get(0);
			right = heavy.get(2)+heavy.get(3)+light.get(1);
			
			if(left>right) {
				System.out.println("B1B2A1 > B3B4A2");
				System.out.println("---weigh3: B1 vs B2---");
				if(heavy.get(0)==heavy.get(1)) System.out.println("Light Ball: A2");
				else if(heavy.get(0)>heavy.get(1)) System.out.println("Heavy Ball: B1");
				else if(heavy.get(0)<heavy.get(1)) System.out.println("Heavy Ball: B2");
			}
			else if(left<right) {
				System.out.println("B1B2A1 < B3B4A2");
				System.out.println("---weigh3: B3 vs B4---");
				if(heavy.get(2)==heavy.get(3)) System.out.println("Light Ball: A1");
				else if(heavy.get(2)>heavy.get(3)) System.out.println("Heavy Ball: B3");
				else if(heavy.get(2)<heavy.get(3)) System.out.println("Heavy Ball: B4");
			}
			else if(left==right) {
				System.out.println("A1A2B1 == A3A4B2");
				System.out.println("---weigh3: A3 vs A4---");
				if(light.get(2) > light.get(3)) {
					System.out.println("Light Ball: A4");
				}
				else {
					System.out.println("Light Ball: A3");
				}
			}
		}
		
	}// end of function
		
		
	
	

}

//public ball{
//	
//	public ball() {
//		
//	}
//}



