//package com.alone;
//
//import java.sql.SQLException;
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//import java.util.UUID;
//
//import javax.sql.DataSource;
//
//import org.apache.commons.dbutils.QueryRunner;
//
//import com.alone.domain.BookClassInfomation;
//import com.alone.services.InformationOperation;
//import com.alone.services.impl.InformationOperationAchieve;
//import com.alone.util.DbUtils;
//
//public class Test {
//	public static void main(String[] args) throws SQLException {
//		DataSource dataSource = DbUtils.getDataSource();
//		QueryRunner runner = new QueryRunner(dataSource);
//		String sql  = "insert into book_name value(?,?,?,?,?,?,?)";
//		
//		int max=50;
//        int min=20;
//		
//        String date = new Date().toString();
//        InformationOperationAchieve informationOperationAchieve = InformationOperation.informationOperationAchieve();
//        List<BookClassInfomation> bookClass = informationOperationAchieve.getBookClass();
//        
//        for (BookClassInfomation bookClassInfomation : bookClass) {
//        		Random random = new Random();
//            int s = random.nextInt(max)%(max-min+1) + min;
//	        	for (int i = 0; i < s; i++) {
//	        		int maxnum=50;
//	            int minnum=0;
//	            Random ran = new Random();
//	            int num = ran.nextInt(maxnum)%(maxnum-minnum+1) + minnum;
//	            String uuid = UUID.randomUUID().toString().replace("-","");
//	    			System.out.println(bookClassInfomation.getId()+","+uuid+","+"xxx测试书籍,"+i+"-xxx作者,"+i+"-xxx出版,"+date+","+num);
//	    			runner.update(sql,bookClassInfomation.getId(),uuid,"xxx测试书籍",i+"-xxx作者",i+"-xxx出版",date,num);
//	    		}
//		}
//		
//	}
//
//}
