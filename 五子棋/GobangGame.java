import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GobangGame {
	// �����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û�������X����
	private int posX = 0;
	// �����û�������X����
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
	 * ���������Ƿ��Ϸ���
	 *
	 * @param inputStr
	 *            �ɿ���̨�������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û��������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ����������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ����������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
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
		// br.readLine:ÿ����������һ�����ݰ��س����������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// �������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ����������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ������Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// ��������ʤ�ߣ�ѯ���û��Ƿ�������Ϸ
			if (isOver) {
				// �������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// �������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("�����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 *
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ��������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ��������������
	 */
   public int[] computerDo(int posX,int posY) {
   		String[][] board=chessboard.getBoard();
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
   		int RULastX = posX;
   		int LDLastY = posY;
   		while (RULastX >0 && LDLastY < Chessboard.BOARD_SIZE&& board[RULastX][LDLastY] == chessman) {
   			RULastX--;
   			LDLastY++;
   		}
   		int RRULastX=RULastX;
   		int ULDLastY=LDLastY;
   		int LDNum = 0;
   		RULastX++;
   		LDLastY--;

   		while (LDLastY >0&& RULastX <  Chessboard.BOARD_SIZE
   				&& board[RULastX][LDLastY] == chessman) {
   			LDNum++;
   			RULastX++;
   			LDLastY--;
   		}
   				int LULastX = posX;
   				int RDLastY = posY;
   				while (LULastX > 0 && RDLastY>=0&& board[LULastX][RDLastY] == chessman) {
   					LULastX--;
   					RDLastY--;
   				}
   				int LLULastX=LULastX;
   				int LRDLastY=RDLastY;
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
   		int max=0;
   		if(max<RNum)max=RNum;
   		if(max<LNum)max=LNum;
   		if(max<LDNum)max=LDNum;
   		if(max<LUNum)max=LUNum;

   		int x=0;
   		int y=0;

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
   				else if(board[posX][posY+1]=="ʮ"){

   							x=posX;
   							y=posY+1;
   																	}
   					else{
   						do{
   							x = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
   							y = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
   						}while(board[posX][posY]!="ʮ");
   					}

   		   }

   		else{
   			if(board[posX][LRLastY]=="ʮ"){
   				x=posX;
   				y=LRLastY;
   			}
   			else if(board[posX][RLastY]=="ʮ"){
   				x=posX;
   				y=RLastY;
   			}

   		}
   	}
   		//��ֱ�����ж����Ϸ����̺����·������Ƿ�Ϊ��
   		else if(max==LNum){

   			if(board[LLastX][posY]=="ʮ"){//���Ϸ��������Ƿ��ǿյ�
   				x=LLastX;
   				y=posY;
   			}
   			else if(board[LNum][posY]=="ʮ"){//���·������Ƿ�Ϊ��
   				x=LNum;
   				y=posY;
   			}

   	}
   		//��������
   	else	if(max==LDNum){
   		if(board[RRULastX][ULDLastY]=="ʮ"){//�����Ϸ��������Ƿ��ǿյ�
   			x=RRULastX;
   			y=ULDLastY;
   		}
   		else if(board[RULastX][LDLastY]=="ʮ"){//�����������Ƿ�Ϊ��
   			x=RULastX;
   			y=LDLastY;
   		}
   	}
   	else	if(max==LUNum){
   		if(board[LLULastX][LRDLastY]=="ʮ"){//�����Ϸ��������Ƿ��ǿյ�
   			x=LLULastX;
   			y=LRDLastY;
   		}
   		else if(board[LULastX][RDLastY]=="ʮ"){//�����������Ƿ�Ϊ��
   			x=LULastX;
   			y=RDLastY;
   		}
   	}
   		int[] result = {x, y };
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
	 * @return ����������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		int x1 = 0;//x��������
		int x2 = 0;//x�յ�����
		int y1 = chessboard.BOARD_SIZE;//y��������
		int y2 = chessboard.BOARD_SIZE;//y�յ�����
		int count = 0;//ĳһ������ͬ�����ӵĸ���
		int others = WIN_COUNT - 1;//���˵�ǰ�������⻹��Ҫ���������ӵĸ���
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
		//�����ж��Ƿ�����������һ����ͬ��ɫ������
		for(int i = y1 ; i < y2 ; i++){
			if(board[posX][i] == ico && board[posX][i+1] == ico){
				count ++;
			}else if(count != others){
				count = 0;
			}
		}
		//�����ж��Ƿ�����������һ����ͬ��ɫ������
		for (int i = x1; i < x2; i++) {
			if(board[i][posY] == ico && board[i+1][posY] == ico){
				count ++;
			}else if(count != others){
				count = 0;
			}
		}
		//б���ж��Ƿ�����������һ����ͬ��ɫ������
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
