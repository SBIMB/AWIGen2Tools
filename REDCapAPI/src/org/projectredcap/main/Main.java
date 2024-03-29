package org.projectredcap.main;

public class Main
{
	public static void main(final String[] args)
	{
		final Config c = new Config("https://redcap.core.wits.ac.za/redcap/api/", //API URL
				"03F69DF758E684976D55B604ADDF2F31", //API Token
				"flat", //API CONTENT
				"csv", //API FORMAT
				"record", //API TYPE
				"overwrite", //API_OVERWRITE_BEHAVIOR 
				"true", //API FORCE AUTO NUMBER
				"DMY", //API DATE FORMAT 
			    "raw", //API ROW OR LABEL
			   "", //API FIELDS
			   null); //API REPORT ID
		String result= null;
			    

		//final ExportArms exportArms = new ExportArms(c);
		//exportArms.doPost();

		//final ExportFile exportFile = new ExportFile(c);
		//exportFile.doPost();

		//final ExportInstrumentsPDF exportInstrumentsPDF = new ExportInstrumentsPDF(c);
		//exportInstrumentsPDF.doPost();

		//final DeleteFile deleteFile = new DeleteFile(c);
		//deleteFile.doPost();

		//final ImportFile importFile = new ImportFile(c);
		//importFile.doPost();

		//final ImportRecords importRecords = new ImportRecords(c);
		//importRecords.doPost();

		//final ExportUsers exportUsers = new ExportUsers(c);
		//exportUsers.doPost();

		//final ExportSurveyReturnCode exportSurveyReturnCode = new ExportSurveyReturnCode(c);
		//exportSurveyReturnCode.doPost();

		//final ExportSurveyQueueLink exportSurveyQueueLink = new ExportSurveyQueueLink(c);
		//exportSurveyQueueLink.doPost();

		//final ExportSurveyParticipants exportSurveyParticipants = new ExportSurveyParticipants(c);
		//exportSurveyParticipants.doPost();

		//final ExportSurveyLink exportSurveyLink = new ExportSurveyLink(c);
		//exportSurveyLink.doPost();

		//final ExportReports exportReports = new ExportReports(c);
		//result = exportReports.doPost().toString();

		//final ExportREDCapVersion exportREDCapVersion = new ExportREDCapVersion(c);
		//exportREDCapVersion.doPost();

		final ExportRecords exportRecords = new ExportRecords(c);
		result = exportRecords.doPost().toString();

		//final ExportProject exportProject = new ExportProject(c);
		//exportProject.doPost();

		//final ExportMetatdata exportMetatdata = new ExportMetatdata(c);
		//exportMetatdata.doPost();

		//final ExportInstrumentEventMaps exportInstrumentEventMaps = new ExportInstrumentEventMaps(c);
		//exportInstrumentEventMaps.doPost();

		//final ExportInstruments exportInstrument = new ExportInstruments(c);
		//exportInstrument.doPost();

		//final ExportFieldNames exportFieldNames = new ExportFieldNames(c);
		//exportFieldNames.doPost();

		//final ExportEvents exportEvents = new ExportEvents(c);
		//exportEvents.doPost();
		System.out.println("result: " + result.toString());
	}
	
}
