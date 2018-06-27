////////////////////////////////////////////////////////////////////////////////////
//
//  C212 Spring 17
//  Lab 5 
//  
//  Due: 2/14/17 11:59 PM
//
//  Author  Rebecca Fisch rhfisch
//  Last Edited: 2/9/17
//               
//////////////////////////////////////////////////////////////////////////////////
package Lab5;
public class Lab5Matrix {
	private double[][] matrix;
	private final int NUMROW;
	private final int NUMCOL;

	public Lab5Matrix(double[][] m) {
		matrix = m;
		NUMROW = m.length;
		NUMCOL = m[0].length;
	}

	public String toString() { // makes chart of the matrix
		String chart = "";
		for (int i = 0; i < NUMROW; i++) {
			chart += "[";
			for (int j = 0; j < NUMCOL; j++) {
				chart += "" + matrix[i][j];
				if (j != NUMCOL - 1) {
					chart += ",";
				}
			}
			chart += "]" + "\n";
		}
		return chart;
	}

	public Lab5Matrix getRowMatrix(int m) { // returns the string of the
											// specified row of the matrix
		double[][] row = new double[1][NUMROW];
		if (m > matrix.length || m < 0) {
			System.out
					.println("Waring, the number row you are looking for does not exist");
		}
		for (int i = 0; i < NUMROW; i++) {
			row[0][i] = matrix[i][m];
		}
		Lab5Matrix retVar = new Lab5Matrix(row);
		System.out.println(retVar.toString());
		return retVar;
	}

	public Lab5Matrix getColMatrix(int m) { // returns the string of the
											// specified column of the matrix
		if (m > matrix[0].length || m < 0) {
			System.out
					.println("Waring, the number column you are looking for does not exist");
		}
		double[][] col = new double[NUMCOL][1];
		for (int j = 0; j < NUMCOL; j++) {
			col[j][0] += matrix[m][j];
		}
		Lab5Matrix retVar2 = new Lab5Matrix(col);
		System.out.println(retVar2.toString());
		return retVar2;
	}

	public Lab5Matrix transpose() {// switches the x and y coordinates and also
									// switches the matrix bounds
		double[][] trans = new double[NUMCOL][NUMROW];
		for (int i = 0; i < NUMROW; i++) {
			for (int j = 0; j < NUMCOL; j++) {
				trans[j][i] = matrix[i][j];
			}
		}
		Lab5Matrix transp = new Lab5Matrix(trans);
		System.out.println(transp.toString());
		return transp;
	}

	public Lab5Matrix upperDiagonal() {// makes everything above the diagonal
										// line zero in the matrix
		double[][] upper = new double[NUMROW][NUMCOL];
		for (int i = 0; i < NUMROW; i++) {
			for (int j = 0; j < NUMCOL; j++) {
				if (i < j && j != i) {
					upper[i][j] = 0.0;
				} else {
					upper[i][j] = matrix[i][j];
				}
			}
		}
		Lab5Matrix up = new Lab5Matrix(upper);
		return up;
	}

	public Lab5Matrix lowerDiagonal() {// makes everything below the diagonal
										// line zero in the matrix
		double[][] lower = new double[NUMROW][NUMCOL];
		for (int i = 0; i < NUMROW; i++) {
			for (int j = 0; j < NUMCOL; j++) {
				if (i > j && j != i) {
					lower[i][j] = 0.0;
				} else {
					lower[i][j] = matrix[i][j];
				}
			}
		}
		Lab5Matrix low = new Lab5Matrix(lower);
		return low;
	}

	public Lab5Matrix diagonalMatrix() {// uses upperDiagonal() and
										// lowerDiagonal() to return the matrix
										// with just the diagonal
		Lab5Matrix dia = new Lab5Matrix(matrix);
		dia = dia.upperDiagonal().lowerDiagonal();
		return dia;
	}

	public static void main(String[] args) {
		double[][] matrix1 = { { 3.0, 1.0, 2.0, 3.0 }, { 4.0, 5.0, 6.0, 7.0 },
				{ 8.0, 9.0, 1.0, 1.0 }, { 1.0, 1.0, 1.0, 1.0 } };
		Lab5Matrix test = new Lab5Matrix(matrix1);
		double[][] matrix2 = { { 1.2, 2.8, 5.6 }, { 3, 8, 9 } };
		Lab5Matrix test2 = new Lab5Matrix(matrix2);
		System.out.println("Row of a matrix:");
		test.getRowMatrix(3);
		System.out.println("Column of a matrix:");
		test.getColMatrix(1);
		System.out.println("Transposes a matrix:");
		test2.transpose();
		System.out.println("The upper diagonal of a matrix:");
		System.out.println(test.upperDiagonal().toString());
		System.out.println("The lower diagonal of a matrix:");
		System.out.println(test.lowerDiagonal().toString());
		System.out.println("Just the diagonal of a matrix:");
		System.out.println(test.diagonalMatrix());
	}
}
