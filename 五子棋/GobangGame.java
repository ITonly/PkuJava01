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
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
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
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
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
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
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
	 * ������������
	 */
	public int[] computerDo() {
		
		String[][] board=chessboard.getBoard();
		//ˮƽ�����ж�
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
		//��ֱ�����ж�
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
		//ȡ�ĸ���������ֵ���Ӷ��������������ĸ�λ��
		int max=0;
		if(max<num1)max=num1;
		if(max<num2)max=num2;
		int x=0;
		int y=0;
		
		//ˮƽ�����жϣ�����ߺ����ұ��Ƿ�Ϊ��
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
				else if(board[posX][posY+1]=="ʮ"){
				
							x=posX;
							y=posY+1;
																	
				}else{
						do{
							x = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
							y = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
							//int result1[] ={x,y};
						}while(board[posX][posY]!="ʮ");
					}
			
		}else{
			if(board[posX][y0]=="ʮ"){
				x=posX;
				y=y0;
			}else if(board[posX][yy]=="ʮ"){
				x=posX;
				y=yy;
			}
			
		}
	}//��ֱ�����ж����Ϸ����̺����·������Ƿ�Ϊ��
		else if(max==num2){
			if(board[xx][posY]=="ʮ"){//���Ϸ��������Ƿ��ǿյ�
				x=xx;
				y=posY;
			}
			else if(board[num2][posY]=="ʮ"){//���·������Ƿ�Ϊ��
				x=num2;
				y=posY;
			}
	}		
		int[] result = { x, y };
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
		int x1 = 0;//x�������
		int x2 = 0;//x�յ�����
		int y1 = chessboard.BOARD_SIZE;//y�������
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
		//�����ж��Ƿ����������һ����ͬ��ɫ������
		for(int i = y1 ; i < y2 ; i++){
			if(board[posX][i] == ico && board[posX][i+1] == ico){
				count ++;
			}else if(count != others){
				count = 0;
			}
		}
		//�����ж��Ƿ����������һ����ͬ��ɫ������
		for (int i = x1; i < x2; i++) {
			if(board[i][posY] == ico && board[i+1][posY] == ico){
				count ++;
			}else if(count != others){
				count = 0;
			}
		}
		//б���ж��Ƿ����������һ����ͬ��ɫ������
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
