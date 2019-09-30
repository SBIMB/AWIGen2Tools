/**
 * 
 */
package za.org.wits.sbimb.shipment;

/**
 * @author Freedom Mukomana
 *
 */
public class Constants {

	public static String[] PARTICIPANT_UPLOAD_HEADER = {"NO","STUDY ID","STATUS","ENROLLMENT DATE","AGE","OTHER ID","ETHNICITY","GENDER","COMMENTS","CONSENT DATE","CONSENT STATUS","DATA USE","BIOSPECIMEN USE","DATA SHARING","BIOSPECIMEN SHARING"};
	public static String[] PARTICIPANT_PROP_VALUE = {"No","studyID","status","enrollmentDate","age","otherID","ethnicity","gender","comments","consentDate","consentStatus","dataUse","biospecimenUse","dataSharing","biospecimenSharing"};
	public static String[] PARTICIPANT_PROP_TYPE = {"No","String","String","Date","Integer","String","String","String","String","Date","String","String","String","String","String"};
	public static String[] BIOSPECIMEN_UPLOAD_HEADER = {"NO","STUDY ID","GENDER","BIOSPECIMEN ID","COLLECTION DATE","BIOSPECIMEN TYPE","COLUMN","ROW","MANUAL CHECK"};
	public static String[] BIOSPECIMEN_PROP_VALUE = {"No","studyID","gender","biospecimenID","collectionDate","biospecimenType","col","row","manualChecked"};
	public static String[] BIOSPECIMEN_PROP_TYPE = {"No","String","String","String","Date","String","String","String","String"};
	public static String [] PARTICIPANT_COLUMN_HEADER = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
	public static enum DataErrorType { MISSING, INCORRECT };
	public static enum  CollectionCentres { 
		AGINICOURT, DIMAMO, NAIROBI, APHRC, NANORO, NAVRONGO, SOWETO, DPHRU;
	
		public static boolean contains(String s){
			for(CollectionCentres centre : values()){
				if(centre.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(CollectionCentres centre : values()){
				sb.append(centre.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  Ethnicity { 
		ADMIXED, AFRICAN, EUROPEAN, ASIAN, OTHER, UNKNOWN;
	
		public static boolean contains(String s){
			for(Ethnicity ethnicity : values()){
				if(ethnicity.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(Ethnicity ethnicity : values()){
				sb.append(ethnicity.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  Gender { 
		FEMALE, MALE, UNKNOWN;
	
		public static boolean contains(String s){
			for(Gender gender : values()){
				if(gender.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(Gender gender : values()){
				sb.append(gender.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  SubjectStatus { 
		CURRENT, WITHDRAWN, ARCHIVE;
	
		public static boolean contains(String s){
			for(SubjectStatus subjectStatus : values()){
				if(subjectStatus.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(SubjectStatus subjectStatus : values()){
				sb.append(subjectStatus.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  ConsentStatus { 
		CONSENT, WITHDRAWN, UNKNOWN;
	
		public static boolean contains(String s){
			for(ConsentStatus consentStatus : values()){
				if(consentStatus.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(ConsentStatus consentStatus : values()){
				sb.append(consentStatus.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  ConsentAnswers { 
		YES, NO, UNKNOWN;
	
		public static boolean contains(String s){
			for(ConsentAnswers consentAnswer : values()){
				if(consentAnswer.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(ConsentAnswers consentAnswer : values()){
				sb.append(consentAnswer.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  BiospecimenTypes { 
		WHOLEBLOOD(), BUFFYCOAT, CORDBLOOD, PLASMA, SERUM, DNA, RNA, DNALATER, TISSUE, URINE;
	
		public static boolean contains(String s){
			for(BiospecimenTypes biospecimenType : values()){
				if(biospecimenType.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(BiospecimenTypes biospecimenType : values()){
				sb.append(biospecimenType.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
}
