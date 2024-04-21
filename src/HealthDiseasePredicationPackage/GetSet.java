package HealthDiseasePredicationPackage;

public class GetSet {
	static int DID;
	static int predictDID;
	static int PID;
	static String PName;
	static String gender;
	static int age;
	static String symptom_1;
	static String symptom_2;
	static String symptom_3;
	public static int getPredictDID() {
		return predictDID;
	}
	public static void setPredictDID(int predictDID) {
		GetSet.predictDID = predictDID;
	}
	
	public static String getPName() {
		return PName;
	}
	public static void setPName(String pName) {
		PName = pName;
	}
	public static String getGender() {
		return gender;
	}
	public static void setGender(String gender) {
		GetSet.gender = gender;
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		GetSet.age = age;
	}
	public static int getDID() {
		return DID;
	}
	public static void setDID(int dID) {
		DID = dID;
	}
	public static int getPID() {
		return PID;
	}
	public static void setPID(int pID) {
		PID = pID;
	}
	public static String getSymptom_1() {
		return symptom_1;
	}
	public static void setSymptom_1(String symptom_1) {
		GetSet.symptom_1 = symptom_1;
	}
	public static String getSymptom_2() {
		return symptom_2;
	}
	public static void setSymptom_2(String symptom_2) {
		GetSet.symptom_2 = symptom_2;
	}
	public static String getSymptom_3() {
		return symptom_3;
	}
	public static void setSymptom_3(String symptom_3) {
		GetSet.symptom_3 = symptom_3;
	}
	
}
