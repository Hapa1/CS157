import java.io.*; 
import java.util.*;

public class NaturalJoin {

	public static void main(String[] args) throws Exception {
		File file1= new File("dep.txt");
		File file2 = new File("emp.txt");
		BufferedReader br = new BufferedReader(new FileReader(file1));
		BufferedReader br2 = new BufferedReader(new FileReader(file2));
		String str;
		ArrayList<Row> rows1 = new ArrayList<Row>();
		ArrayList<Row> rows2 = new ArrayList<Row>();
		
		ArrayList<LinkedHashMap<String, ArrayList<String>>> maps = new ArrayList<LinkedHashMap<String, ArrayList<String>>>();
		
		while ((str = br.readLine()) != null) {
			String[] arrOfStr = str.split("	");
			ArrayList<String> arrlist = new ArrayList<String>();
			for(String s: arrOfStr){
				arrlist.add(s);
			}
			Row r = new Row(arrlist.get(0),arrlist);
			rows1.add(r);	
		}
		
		Table t = new Table(rows1, rows1.get(0).getContents());
		System.out.println("ToStrang");
		System.out.println(t.toString());
		
		while ((str = br2.readLine()) != null) {
			String[] arrOfStr = str.split("	");
			ArrayList<String> arrlist = new ArrayList<String>();
			for(String s: arrOfStr){
				arrlist.add(s);
			}
			Row r = new Row(arrlist.get(0),arrlist);
			rows2.add(r);	
		}
		Table t2 = new Table(rows2, rows2.get(0).getContents());
		System.out.println("ToStrang");
		System.out.println(t2.toString());
		
		join(t,t2);
	}
	
	public static void join(Table t1, Table t2) {
		System.out.println(t2.toString());
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for(String header2: t2.getHeader()){
			if(t1.getHeader().contains(header2)){
				int index = t2.getHeader().indexOf(header2);
				indexes.add(index);
			}
		}
		HashMap<String, String> m = new HashMap<String, String>();
		for(int j=1; j<t1.getRows().size(); j++) {
				m.put(t1.getRows().get(j).getContents().get(0), t1.getRows().get(j).omitKey().get(0));
		}
		for(int i=0; i<t2.getRows().size(); i++) {
			String val = m.get(t2.getRows().get(i).getContents().get(2));
			
			t2.getRows().get(i).addContents(val);
		}
		System.out.print(t2.getRows());
		
		System.out.println("");
		System.out.println(t2.toString());
	}
	
}

