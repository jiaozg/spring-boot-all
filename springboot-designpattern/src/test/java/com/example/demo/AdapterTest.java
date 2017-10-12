package com.example.demo;

public class AdapterTest {

	public static void main(String[] args) {
		HoleMaker maker = new HoleMakerImpl();
		maker.makeHole(1);
		maker.makeHole(2);
		maker.makeHole(30);
		maker.makeHole(40);
	}
}

interface HoleMaker {
	public void makeHole(int diameter);
}

interface DrillBit {
	public void makeSmallHole();
	public void makeBigHole();
}

// Two adaptee objects
class BigDrillBit implements DrillBit {

	@Override
	public void makeSmallHole() {
		// do nothing
	}

	@Override
	public void makeBigHole() {
		System.out.println("Big hole is made byt WallBigHoleMaker");
	}
}

class SmallDrillBit implements DrillBit {

	@Override
	public void makeSmallHole() {
		System.out.println("Small hole is made byt WallSmallHoleMaker");
	}

	@Override
	public void makeBigHole() {
		// do nothing
	}
}

// Adapter class
class Drill implements HoleMaker {

	private DrillBit drillBit;

	public Drill(int diameter) {
		drillBit = getMakerByDiameter(diameter);
	}

	@Override
	public void makeHole(int diameter) {
		if (isSmallDiameter(diameter)) {
			drillBit.makeSmallHole();
		} else {
			drillBit.makeBigHole();
		}
	}

	private DrillBit getMakerByDiameter(int diameter) {
		if (isSmallDiameter(diameter)) {
			return new SmallDrillBit();
		}
		return new BigDrillBit();
	}

	private boolean isSmallDiameter(int diameter) {
		return diameter < 10;
	}
}

// Client class
class HoleMakerImpl implements HoleMaker {

	@Override
	public void makeHole(int diameter) {
		HoleMaker maker = new Drill(diameter);
		maker.makeHole(diameter);
	}

}
