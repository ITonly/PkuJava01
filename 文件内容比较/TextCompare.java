import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextCompare {
	
	File a;
	File b;
	
	public TextCompare(String apath,String bpath){
		a = new File(apath);
		b = new File(bpath);
	}
	//求两文件单词的并集
	public List<String> bingJi() throws Exception{
		List<String> aList = new TextFile(a).toList();
		List<String> bList = new TextFile(b).toList();
		
		aList.removeAll(bList);
		aList.addAll(bList);
		
		return aList;
		
	}
	//求两文件单词的交集
	public List<String> jiaoJi() throws Exception{
		List<String> aList = new TextFile(a).toList();
		List<String> bList = new TextFile(b).toList();
		
		aList.retainAll(bList);
		return aList;
	}
	//差集占各自的百分比
	public float[] percent() throws Exception{
		float[] result = new float[2];
		List<String> aList = new TextFile(a).toList();
		List<String> bList = new TextFile(b).toList();
		
		//List<String> aList1 = new ArrayList<String>(aList.size());  
		//...........Source does not fit in dest  
        //Collections.copy(aList1, aList);

		List<String> aList1 = new ArrayList<String>(aList);
        /*List<String> bList1 = new ArrayList<String>(bList.size());
        Collections.copy(bList1, bList);*/
        
        List<String> bList1 = new ArrayList<String>(bList);

		aList.removeAll(bList);
		
		bList.removeAll(aList1);
		
		System.out.print("aList:");
		for(String list:aList){
			System.out.print(list+" ");
		}
		System.out.println();
		System.out.print("aList1:");
		for(String list:aList1){
			System.out.print(list+" ");
		}
		System.out.println();
		
		System.out.print("bList:");
		for(String list:bList){
			System.out.print(list+" ");
		}
		System.out.println();
		System.out.print("bList1:");
		for(String list:bList1){
			System.out.print(list+" ");
		}
		System.out.println();
		
		result[0]=(float)aList.size()/aList1.size();
		result[1]=(float)bList.size()/bList1.size();
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		
		String aPath = "D://a.txt";
		String bPath = "D://b.txt";
		TextCompare two = new TextCompare(aPath,bPath);
		List<String> bing = two.bingJi();
		List<String> jiao = two.jiaoJi();
		float[] percent = two.percent();
		
		System.out.println("两文件并集是：");
		for(String list:bing){
			System.out.print(list+" ");
		}
		System.out.println();
		
		System.out.println("两文件交集是：");
		for(String list:jiao){
			System.out.print(list+" ");
		}
		System.out.println();
		
		System.out.println("差集分别的百分比是：");
		for(int i = 0;i<2;i++){
			System.out.print(percent[i]+" ");
		}
	}
	
	class TextFile{
		File file;
		public TextFile(File file){
			this.file=file;
		}
		public List<String> toList() throws Exception{
			FileInputStream fileIS = new FileInputStream(file);
			InputStreamReader fileISR = new InputStreamReader(fileIS);
			BufferedReader fileBR = new BufferedReader(fileISR);
			
			String input;
			StringBuffer fileSB = new StringBuffer();
			
			while((input=fileBR.readLine())!=null){
				fileSB.append(input);
			}
			
			String fileS = fileSB.toString();
			String[] fileWords = fileS.split(" ");
			List<String> list = new ArrayList<String>();
			
			for(int i=0;i<fileWords.length;i++){
				list.add(fileWords[i]);
			}
			return list;
		}
		
	}

}
