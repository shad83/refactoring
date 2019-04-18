package main.java.original;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name; // ����
	private Vector _rentals = new Vector(); // ���ӛ�

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0; // �����M���~
		int frequentRenterPoints = 0; // ���ͷe�c
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement(); // ȡ��һ�P���ӛ�
			// determine amounts for each line
			switch (each.getMovie().getPriceCode()) { // ȡ��ӰƬ����r��
			case Movie.REGULAR: // ��ͨƬ
				thisAmount += 2;
				if (each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE: // ��Ƭ
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS: // ��ͯƬ
				thisAmount += 1.5;
				if (each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}
			// add frequent renter points���ۼ� ���ͷe�c��
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1))
				frequentRenterPoints++;
			// show figures for this rental���@ʾ�˹P����Y�ϣ�
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines���Yβ��ӡ��
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}
}