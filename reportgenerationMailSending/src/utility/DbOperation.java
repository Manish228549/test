package utility;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class DbOperation 
{
	public static String getRecord()
	{
		System.out.println("Enter the Project name for report generation ");
		Scanner sc = new Scanner(System.in);
		String ProjectName =sc.next(); // Enter here project name (Note project name generally small rahta of less than 1 line , esliye humne sc.next() liya hai nextLine nahi
		
		
		StringBuilder message = new StringBuilder();
		String countEqual = null;
		String countUnEqual = null;
		
		
		PreparedStatement psmt=null;
		PreparedStatement pstmtUnequal =null;
		
		try 
		{
			
	
			String sql = "SELECT count(ProjectName) as \"All pdf downloaded\" FROM "+AppProperties.database+"."+AppProperties.table+" WHERE (TotalPdfInIpo = TotalPdfDownloaded) and ProjectName=? group by ProjectName=?" ;
			System.out.println(AppProperties.database+"."+AppProperties.table);

			String sqlUnequal = "SELECT count(ProjectName) as \"All pdf not downloaded\" FROM "+AppProperties.database+"."+AppProperties.table+" WHERE (TotalPdfInIpo != TotalPdfDownloaded) and ProjectName=? group by ProjectName=?";
			
			
//			
			psmt= AppProperties.myCon.prepareStatement(sql);
			psmt.setString(1, ProjectName);
			psmt.setString(2, ProjectName);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				countEqual = rs.getString("All pdf downloaded");

			}
			
			System.out.println(countEqual);
			
	// *******************************************************************************************************************************
			
			pstmtUnequal = AppProperties.myCon.prepareStatement(sqlUnequal);
			pstmtUnequal.setString(1, ProjectName);
			pstmtUnequal.setString(2, ProjectName);
			ResultSet rsUnequal = pstmtUnequal.executeQuery();
			
			while(rsUnequal.next())
			{
				
				countUnEqual = rsUnequal.getString("All pdf not downloaded");

			}
			System.out.println(countUnEqual);
				
			
			 ;
			 message .append("<html>");
			 message .append("<body>");
			 message .append("<p>Hi Sir, </p>");
			 message .append("<p>Please find the customised output. Note : this message is sent from java program</p></br>");
			 message .append("<table border=\"2\" solid black style=\"border-collapse: collapse;\">");
//			 border:2px solid;color:blue;text-align:center;
			 message .append("<tr>");
			 message .append("<th>Project_Name</th>");
			 message .append("<th>Total Tans</th>");
			 message .append("<th>All pdf downloaded</th>");
			 message .append("<th>All pdf not downloaded</th>");
			 message .append("</tr>");

			 message .append("<tr>");
			 message .append("<td>"+ProjectName+"</td>");
			 message .append("<td>"+(Integer.parseInt(countEqual)+Integer.parseInt(countUnEqual))+"</td>");
			 message .append("<td>"+countEqual+"</td>");
			 message .append("<td>"+countUnEqual+"</td>");
			 message .append("</tr>");
			 message .append("</table>");
			 message .append("<br>");
			 message .append("<p>Thanks And Regards<br>Manish Kumar</p>"); 

			 message .append("</body>");
			 message .append("</html>");
		
			
//			message = "Project Name : "+ProjectName+"\nTotal No Of Projects whose TotalPdfInIpo and TotalPdfDownloaded is equal : "+countEqual +"\nTotal No Of Projects whose TotalPdfInIpo and TotalPdfDownloaded is not equal : "+countUnEqual ;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		
		return message.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
