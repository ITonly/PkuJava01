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
                 System.out.println("����:" + w.getKey() + " ���ֵĴ���Ϊ�� " + w.getCount());
             }*/
		 return map;
	}
	
	//����
	public void union(Map<String,Integer> map1,Map<String,Integer> map2){
		Set<String> keySet1 = map1.keySet();//map1��keyֵ����keySet1
		Set<String> keySet2 = map2.keySet();//map2��keyֵ����keySet2
		String[] str = new String[1000];//������ŷ���������key
		int i = 0;
		int count = 0;
		for(String key1: keySet1){//����keySet1
			if (!map2.containsKey(key1)) {//���map2���治����map1��ֵ
				//System.out.println(String.format("map1��map2����KEYֵ%1$s", key));
				str[i] = key1;//���������map1����������map2��keyֵ����str��
				i++;
				count++;
			}
		}
		for (String key2: keySet2) {//�ٰ�map2�����е�keyֵ�Ž�str��
			str[i] = key2;
			i++;
			count ++;
		}
		System.out.println("�ļ��Ĳ���Ϊ��");
		for (int j = 0; j < count; j++) {
			System.out.print(str[j]+" ");
		}
		System.out.println();
		System.out.println();
	}
	//����
	public void intersection(Map<String,Integer> map1,Map<String,Integer> map2){
		Set<String> keySet1 = map1.keySet();
		String[] str = new String[1000];
		int i = 0;
		int count = 0;
		for(String key1: keySet1){//����map1���keyֵ����keySet
			if (map2.containsKey(key1)) {//���map2��Ҳ����map1���keyֵ
				//System.out.println(String.format("map1��map2����KEYֵ%1$s", key));
				str[i] = key1;
				i++;
				count++;
			}
		}
		System.out.println("�ļ��Ľ���Ϊ��");
		for (int j = 0; j < count; j++) {
			System.out.print(str[j]+" ");
		}
		System.out.println();
	}
	//��������Ȩ��
	public void weigh(Map<String,Integer> map1,Map<String,Integer> map2){
		 Set<String> keySet1 = map1.keySet();
		 Set<String> keySet2 = map2.keySet();
		 Set<WordEntity> set1 = new TreeSet<WordEntity>();
		 Set<WordEntity> set2 = new TreeSet<WordEntity>();
		 int count1 = 0;
		 int count2 = 0;
		 int counta = 0;
		 int countb = 0;
        for (String key1 : map1.keySet()) {//��map1��keyֵ���ϼӵ�wordEntity����Ա����øõ��ʵ�Ƶ�ʼ���
            set1.add(new WordEntity(key1,map1.get(key1)));
        }
        for (Iterator<WordEntity> it1 = set1.iterator(); it1.hasNext(); ) {
            WordEntity w1 = it1.next();
            if (!map2.containsKey(w1.getKey())){//��������a������b�ĵ��ʳ��ֵ�Ƶ��֮�ͣ��Ա���Ȩ��
            	counta += w1.getCount();
            }
            //count1 ++;
            count1 +=w1.getCount();//����a�������е��ʵ������������е��ʳ��ֵ�Ƶ��֮��
        }
        System.out.println("�ļ�a������Ϊ��"+count1);
        System.out.println("ֻ�����ļ�a������Ϊ��"+counta);
        System.out.println("�ļ�a��ֻ����a�ĵ��ʱ��أ�"+(float)counta/count1);
        System.out.println();
        for (String key2 : map2.keySet()) {
            set2.add(new WordEntity(key2,map2.get(key2)));
        }
        for (Iterator<WordEntity> it2 = set2.iterator(); it2.hasNext(); ) {
            WordEntity w2 = it2.next();
            if (!map1.containsKey(w2.getKey())){//��������b������a�ĵ��ʳ��ֵ�Ƶ��֮�ͣ��Ա���Ȩ��
            	countb += w2.getCount();
            }
           // System.out.println("����:" + w2.getKey() + " ���ֵĴ���Ϊ�� " + w2.getCount());
           //count2 ++;
            count2 +=w2.getCount();//����b�������е��ʵ������������е��ʳ��ֵ�Ƶ��֮��
        }
        System.out.println("�ļ�b������Ϊ��"+count2);
        System.out.println("ֻ�����ļ�b������Ϊ��"+countb);
        System.out.println("�ļ�b��ֻ����b�ĵ��ʱ��أ�"+(float)countb/count2);
        System.out.println();	
	}
	 public static void main(String[] args) throws Exception {
		 WddFile wf = new WddFile();
		 Map<String,Integer> map1 = wf.countWords("D:\\WorkSpaceMyEclipse\\File\\bin\\a.txt");
		 System.out.println("�ļ�a�������ݣ�");
		 System.out.println(map1);
		 Map<String,Integer> map2 = wf.countWords("D:\\WorkSpaceMyEclipse\\File\\bin\\b.txt");
		 System.out.println("�ļ�b�������ݣ�");
		 System.out.println(map2);
		 System.out.println();
		 wf.intersection(map1, map2);
		 wf.union(map1, map2);
		 wf.weigh(map1, map2);
	 }
}
