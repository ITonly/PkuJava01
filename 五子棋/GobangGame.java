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
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
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
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
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
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
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
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		
		String[][] board=chessboard.getBoard();
		//水平方向判断
		int yy=posY;
		String chessman = Chessman.BLACK.getChessman();
		while(yy>0 && board[posX][yy]==chessman){
			yy--;
		}
		int y0=yy; 
		int num1=0;
		yy++;
		while(yy<Chessboard.BOARD_SIZE&&board[posX][yy]==chessman){
			num1++;
			yy++;
		}
		//竖直方向判断
		int xx=posX;
		while(xx>0 && board[xx][posY]==chessman){
					xx--;
		}
		int x0=xx; 
		int num2=0;
		xx++;
		while(xx<Chessboard.BOARD_SIZE&&board[xx][posY]==chessman){
			xx++;
			num2++;
		}		
		//取四个方向的最大值，从而决定电脑下在哪个位置
		int max=0;
		if(max<num1)max=num1;
		if(max<num2)max=num2;
		int x=0;
		int y=0;
		
		//水平方向判断，最左边和最右边是否为空
		if(max==num1){
			if(max==1){
				if(posY==1){
					x=posX;
					y=posY+1;
			}
				if(posY==21){
					x=posX;
					y=posY-1;
				}
				else if(board[posX][posY+1]=="十"){
				
							x=posX;
							y=posY+1;
																	
				}else{
						do{
							x = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
							y = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
							//int result1[] ={x,y};
						}while(board[posX][posY]!="十");
					}
			
		}else{
			if(board[posX][y0]=="十"){
				x=posX;
				y=y0;
			}else if(board[posX][yy]=="十"){
				x=posX;
				y=yy;
			}
			
		}
	}//竖直方向判断最上方棋盘和最下方棋盘是否为空
		else if(max==num2){
			if(board[xx][posY]=="十"){//最上方的棋盘是否是空的
				x=xx;
				y=posY;
			}
			else if(board[num2][posY]=="十"){//最下方棋盘是否为空
				x=num2;
				y=posY;
			}
	}		
		int[] result = { x, y };
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
		int x1 = 0;//x起点坐标
		int x2 = 0;//x终点坐标
		int y1 = chessboard.BOARD_SIZE;//y起点坐标
		int y2 = chessboard.BOARD_SIZE;//y终点坐标
		int count = 0;//某一方向上同种棋子的个数
		int others = WIN_COUNT - 1;//除了当前的棋子外还需要的其他棋子的个数
		String[][] board = chessboard.getBoard();
		if(posX - others < 0 ){
			x1 = 0;
		}else{
			x1 = posY - others;
		}
		if(posY - others < 0 ){
			y1 = 0;
		}else{
			y1 = posY - others;
		}
		if(posX + others > chessboard.BOARD_SIZE){
			x2 = chessboard.BOARD_SIZE;
		}else{
			x2 = posX + others;
		}
		if(posY + others > chessboard.BOARD_SIZE){
			y2 = chessboard.BOARD_SIZE;
		}else{
			y2 = posY + others;
		}
		//横向判断是否有五个连在一起相同颜色的棋子
		for(int i = y1 ; i < y2 ; i++){
			if(board[posX][i] == ico && board[posX][i+1] == ico){
				count ++;
			}else if(count != others){
				count = 0;
			}
		}
		//纵向判断是否有五个连在一起相同颜色的棋子
		for (int i = x1; i < x2; i++) {
			if(board[i][posY] == ico && board[i+1][posY] == ico){
				count ++;
			}else if(count != others){
				count = 0;
			}
		}
		//斜向判断是否有五个连在一起相同颜色的棋子
		for (int i = x1; i < x2; i++) {
			if(board[i][i] == ico && board[i+1][i+1] == ico){
				count++;
			}else if(count != others){
				count=0;
			}
		}
		if (count == 0) {
			return false;
		}else{
			return true;
		}
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
