package servlet;

import java.util.Scanner;

public class pay {
	public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	System.out.println("�����뵥�ۣ�������");
	double unitPrice;
	unitPrice = scan.nextDouble();
	
	System.out.println("�����������������");
	int count;
	count = scan.nextInt();
	
	System.out.println("�����븶�������");
	double payment;
	payment = scan.nextDouble();
	
	double totalPrice;//�ܽ��
	totalPrice = unitPrice * count;
	
	double change;//����
	
	if(payment>=totalPrice) {
		if(totalPrice>=500) {
			change = payment - totalPrice * 0.8;
			System.out.println("Ӧ�ս�������" + (totalPrice * 0.8) + ", Ӧ���㣨������" + change);
		}else {
			change = payment - totalPrice;
			System.out.println("Ӧ�ս�������" + totalPrice + ", Ӧ���㣨������" + change);
		}
	}else {
		System.out.println("����Ҫ��֧����������" + (totalPrice - payment));
	}
	}
}
	
