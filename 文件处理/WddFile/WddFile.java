package WddFile;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WddFile {
	
	public Map<String,Integer> countWords(String path)throws Exception{/*"D:\\WorkSpaceMyEclipse\\File\\bin\\a.txt"*/
             BufferedReader br = new BufferedReader(new FileReader(path));
             String s;
             StringBuffer sb = new StringBuffer();
             while ((s = br.readLine()) != null) {
                 sb.append(s);
             }
             Map<String,Integer> map = new HashMap<String, Integer>();
             StringTokenizer st = new StringTokenizer(sb.toString(),",.! \n");
             while (st.hasMoreTokens()) {
                 String letter = st.nextToken();
                 int count;
                 if (map.get(letter) == null) {
                     count = 1;
                 } else {
                     count = map.get(letter).intValue() + 1;
                 }
                 map.put(letter,count);
             }
            /* Set<WordEntity> set = new TreeSet<WordEntity>();
             for (String key : map.keySet()) {
                 set.add(new WordEntity(key,map.get(key)));
             }
             for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
                 WordEntity w = it.next();
                 System.out.println("单词:" + w.getKey() + " 出现的次数为： " + w.getCount());
             }*/
		 return map;
	}
	
	//并集
	public void union(Map<String,Integer> map1,Map<String,Integer> map2){
		Set<String> keySet1 = map1.keySet();//map1的key值集合keySet1
		Set<String> keySet2 = map2.keySet();//map2的key值集合keySet2
		String[] str = new String[1000];//用来存放符合条件的key
		int i = 0;
		int count = 0;
		for(String key1: keySet1){//遍历keySet1
			if (!map2.containsKey(key1)) {//如果map2里面不包括map1的值
				//System.out.println(String.format("map1与map2共有KEY值%1$s", key));
				str[i] = key1;//把这个属于map1，但不属于map2的key值放在str里
				i++;
				count++;
			}
		}
		for (String key2: keySet2) {//再把map2的所有的key值放进str里
			str[i] = key2;
			i++;
			count ++;
		}
		System.out.println("文件的并集为：");
		for (int j = 0; j < count; j++) {
			System.out.print(str[j]+" ");
		}
		System.out.println();
		System.out.println();
	}
	//交集
	public void intersection(Map<String,Integer> map1,Map<String,Integer> map2){
		Set<String> keySet1 = map1.keySet();
		String[] str = new String[1000];
		int i = 0;
		int count = 0;
		for(String key1: keySet1){//遍历map1里的key值集合keySet
			if (map2.containsKey(key1)) {//如果map2里也包含map1里的key值
				//System.out.println(String.format("map1与map2共有KEY值%1$s", key));
				str[i] = key1;
				i++;
				count++;
			}
		}
		System.out.println("文件的交集为：");
		for (int j = 0; j < count; j++) {
			System.out.print(str[j]+" ");
		}
		System.out.println();
	}
	//求总数和权重
	public void weigh(Map<String,Integer> map1,Map<String,Integer> map2){
		 Set<String> keySet1 = map1.keySet();
		 Set<String> keySet2 = map2.keySet();
		 Set<WordEntity> set1 = new TreeSet<WordEntity>();
		 Set<WordEntity> set2 = new TreeSet<WordEntity>();
		 int count1 = 0;
		 int count2 = 0;
		 int counta = 0;
		 int countb = 0;
        for (String key1 : map1.keySet()) {//将map1的key值集合加到wordEntity类里，以便运用该单词的频率计算
            set1.add(new WordEntity(key1,map1.get(key1)));
        }
        for (Iterator<WordEntity> it1 = set1.iterator(); it1.hasNext(); ) {
            WordEntity w1 = it1.next();
            if (!map2.containsKey(w1.getKey())){//计算属于a不属于b的单词出现的频率之和，以便求权重
            	counta += w1.getCount();
            }
            //count1 ++;
            count1 +=w1.getCount();//计算a里面所有单词的总数，即所有单词出现的频率之和
        }
        System.out.println("文件a单词数为："+count1);
        System.out.println("只属于文件a单词数为："+counta);
        System.out.println("文件a中只属于a的单词比重："+(float)counta/count1);
        System.out.println();
        for (String key2 : map2.keySet()) {
            set2.add(new WordEntity(key2,map2.get(key2)));
        }
        for (Iterator<WordEntity> it2 = set2.iterator(); it2.hasNext(); ) {
            WordEntity w2 = it2.next();
            if (!map1.containsKey(w2.getKey())){//计算属于b不属于a的单词出现的频率之和，以便求权重
            	countb += w2.getCount();
            }
           // System.out.println("单词:" + w2.getKey() + " 出现的次数为： " + w2.getCount());
           //count2 ++;
            count2 +=w2.getCount();//计算b里面所有单词的总数，即所有单词出现的频率之和
        }
        System.out.println("文件b单词数为："+count2);
        System.out.println("只属于文件b单词数为："+countb);
        System.out.println("文件b中只属于b的单词比重："+(float)countb/count2);
        System.out.println();	
	}
	 public static void main(String[] args) throws Exception {
		 WddFile wf = new WddFile();
		 Map<String,Integer> map1 = wf.countWords("D:\\WorkSpaceMyEclipse\\File\\bin\\a.txt");
		 System.out.println("文件a单词内容：");
		 System.out.println(map1);
		 Map<String,Integer> map2 = wf.countWords("D:\\WorkSpaceMyEclipse\\File\\bin\\b.txt");
		 System.out.println("文件b单词内容：");
		 System.out.println(map2);
		 System.out.println();
		 wf.intersection(map1, map2);
		 wf.union(map1, map2);
		 wf.weigh(map1, map2);
	 }
}
