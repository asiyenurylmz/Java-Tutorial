package com;

import java.util.Scanner;

public class Spiral_matrix {
	int width;
	int[][] matrix;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Sayi giriniz");
		Spiral_matrix matrix = new Spiral_matrix(scan.nextInt());
		System.out.println(matrix);
	}

	public Spiral_matrix(int a) {
		this.width = a;

		int lastX = 0;
		int lastY = 0;

		int maxNumb = (a * a - 1);
		matrix = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = -1;
			}
		}
		try {
			while (maxNumb >= 0) {
				if (matrix[lastY][lastX] == -1) {
					for (int x = lastX; x < this.width && matrix[x][lastY] == -1; x++) { 
						matrix[lastY][x] = maxNumb;
						--maxNumb;
						lastX = x;
					}
				}
				if (matrix[lastY + 1][lastX] == -1) {
					for (int y = (lastY + 1); y < this.width && matrix[lastX][y] == -1; y++) { 
						matrix[y][lastX] = maxNumb;
						--maxNumb;
						lastY = y;
					}
				}
				if (matrix[lastY][lastX - 1] == -1) {
					for (int x = (lastX - 1); x >= 0 && matrix[lastY][x] == -1; x--) {
						matrix[lastY][x] = maxNumb;
						--maxNumb;
						lastX = x;
					}
				}
				if (matrix[lastY - 1][lastX] == -1) {
					for (int y = (lastY - 1); y >= 0 && matrix[y][lastX] == -1; y--) {
						matrix[y][lastX] = maxNumb;
						--maxNumb;
						lastY = y;
					}
				}
				lastX += 1;
			}
		} catch (

		ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception thrown  :" + e);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				builder.append(matrix[i][j] + "\t");
				// System.out.print(matrix[i][j] + " ");
				if (j == width - 1) {
					builder.append("\n");
					// System.out.println();
				}
			}
		}
		return builder.toString();
	}
}
