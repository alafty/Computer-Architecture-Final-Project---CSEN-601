package Main;
import java.io.*;
import java.util.*;


public class Lame {
	int memory[] = new int[1000];
	int register[] = new int[32];
	String path;

	public Lame(String path) {
		this.path = path;
		initializeEmpty(memory);
		initializeEmpty(register);
	}

	public void initializeEmpty(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = -100;
		}
	}

	public void printNonEmpty(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != -100)
				System.out.println("At index " + i + " Value: " + array[i]);
		}
	}

	public int getRegisterIndex(String registerName) {
		int result = 0;

		if (registerName .equals("$zero"))
			return 0;
		if (registerName .equals("$at"))
			return 1;

		if (registerName .equals("$v0"))
			return 2;

		if (registerName .equals("$v1"))
			return 3;

		if (registerName .equals("$a0"))
			return 4;

		if (registerName .equals("$a1"))
			return 5;

		if (registerName .equals("$a2"))
			return 6;

		if (registerName .equals("$a3"))
			return 7;

		if (registerName .equals("$t0"))
			return 8;

		if (registerName .equals("$t1"))
			return 9;

		if (registerName .equals("$t2"))
			return 10;

		if (registerName .equals("$t3"))
			return 11;

		if (registerName .equals("$t4"))
			return 12;

		if (registerName .equals("$t5"))
			return 13;

		if (registerName .equals("$t6"))
			return 14;

		if (registerName .equals("$t7"))
			return 15;

		if (registerName .equals("$s0"))
			return 16;

		if (registerName .equals("$s1"))
			return 17;

		if (registerName .equals("$s2"))
			return 18;

		if (registerName .equals("$s3"))
			return 19;

		if (registerName .equals("$s4"))
			return 20;

		if (registerName .equals("$s5"))
			return 21;

		if (registerName .equals("$s6"))
			return 22;

		if (registerName .equals("$s7"))
			return 23;

		if (registerName .equals("$t8"))
			return 24;

		if (registerName .equals("$t9"))
			return 25;

		return result;
	}

	public void runInstruction(String instruction) {
		String[] parts = instruction.split(" ");
		if (parts[0].equals("ADD")) {
			String[] operands = parts[1].split(",");
			int indexOutput = getRegisterIndex(operands[0]);
			int indexOp1 = getRegisterIndex(operands[1]);
			int indexOp2 = getRegisterIndex(operands[2]);

			register[indexOutput] = register[indexOp1] + register[indexOp2];
			printNonEmpty(register);
			System.out.println("--------Instruction Done---------");
		} else if (parts[0].equals("ADDI")) {

			String[] operands = parts[1].split(",");
			int indexOutput = getRegisterIndex(operands[0]);
			int indexOp1 = getRegisterIndex(operands[1]);
			int immediate = Integer.parseInt(operands[2]);

			register[indexOutput] = register[indexOp1] + immediate;
			printNonEmpty(register);
			System.out.println("--------Instruction Done---------");
		}
	}

	public void runProgram() {
		try {
			File myObj = new File(path);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				runInstruction(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Lame run = new Lame("User directory/Programs/program.txt");

		run.runProgram();

	}
}
