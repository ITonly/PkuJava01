package chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0 || posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE + ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			//ʮ
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				//System.out.println("posX: "+posX);
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo(posX,posY);
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1], chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			// System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�" : "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * �������������
	 * �����壩���ڸ�������������������λ��
	 */
	public int[] computerDo(int lastX, int lastY) {

		/*int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}*/
		int posX = 0, posY=0;
		String[][] board = chessboard.getBoard();
		
		String chessman = Chessman.BLACK.getChessman();
		int num1=1,num2=1,num3=1,num4=1;
		//ˮƽ����
		int leftY = lastY-1;
		while(leftY >= 0 && board[lastX][leftY] == chessman){
			leftY--;
			num1++;
		}
		int rightY = lastY+1;
		while(rightY < Chessboard.BOARD_SIZE && board[lastX][leftY] == chessman){
			rightY++;
			num1++;
		}
		//��ֱ����
		int upX = lastX-1;
		while(upX >= 0 && board[upX][lastY] == chessman){
			upX--;
			num2++;
		}
		int downX = lastX+1;
		while(downX < Chessboard.BOARD_SIZE && board[downX][lastY] == chessman){
			downX++;
			num2++;
		}
		//��б����
		int rightupX = lastX-1;
		int rightupY = lastY+1;
		while(rightupX >= 0 && rightupY < Chessboard.BOARD_SIZE && board[rightupX][rightupY] == chessman){
			rightupX--;
			rightupY++;
			num3++;
		}
		int leftdownX = lastX+1;
		int leftdownY = lastY-1;
		while(leftdownY >= 0 && leftdownX < Chessboard.BOARD_SIZE && board[leftdownX][leftdownY] == chessman){
			leftdownX++;
			leftdownY--;
			num3++;
		}
		//��б����
		int leftupX = lastX-1;
		int leftupY = lastY-1;
		while(leftupX >= 0 && leftupY >=0 && board[leftupX][leftupY] == chessman){
			leftupX--;
			leftupY--;
			num4++;
		}
		int rightdownX = lastX+1;
		int rightdownY = lastY+1;
		while(rightdownY < Chessboard.BOARD_SIZE && rightdownX < Chessboard.BOARD_SIZE && board[rightdownX][rightdownY] == chessman){
			rightdownX++;
			rightdownY++;
			num4++;
		}
		
		int max = num1;
		if(max<num2)max=num2;
		if(max<num3)max=num3;
		if(max<num4)max=num4;
		
		//ѭ���жϣ�������Χ���ﵽ�߽�
		while(true){
			if(max == num1){
				if(leftY != -1 && board[lastX][leftY] == "ʮ"){
					posX = lastX;
					posY = leftY;
					break;
				}else if(rightY != Chessboard.BOARD_SIZE && board[lastX][rightY] == "ʮ"){
					posX = lastX;
					posY = rightY;
					break;
				}else{
					max = num2;
					if(max < num3)max=num3;
					if(max < num4)max=num4;
				}
			}
			if(max == num2){
				if(upX != -1 && board[upX][lastY] == "ʮ"){
					posX = upX;
					posY = lastY;
					break;
				}else if(downX != Chessboard.BOARD_SIZE && board[downX][lastY] == "ʮ"){
					posX = downX;
					posY = lastY;
					break;
				}else{
					max = num1;
					if(max < num3)max=num3;
					if(max < num4)max=num4;
				}
			}
			if(max == num3){
				if(rightupX != -1 && rightupY != Chessboard.BOARD_SIZE && board[rightupX][rightupY] == "ʮ"){
					posX = rightupX;
					posY = rightupY;
					break;
				}else if(leftdownX != Chessboard.BOARD_SIZE && leftdownY != -1 && board[leftdownX][leftdownY] == "ʮ"){
					posX = leftdownX;
					posY = leftdownY;
					break;
				}else{
					max = num4;
					if(max < num1)max=num1;
					if(max < num2)max=num2;
				}
			}
			if(max == num4){
				if(leftupX != -1 && leftupY != -1 && board[leftupX][leftupY] == "ʮ"){
					posX = leftupX;
					posY = leftupY;
					break;
				}else if(rightdownX != Chessboard.BOARD_SIZE && rightdownY != Chessboard.BOARD_SIZE && board[rightdownX][rightdownY] == "ʮ"){
					posX = rightdownX;
					posY = rightdownY;
					break;
				}else{
					max = num1;
					if(max < num2)max=num2;
					if(max < num3)max=num3;
				}
			}
		}
		
		
		int[] result = { posX, posY };
		
		return result;
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		int count = 1;
		// �ж�ˮƽ����
		int tempY = posY - 1;
		while (tempY >= 0 && count <= WIN_COUNT) {
			if (board[posX][tempY] == ico) {
				tempY--;
				count++;
			}else{
				break;
			}
		}
		if (count == WIN_COUNT) {
			return true;
		} else {
			tempY = posY + 1;
			while (tempY < chessboard.BOARD_SIZE && count <= WIN_COUNT) {
				if (board[posX][tempY] == ico) {
					tempY++;
					count++;
				}else{
					break;
				}
			}
			if (count == WIN_COUNT) {
				return true;
			}
		}
		// �жϴ�ֱ����
		count = 1;
		int tempX = posX - 1;
		while (tempX >= 0 && count <= WIN_COUNT) {
			if (board[tempX][posY] == ico) {
				tempX--;
				count++;
			}else{
				break;
			}
		}
		if (count == WIN_COUNT) {
			return true;
		} else {
			tempX = posX + 1;
			while (tempX < chessboard.BOARD_SIZE && count <= WIN_COUNT) {
				if (board[tempX][posY] == ico) {
					tempX++;
					count++;
				}else{
					break;
				}
			}
			if (count == WIN_COUNT) {
				return true;
			}
		}
		// �ж���б����
		count = 1;
		//��б��
		tempX = posX - 1;
		tempY = posY + 1;
		while (tempX >= 0 && tempY < chessboard.BOARD_SIZE && count <= WIN_COUNT) {
			if (board[tempX][tempY] == ico) {
				tempX--;
				tempY++;
				count++;
			}else{
				break;
			}
		}
		if (count == WIN_COUNT) {
			return true;
		} else {
			//��б��
			tempX = posX + 1;
			tempY = posY - 1;
			while (tempX < chessboard.BOARD_SIZE && tempY >= 0 && count <= WIN_COUNT) {
				if (board[tempX][tempY] == ico) {
					tempX++;
					tempY--;
					count++;
				}else{
					break;
				}
			}
			if (count == WIN_COUNT) {
				return true;
			}
		}
		// �ж���б����
		count = 1;
		//��б��
		tempX = posX + 1;
		tempY = posY + 1;
		while (tempX < chessboard.BOARD_SIZE && tempY < chessboard.BOARD_SIZE && count <= WIN_COUNT) {
			if (board[tempX][tempY] == ico) {
				tempX++;
				tempY++;
				count++;
			}else{
				break;
			}
		}
		if (count == WIN_COUNT) {
			return true;
		} else {
			tempX = posX - 1;
			tempY = posY - 1;
			while (tempX >= 0 && tempY >=0 && count <= WIN_COUNT) {
				if (board[tempX][tempY] == ico) {
					tempX--;
					tempY--;
					count++;
				}else{
					break;
				}
			}
			if (count == WIN_COUNT) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
