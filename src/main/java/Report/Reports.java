package Report;

import java.util.Date;

public abstract class Reports {

	private String report_name;
	private Date date;

	/**
	 * 
	 * @param report_name
	 * @param date
	 */
	public Reports(String report_name, Date date) {

	}

	/**
	 * 
	 * @param report_name
	 * @param date
	 */
	public void DisplayReport(String report_name, Date date) {
		// TODO - implement Reports.DisplayReport
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param report_name
	 * @param date
	 */
	public void PrintReport(String report_name, Date date) {
		// TODO - implement Reports.PrintReport
		throw new UnsupportedOperationException();
	}

	public abstract void GenerateReport();

}