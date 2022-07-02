package grade;
import java.util.*;

public class grade {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int [] num;
		int [] kor;
		int [] eng;
		int [] math;
		int [] sum;
		float [] evg;
		char [] grade;
		int [] rank;
		int inum, i, j, temp;
		float ftemp;
		char ctemp;
		char k;
		int l;
		
		System.out.printf("학생수 입력 : ");
		inum = sc.nextInt();
		
		num = new int[inum];
		kor = new int[inum];
		eng = new int[inum];
		math = new int[inum];
		sum = new int[inum];
		evg = new float[inum];
		grade = new char[inum];
		rank = new int[inum];
		
		for(i = 0; i < inum; i++) {
			System.out.printf("[%d] 국어, 영어, 수학 : ", i + 1);
			kor[i] = sc.nextInt();
			eng[i] = sc.nextInt();
			math[i] = sc.nextInt();
			sum[i] = kor[i] + eng[i] + math[i];
			evg[i] = (float)sum[i] / 3;
			rank[i] = 1;
			num[i] = i + 1;
			}
		
		for(i = 0; i < inum; i++) {			
			if(evg[i] >= 90)
				grade[i] = 'A';
			else if(evg[i] >= 80)
				grade[i] = 'B';
			else if(evg[i] >= 70)
				grade[i] = 'C';
			else if(evg[i] >= 60)
				grade[i] = 'D';
			else
				grade[i] = 'F';
			}

		for(i = 0; i < inum; i++) {
			for(j = 0; j < inum; j++) {
				if(sum[i] < sum[j])
					rank[i]++;
			}
		}
		
		System.out.println("1. 성적표를 출력하시겠습니까(y, n)? :");
		k = sc.next().charAt(0);
		if(k == 'y' || k == 'Y') {
			
			while(true) {
				System.out.println("<1>오름차순  <2>내림차순 : ");
				l = sc.nextInt();
				
				for(i = 0; i < inum; i++) {
					for(j = i; j < inum; j++) {
						if(rank[i] > rank[j]) {
							
							temp = rank[i];
							rank[i] = rank[j];
							rank[j] = temp;
							
							ctemp = grade[i];
							grade[i] = grade[j];
							grade[j] = ctemp;
							
							ftemp = evg[i];
							evg[i] = evg[j];
							evg[j] = ftemp;
							
							temp = sum[i];
							sum[i] = sum[j];
							sum[j] = temp;
							
							temp = math[i];
							math[i] = math[j];
							math[j] = temp;
							
							temp = eng[i];
							eng[i] = eng[j];
							eng[j] = temp;
							
							temp = kor[i];
							kor[i] = kor[j];
							kor[j] = temp;

							temp = num[i];
							num[i] = num[j];
							num[j] = temp;
						}
					}
				}
				
				if(l == 1) {
					
					System.out.println("");
					System.out.printf("=========================== 성적표 ===========================\n");
					System.out.printf("============================================================\n");
					System.out.printf("번호\t 국어 \t 영어 \t 수학 \t 합계 \t 평균 \t 학점\t 석차\n");
					for(i = 0; i < inum; i++)
						System.out.printf("[%d]\t %d \t %d \t %d \t %d \t%.2f \t  %c\t  %d\n", num[i], kor[i], eng[i], math[i], sum[i], evg[i], grade[i], rank[i]);
						System.out.printf("============================================================\n");
						break;
						
				}//while 내부 if end
				else if(l == 2) {
			
					System.out.println("");
					System.out.printf("=========================== 성적표 ===========================\n");
					System.out.printf("============================================================\n");
					System.out.printf("번호\t 국어 \t 영어 \t 수학 \t 합계 \t 평균 \t 학점\t 석차\n");
					for(i = inum - 1; i >= 0; i--)
						System.out.printf("[%d]\t %d \t %d \t %d \t %d \t%.2f \t  %c\t  %d\n", num[i], kor[i], eng[i], math[i], sum[i], evg[i], grade[i], rank[i]);
						System.out.printf("============================================================\n");
						break;
						
				}//while 내부 else if end
				else
					System.out.println("1 과 2 중에서만 골라주세요.");
			}//while end
		}//if end
		else
			System.out.println("성적을 출력하지 않습니다.");
	}
}