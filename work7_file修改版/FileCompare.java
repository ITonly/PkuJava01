
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class FileCompare {
    
	public static void main(String[] args) throws IOException {
		FileCompare c = new FileCompare();
		c.compareFile();
	}
	public void compareFile(){
		//File file = new File("e:/1.txt");
		File file = new File("e:"+File.separator+"1.txt");
		//File file2 = new File("e:/2.txt");
		File file2 = new File("e:"+File.separator+"2.txt");
		List<String> file1TextList = new ArrayList<String>();
		List<String> file2TextList = new ArrayList<String>();
		try {
			int num1=getText(file,file1TextList);
			int num2=getText(file2,file2TextList);
			System.out.println("1.txt单词的个数为："+num1);
			System.out.println("2.txt单词的个数为："+num2);
			System.out.println("2个文件的并集为：");
			List<String> intersection=compareList(file1TextList, file2TextList);
			Iterator<String> iter=intersection.iterator();
			System.out.println("2个文件的交集单词词汇表为：");
			while(iter.hasNext()){
				System.out.print(iter.next()+"、");
			}
			System.out.println();
			int secNum=intersection.size();
			System.out.println("2个文件交集单词词汇表的个数为："+secNum);
			System.out.println("wd∈1 且wd ∉2的单词占1文件的百分比为"+(double)(num1-secNum)/num1);
			System.out.println("wd∈2 且wd ∉1的单词占2文件的百分比为"+(double)(num2-secNum)/num2);
			
			//wd∈A 且wd ∉B的单词占A文件的百分比  和   wd∈B且 wd∉A的单词占B文件的百分比。
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
private List<String> compareList(List<String> text1List,List<String> text2List){
	List<String> interList = new ArrayList<String>();
	//Iterator<String> iter=interList.iterator();
	//int count=0;
	for(int i=0;i<text1List.size();i++){
		if(text2List.contains(text1List.get(i))){
			//count++;
			interList.add(text1List.get(i));
			continue;
			
		}else{
			System.out.print(text1List.get(i)+" ");
		}
	}
	for(int i=0;i<text2List.size();i++){
		System.out.print(text2List.get(i)+" ");
	}
	System.out.println();
	return interList;
//	System.out.println("2个文件交集单词的词汇表为：");
//	while(iter.hasNext()){
//		System.out.print(iter.next()+"、");
//	}
//	System.out.println("2个文件交集单词词汇表的个数为："+interList.size());
}
private int getText(File file,List<String> textList) throws IOException {
	BufferedReader br = null;
	InputStream is = null;
	try {
		is = new FileInputStream(file);
		br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String lineStr = null;
		while ((lineStr = br.readLine())!=null) {
			String[] word=lineStr.split(" ");
            for (int i = 0; i < word.length; i++) {
            	textList.add(word[i]);//存进ArrayList
       }
           
			//.add(lineStr);
		}
		if(br!=null){
			br.close();
		}
		if(is!=null){
			is.close();
		}
	}catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(br!=null){
			br.close();
		}
		if(is!=null){
			is.close();
		}
	}
	return textList.size();
}
}
