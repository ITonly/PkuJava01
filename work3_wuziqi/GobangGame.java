import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GobangGame {
	
	//定义达到赢条件的棋子数目
	private final int WIN_COUNT=5;
	private int posX=0;
	private int posY=0;
	
	private Chessboard chessboard;
	/**
	 * 空构造器
	 */
	public GobangGame(){
		
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * @param chessboard
	 * 					棋盘类
	 */
	
	public GobangGame(Chessboard chessboard){
		this.chessboard=chessboard;
	}
	
	public boolean isValid(String inputStr){
		String[] posStrArr=inputStr.split(",");
		try{
			posX=Integer.parseInt(posStrArr[0])-1;
			posY=Integer.parseInt(posStrArr[1])-1;
		}catch(NumberFormatException e){
			chessboard.printBoard();
			System.out.println("请以（数字，数字）的格式输入：");
			return false;
		}
		//检查输入数值是否在范围之内
		if(posX<0 || posX>=Chessboard.BOARD_SIZE ||posY<0
				||posY>=Chessboard.BOARD_SIZE){
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于"+Chessboard.BOARD_SIZE
					+",请重新输入");
			
		}
		
		//检查输入的位置是否有棋子
		String[][] board=chessboard.getBoard();
		if(board[posX][posY]!="十"){
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
		}
		return true;
	}
	
	/**
	 * 开始下棋
	 * @param args
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
				int[] computerPosArr = computerDo(posX,posY);
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
	public int[] computerDo(int posX,int posY) {
		String[][] board=chessboard.getBoard();
		//水平方向判断
		int RLastY=posY;
		String chessman = Chessman.BLACK.getChessman();
		while(RLastY>0 && board[posX][RLastY]==chessman){
			RLastY--;
		}
		int LRLastY=RLastY; 
		int RNum=0;
		RLastY++;
		while(RLastY<Chessboard.BOARD_SIZE&&board[posX][RLastY]==chessman){
			RNum++;
			RLastY++;
		}
		//竖直方向判断
		int LLastX=posX;
		while(LLastX>0 && board[LLastX][posY]==chessman){
			LLastX--;
		}
		int LLLastX=LLastX; 
		int LNum=0;
		LLastX++;
		while(LLastX<Chessboard.BOARD_SIZE&&board[LLastX][posY]==chessman){
			LLastX++;
			LNum++;
		}
		//右上左下判断
		int RULastX = posX;
		int LDLastY = posY;

		// 判断有多少个连在一起了
		while (RULastX >0 && LDLastY < Chessboard.BOARD_SIZE&& board[RULastX][LDLastY] == chessman) {
			RULastX--;
			LDLastY++;
		}
		int RRULastX=RULastX;//记录右上方棋盘的x坐标
		int ULDLastY=LDLastY;//记录右上方棋盘的y坐标
		int LDNum = 0;
		RULastX++;
		LDLastY--;
	
		while (LDLastY >0&& RULastX <  Chessboard.BOARD_SIZE
				&& board[RULastX][LDLastY] == chessman) {
			LDNum++;
			RULastX++;
			LDLastY--;
		}
		
		//左上右下判断
				int LULastX = posX;
				int RDLastY = posY;

				// 判断有多少个连在一起了
				while (LULastX > 0 && RDLastY>=0&& board[LULastX][RDLastY] == chessman) {
					LULastX--;
					RDLastY--;
				}
				int LLULastX=LULastX;//记录左上方棋盘的x坐标
				int LRDLastY=RDLastY;//记录左上方棋盘的y坐标
				int LUNum = 0;
				LULastX++;
				RDLastY++;
			
				while (LULastX >0&& LULastX <  Chessboard.BOARD_SIZE
						&&RDLastY > 0&& RDLastY <  Chessboard.BOARD_SIZE 
						&&board[LULastX][RDLastY] == chessman) {
					LUNum++;
					LULastX++;
					RDLastY++;
				}
//		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		String[][] board = chessboard.getBoard();
//		while (board[posX][posY] != "十") {
//			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		}
				
		//取四个方向的最大值，从而决定电脑下在哪个位置
		int max=0;
		if(max<RNum)max=RNum;
		if(max<LNum)max=LNum;
		if(max<LDNum)max=LDNum;
		if(max<LUNum)max=LUNum;
		
		//int[] result={0,0};
		int x=0;
		int y=0;
		
		//水平方向判断，最左边和最右边是否为空
		if(max==RNum){
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
				
																	}
					else{
						do{
							x = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
							y = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
							//int result1[] ={x,y};
						}while(board[posX][posY]!="十");
					}
			
		   }
		
		else{
			if(board[posX][LRLastY]=="十"){
				x=posX;
				y=LRLastY;
			}
			else if(board[posX][RLastY]=="十"){
				x=posX;
				y=RLastY;
			}
			
		}
	}
		//竖直方向判断最上方棋盘和最下方棋盘是否为空
		else if(max==LNum){
			
			if(board[LLastX][posY]=="十"){//最上方的棋盘是否是空的
				x=LLastX;
				y=posY;
			}
			else if(board[LNum][posY]=="十"){//最下方棋盘是否为空
				x=LNum;
				y=posY;
			}
			
	}
		//右上左下
	else	if(max==LDNum){
		if(board[RRULastX][ULDLastY]=="十"){//最右上方的棋盘是否是空的
			x=RRULastX;
			y=ULDLastY;
		}
		else if(board[RULastX][LDLastY]=="十"){//最左下棋盘是否为空
			x=RULastX;
			y=LDLastY;
		}
	}
	else	if(max==LUNum){
		if(board[LLULastX][LRDLastY]=="十"){//最左上方的棋盘是否是空的
			x=LLULastX;
			y=LRDLastY;
		}
		else if(board[LULastX][RDLastY]=="十"){//最右下棋盘是否为空
			x=LULastX;
			y=RDLastY;
		}
	}
//		else if(max==LNum){
//			
//			if(board[posX][LLLastY]=="十"){//最上方的棋盘是否是空的
//				x=posX;
//				y=LLLastY;
//			}
//			else if(board[posX][LLastY]=="十"){//最下方棋盘是否为空
//				x=posX;
//				y=LLastY;
//			}
//			
//	}
//		
		int[] result = {x, y };
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
		int startX=0;
		int startY=0;
		int endX=Chessboard.BOARD_SIZE-1;
		int endY=endX;
		int count=0;
		int temp=0;
		//计算起点的最小X坐标与Y坐标
		temp=posX-WIN_COUNT+1;
		startX=temp<0 ? 0:temp;
		temp=posY-WIN_COUNT+1;
		startY=temp<0 ? 0:temp;
		temp=posX+WIN_COUNT-1;
		endX=temp>Chessboard.BOARD_SIZE-1?Chessboard.BOARD_SIZE-1:temp;
		temp=posY+WIN_COUNT-1;
		endY=temp>Chessboard.BOARD_SIZE-1?Chessboard.BOARD_SIZE-1:temp;
		String[][] board=chessboard.getBoard();
		//判断横向
		for(int i=startY;i<endY;i++){
			if(board[posX][i]==ico && board[posX][i+1]==ico){
				count++;
			}else if(count!=WIN_COUNT-1){
				count=0;
				
			}
			}
		//判断竖直方向
		for(int i=startX;i<endX;i++){
			if(board[i][posY]==ico && board[i+1][posY]==ico){
				count++;
			}else if(count!=WIN_COUNT-1){
				count=0;
				
			}
			}
		//判断斜的方向
		for(int i=startY;i<endY;i++){
			if(board[i][i]==ico && board[i+1][i+1]==ico){
				count++;
			}else if(count!=WIN_COUNT-1){
				count=0;
				
			}
			}
			if(count==0){
				return false;}
			
			else {
				return true;}

	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}

}
