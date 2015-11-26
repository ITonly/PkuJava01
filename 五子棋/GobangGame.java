package chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0 || posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE + ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			//十
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				//System.out.println("posX: "+posX);
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo(posX,posY);
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1], chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			// System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，" : "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机智能下棋
	 * （堵棋）堵在各个方向黑棋相连数多的位置
	 */
	public int[] computerDo(int lastX, int lastY) {

		/*int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}*/
		int posX = 0, posY=0;
		String[][] board = chessboard.getBoard();
		
		String chessman = Chessman.BLACK.getChessman();
		int num1=1,num2=1,num3=1,num4=1;
		//水平方向
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
		//垂直方向
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
		//右斜方向
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
		//左斜方向
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
		
		//循环判断，避免周围都达到边界
		while(true){
			if(max == num1){
				if(leftY != -1 && board[lastX][leftY] == "十"){
					posX = lastX;
					posY = leftY;
					break;
				}else if(rightY != Chessboard.BOARD_SIZE && board[lastX][rightY] == "十"){
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
				if(upX != -1 && board[upX][lastY] == "十"){
					posX = upX;
					posY = lastY;
					break;
				}else if(downX != Chessboard.BOARD_SIZE && board[downX][lastY] == "十"){
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
				if(rightupX != -1 && rightupY != Chessboard.BOARD_SIZE && board[rightupX][rightupY] == "十"){
					posX = rightupX;
					posY = rightupY;
					break;
				}else if(leftdownX != Chessboard.BOARD_SIZE && leftdownY != -1 && board[leftdownX][leftdownY] == "十"){
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
				if(leftupX != -1 && leftupY != -1 && board[leftupX][leftupY] == "十"){
					posX = leftupX;
					posY = leftupY;
					break;
				}else if(rightdownX != Chessboard.BOARD_SIZE && rightdownY != Chessboard.BOARD_SIZE && board[rightdownX][rightdownY] == "十"){
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
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		int count = 1;
		// 判断水平方向
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
		// 判断垂直方向
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
		// 判断右斜方向
		count = 1;
		//右斜上
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
			//右斜下
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
		// 判断左斜方向
		count = 1;
		//左斜上
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
