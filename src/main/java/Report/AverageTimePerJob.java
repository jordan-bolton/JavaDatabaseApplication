package Report;

import java.util.Date;
import Processing.*;

public class AverageTimePerJob extends Reports {

	private Job[] jobs;

	/**
	 * 
	 * @param report_name
	 * @param date
	 * @param jobs
	 */
	public AverageTimePerJob(String report_name, Date date, Job[] jobs) {
            super(report_name, date);
	}

	public void GenerateReport() {
		// TODO - implement AverageTimePerJob.GenerateReport
		throw new UnsupportedOperationException();
	}

}