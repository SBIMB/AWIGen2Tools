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
	public static enum UploadResponseType { SUCCESSFULL, UNSUCCESSFULL };
	public static enum  AnticoagulantType  { 
		ACD("ACD"), EDTA("EDTA"), LH("Lithium Heparin (LH)"), KO("Potassium Oxalate (KO)"),  NaF("Sodium Fluoride (NaF)"), NA("N/A");

		private String description;
	
		AnticoagulantType(String description) {
			this.description = description;
		}		

		/**
		 * @return the description
		 */
		public String description() {
			return description;
		}

		public static boolean contains(String s){
			for(AnticoagulantType anticoagulantType : values()){
				if(anticoagulantType.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(AnticoagulantType anticoagulantType : values()){
				sb.append(anticoagulantType.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  Biotransactions { 
		PROCESSED, ALIQUOTED;
	
		public static boolean contains(String s){
			for(Biotransactions biotransaction : values()){
				if(biotransaction.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(Biotransactions biotransactions : values()){
				sb.append(biotransactions.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}	
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
	public static enum  Grade { 
		WS("Within Specification"), POOR("Poor"), NA("NA");
		
		private String description;
	
		Grade(String description) {
			this.description = description;
		}		

		/**
		 * @return the description
		 */
		public String description() {
			return description;
		}

		public static boolean contains(String s){
			for(Grade grade : values()){
				if(grade.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(Grade grade : values()){
				sb.append(grade.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  StoredIn { 
		MICROTUBE2D("Microtube 2D"), MICROTUBE("Microtube"), ORAGENE("Oragene"), DNA_SAL("DNA_SAL"), CRYOVIAL2ML("2ml Cryovial"), VACUTAINER("Vacutainer");
		
		private String description;
	
		StoredIn(String description) {
			this.description = description;
		}		

		/**
		 * @return the description
		 */
		public String description() {
			return description;
		}

		public static boolean contains(String s){
			for(StoredIn storedIn : values()){
				if(storedIn.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(StoredIn storedIn : values()){
				sb.append(storedIn.name());
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
	public static enum  Protocol { 
		ORAGENE("Oragene"), QIAGEN("Qiagen"), QIASYMPHONY("QiaSymphony"), SALTINGOUT("Salting out"), OTHER("Other"), UNKNOWN("Unknown");

		
		private String description;
	
		Protocol(String description) {
			this.description = description;
		}		

		/**
		 * @return the description
		 */
		public String description() {
			return description;
		}

		public static boolean contains(String s){
			for(Protocol protocol : values()){
				if(protocol.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(Protocol protocol : values()){
				sb.append(protocol.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  Quality { 
		AT("Ambient Temperature"), RST("Refrigerated Short term(<6mths)"), RLT("Refrigerated Long term(>6mths)"), FST("Frozen short term (<6mths)"), FLT("Frozen long term (>6mths)");

		private String description;
	
		Quality(String description) {
			this.description = description;
		}		

		/**
		 * @return the description
		 */
		public String description() {
			return description;
		}

		public static boolean contains(String s){
			for(Quality quality : values()){
				if(quality.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(Quality quality : values()){
				sb.append(quality.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  Status { 
		PENDING, RECEIVED, PROCESSED, DISCARDED;
	
		public static boolean contains(String s){
			for(Status status : values()){
				if(status.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(Status status : values()){
				sb.append(status.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  SubjectStatus { 
		WITHDRAWN, CURRENT, ARCHIVE;
	
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
	public static enum  Treatments { 
		AF("70% Alcohol Fixed"), FF("Formalin Fixed"), FROZEN("Frozen"), RL("RNA later"), RLFF("RNA later, then Formalin Fixed"), RLSF("RNA later, then Snap Frozen"), TC("Tissue Cultured"), UNPROCESSED("Unprocessed");
		
		private String description;
	
		Treatments(String description) {
			this.description = description;
		}		

		/**
		 * @return the description
		 */
		public String description() {
			return description;
		}

		public static boolean contains(String s){
			for(Treatments treatment : values()){
				if(treatment.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(Treatments treatment : values()){
				sb.append(treatment.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  Units { 
		ML("ml"), MG("mg"), UL("ul"), G("g");
		
		private String description;
	
		Units(String description) {
			this.description = description;
		}		

		/**
		 * @return the description
		 */
		public String description() {
			return description;
		}

		public static boolean contains(String s){
			for(Units units : values()){
				if(units.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(Units units : values()){
				sb.append(units.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	public static enum  ConsentStatus { 
		WITHDRAWN, CONSENT, UNKNOWN;
	
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
	public static enum  YesNoAnswers { 
		NO, YES, UNKNOWN;
	
		public static boolean contains(String s){
			for(YesNoAnswers yesNoAnswer : values()){
				if(yesNoAnswer.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(YesNoAnswers yesNoAnswer : values()){
				sb.append(yesNoAnswer.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	
	public static enum  TrueFalseAnswers { 
		FALSE, TRUE;
	
		public static boolean contains(String s){
			for(TrueFalseAnswers trueFalseAnswer : values()){
				if(trueFalseAnswer.name().equalsIgnoreCase(s))
					return true;
			}
			return false;
		}
		
		public static String getValues(){
			StringBuilder sb = new StringBuilder();
			for(TrueFalseAnswers trueFalseAnswer : values()){
				sb.append(trueFalseAnswer.name());
				sb.append(", ");
			}
			return sb.toString();			
		}
	}
	
	public static enum  BiospecimenTypes { 
		WHOLEBLOOD, BUFFYCOAT, CORDBLOOD, PLASMA, SERUM, DNA, RNA, DNALATER, TISSUE, URINE;
	
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
