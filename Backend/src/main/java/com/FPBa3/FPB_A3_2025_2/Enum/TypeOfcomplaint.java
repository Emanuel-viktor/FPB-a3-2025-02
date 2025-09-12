package com.FPBa3.FPB_A3_2025_2.Enum;

public enum TypeOfcomplaint {
	
VIOLENCIA(1),
FURTO(2),
ASSALTO(3),
ACIDENTE(4),
HOMICIDIO(5),
OUTROS(6);
	private int code;
	
	private TypeOfcomplaint(int code) {
		this.code=code;
	}
	public int getCode() {
		return code;
	}
	public static TypeOfcomplaint valueOf (int code) throws IllegalAccessException {
		for(TypeOfcomplaint value : TypeOfcomplaint.values()){
			if(value.getCode()==code) {
				return value;
			}
		}
		throw new IllegalAccessException("Invalid TypeOfcomplaint code");
	}
}
