package serializationDeserialization;

public class ThingSpeak {

	public Integer field1;
	public Integer field2;
	
	public int getField1() {
		return field1;
	}
	
	public void setField1(Integer field1) {
		this.field1 = field1;
	}
	
	public int getField2() {
		return field2;
	}
	
	public void setField2(Integer field2) {
		this.field2 = field2;
	}
	
	
	public String getFieldsrecord() {
		return(this.field1+" "+this.field2);
	}
}
