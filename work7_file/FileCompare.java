
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
		File file = new File("e:/1.txt");
		File file2 = new File("e:/2.txt");
		List<String> file1TextList = new ArrayList<String>();
		List<String> file2TextList = new ArrayList<String>();
		try {
			System.out.println("1.txt单词的个数为："+getText(file,file1TextList));
			System.out.println("2.txt单词的个数为："+getText(file2,file2TextList));
			System.out.println("2个文件的并集为：");
			compareList(file1TextList, file2TextList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
private void compareList(List<String> text1List,List<String> text2List){
	int count=0;
	for(int i=0;i<text1List.size();i++){
		if(text2List.contains(text1List.get(i))){
			count++;
			continue;
			
		}else{
			System.out.print(text1List.get(i)+" ");
		}
	}
	for(int i=0;i<text2List.size();i++){
		System.out.print(text2List.get(i)+" ");
	}
	System.out.println();
	System.out.println("2个文件交集单词词汇表的个数为："+count);
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
