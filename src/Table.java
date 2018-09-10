import java.util.ArrayList;

public class Table {

	private ArrayList<Row> rows;
	private ArrayList<String> headers;
	
	public Table(ArrayList<Row> rows, ArrayList<String> headers) {
		this.rows = rows;
		this.headers = headers;
	}
	
	public Table(){
		
	}
	
	public void addRow(Row row){
		rows.add(row);
	}
	
	public void addHeader(String s){
		headers.add(s);
	}
	
	public void setHeaders(ArrayList<String> h) {
		headers = h;
	}
	
	public ArrayList<String> getHeader(){
		return headers;
	}
	
	public ArrayList<Row> getRows(){
		return rows;
	}
	
	public String toString(){
		String str = "";
		//for(String s: headers){
		//	str = str + s + " ";
		//}
		//str = str + "\n";
		for(Row r: rows){
			for(String c: r.getContents()){
				str = str + c + " ";
			}
			str = str + "\n";
		}
		return str;
	}
	
	public static void main(String[] args) {
		String name = "Name";
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> headers = new ArrayList<String>();
		ArrayList<Row> rows = new ArrayList<Row>();
		headers.add("Id");
		headers.add("Name");
		headers.add("Location");
		arr.add("1");
		arr.add("Ryan");
		arr.add("Sacramento");
		Row r = new Row(arr.get(0), arr);
		rows.add(r);
		Table t = new Table(rows,headers);
		System.out.print(t.toString());
		//Header h = new Header(name,arr);
		//System.out.println(h.toString());
		

	}

}
