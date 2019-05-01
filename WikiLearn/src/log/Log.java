package log;

import java.util.Date;

public class Log {
	
	private String sql;
	
	Date data;
	
	public Log() {
		
		this.data = new Date();
	}
	public void printSql (String sql) {
		
		System.out.println(this.data+" QUERY: "+sql);
	}

}
